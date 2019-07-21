package com.caihao.dubboconsumer01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/7/7 11:53
 */
@SpringBootApplication(scanBasePackages = "com.caihao.dubboconsumer01.controller")
public class ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }
}
