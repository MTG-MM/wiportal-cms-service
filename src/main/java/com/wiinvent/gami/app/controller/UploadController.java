package com.wiinvent.gami.app.controller;

import com.wiinvent.gami.domain.response.UploadResponse;
import com.wiinvent.gami.domain.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/vt/cms/images/upload")
public class UploadController {
  @Autowired
  private UploadService uploadService;

  @PostMapping("static")
  public ResponseEntity<UploadResponse> uploadStatic(@RequestParam("image_url") MultipartFile file){
    return ResponseEntity.ok(uploadService.uploadStatic(file));
  }
}
