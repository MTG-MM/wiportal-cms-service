package com.wiinvent.gami.domain.service;

import com.wiinvent.gami.domain.dto.gvc.GvcPackageCreateDto;
import com.wiinvent.gami.domain.dto.gvc.GvcPackageUpdateDto;
import com.wiinvent.gami.domain.entities.gvc.GvcPackage;
import com.wiinvent.gami.domain.entities.type.Status;
import com.wiinvent.gami.domain.exception.base.ResourceNotFoundException;
import com.wiinvent.gami.domain.response.GvcPackageResponse;
import com.wiinvent.gami.domain.utils.Constant;
import com.wiinvent.gami.domain.utils.DateUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Log4j2
public class GvcPackageService extends BaseService{
  @Autowired @Lazy private GvcPackageService self;
  public Page<GvcPackageResponse> findAll(Pageable pageable){
    Page<GvcPackage> gvcPackages = gvcPackageStorage.findAll(pageable);
    return modelMapper.toPageGvcPackageResponse(gvcPackages);
  }

  public GvcPackageResponse getGvcPackageDetail(Integer id){
    //validation
    GvcPackage gvcPackage = gvcPackageStorage.findById(id);
    if(Objects.isNull(gvcPackage)) throw new ResourceNotFoundException(Constant.GVC_PACKAGE_NOT_FOUND);
    //response
    return modelMapper.toGvcPackageResponse(gvcPackage);
  }

  public boolean createGvcPackage(GvcPackageCreateDto dto){
    //validation
    if(Objects.isNull(dto.getStatus())) dto.setStatus(Status.ACTIVE);
    //map
    GvcPackage gvcPackage = modelMapper.toGvcPackage(dto);
    //save
    try {
      self.save(gvcPackage);
    }catch (Exception e){
      log.debug("==============>createGvcPackage:DB:Exception:{}", e.getMessage());
      return false;
    }
    //cache
    try {
      remoteCache.deleteKey(cacheKey.getGvcPackages());
    }catch (Exception e){
      log.debug("==============>createGvcPackage:Cache:Exception:{}", e.getMessage());
    }
    return true;
  }

  public boolean updateGvcPackage(GvcPackageUpdateDto dto){
    //validation
    GvcPackage gvcPackage = gvcPackageStorage.findById(dto.getId());
    if(Objects.isNull(gvcPackage)) throw new ResourceNotFoundException(Constant.GVC_PACKAGE_NOT_FOUND);
    //map
    modelMapper.mapGvcPackageUpdateDtoToGvcPackage(dto, gvcPackage);
    gvcPackage.setUpdatedAt(DateUtils.getNowMillisAtUtc());
    //save
    try {
      self.save(gvcPackage);
    }catch (Exception e){
      log.debug("==============>updateGvcPackage:DB:Exception:{}", e.getMessage());
      return false;
    }
    //cache
    try {
      remoteCache.deleteKey(cacheKey.getGvcPackages());
      remoteCache.deleteKey(cacheKey.getGvcPackageByCode(gvcPackage.getCode()));
    }catch (Exception e){
      log.debug("==============>updateGvcPackage:Cache:Exception:{}", e.getMessage());
    }
    return true;
  }

  public boolean deleteGvcPackage(Integer id){
    //validation
    GvcPackage gvcPackage = gvcPackageStorage.findById(id);
    if(Objects.isNull(gvcPackage)) throw new ResourceNotFoundException(Constant.GVC_PACKAGE_NOT_FOUND);
    //map
    gvcPackage.setStatus(Status.DELETE);
    gvcPackage.setUpdatedAt(DateUtils.getNowMillisAtUtc());
    //save
    try {
      self.save(gvcPackage);
    }catch (Exception e){
      log.debug("==============>deleteGvcPackage:DB:Exception:{}", e.getMessage());
      return false;
    }
    //cache
    try {
      remoteCache.deleteKey(cacheKey.getGvcPackages());
      remoteCache.deleteKey(cacheKey.getGvcPackageByCode(gvcPackage.getCode()));
    }catch (Exception e){
      log.debug("==============>deleteGvcPackage:Cache:Exception:{}", e.getMessage());
    }
    return true;
  }


  @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
  public void save(GvcPackage gvcPackage){
    gvcPackageStorage.save(gvcPackage);
  }
}