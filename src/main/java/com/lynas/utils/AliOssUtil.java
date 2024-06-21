package com.lynas.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
@Data
@ConfigurationProperties(prefix = "ali-oss")
public class AliOssUtil {

  private String endpoint;

  private String accessId;

  private String accessSecret;

  private String bucketName;

  private static String STATIC_ENDPOINT;

  private static String STATIC_ACCESS_ID;

  private static String STATIC_ACCESS_SECRET;

  private static String STATIC_BUCKET_NAME;

  @PostConstruct
  public void setVal() {
     this.STATIC_ENDPOINT = endpoint;
     this.STATIC_ACCESS_ID = accessId;
     this.STATIC_ACCESS_SECRET = accessSecret;
     this.STATIC_BUCKET_NAME = bucketName;
  }

  public static String uploadFile(String filename, InputStream in) throws Exception {
    // 创建OSSClient实例。
    OSS ossClient = new OSSClientBuilder().build(STATIC_ENDPOINT, STATIC_ACCESS_ID, STATIC_ACCESS_SECRET);

    String url = "";
    try {
      // 创建PutObjectRequest对象。
      PutObjectRequest putObjectRequest = new PutObjectRequest(STATIC_BUCKET_NAME, filename, in);

      // 上传
      ossClient.putObject(putObjectRequest);
      url = "https://" + STATIC_BUCKET_NAME + '.' + STATIC_ENDPOINT.substring(8) + '/' + filename;
    } catch (OSSException oe) {
      System.out.println("Caught an OSSException, which means your request made it to OSS, "
        + "but was rejected with an error response for some reason.");
      System.out.println("Error Message:" + oe.getErrorMessage());
      System.out.println("Error Code:" + oe.getErrorCode());
      System.out.println("Request ID:" + oe.getRequestId());
      System.out.println("Host ID:" + oe.getHostId());
    } catch (ClientException ce) {
      System.out.println("Caught an ClientException, which means the client encountered "
        + "a serious internal problem while trying to communicate with OSS, "
        + "such as not being able to access the network.");
      System.out.println("Error Message:" + ce.getMessage());
    } finally {
      if (ossClient != null) {
        ossClient.shutdown();
      }
    }
    return url;
  }
}
