package com.lynas.controller;

import com.lynas.domain.entity.R;
import com.lynas.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {


  @PostMapping("/upload")
  public R<String> fileUpload(MultipartFile file) throws Exception {
    String originalFilename = file.getOriginalFilename();
    String name = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf('.'));
    String url = AliOssUtil.uploadFile(name, file.getInputStream());
    return R.success(url);
  }
}
