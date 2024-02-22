package com.managersystem.admin.server.stores;

import com.managersystem.admin.server.entities.ProductDetail;
import com.managersystem.admin.server.entities.type.PollItemStatus;
import com.managersystem.admin.server.stores.base.BaseStorage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductDetailStorage extends BaseStorage {

  public List<ProductDetail> findAll() {
    return productDetailRepository.findAll();
  }

  public void save(ProductDetail productDetail) {
    productDetailRepository.save(productDetail);
  }

  public Page<ProductDetail> findAll(Pageable pageable) {
    return productDetailRepository.findAll(pageable);
  }

  public ProductDetail findById(UUID id) {
    return productDetailRepository.findById(id).orElse(null);
  }

  public void saveAll(List<ProductDetail> productDetails) {
    productDetailRepository.saveAll(productDetails);
  }

  public List<ProductDetail> getListProductDetailByStatus(int productStoreId, PollItemStatus pollItemStatus, int limit) {
    Pageable pageable = PageRequest.of(0, limit);
    return productDetailRepository.getListProductDetailByStatus(productStoreId, pollItemStatus, pageable);
  }

  public void updateItemStatus(Long rewardSegmentDetailId) {
    productDetailRepository.updateItemStatus(rewardSegmentDetailId);
  }
}