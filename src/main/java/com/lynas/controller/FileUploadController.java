package com.lynas.controller;

import com.lynas.domain.entity.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class FileUploadController {

  @PostMapping("/upload")
  public R<String> fileUpload(MultipartFile file) throws IOException {
    String originalFilename = file.getOriginalFilename();
    String name = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf('.' ));
    file.transferTo(new File("C:\\Users\\trait\\Desktop\\files\\" + name));
    return R.success("模拟地址");
  }
}
