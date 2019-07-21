package com.caihao.dubboconsumer01.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.caihao.dubboprovider01.entity.Doctor;
import com.caihao.dubboprovider01.entity.Result;
import com.caihao.dubboprovider01.entity.ResultEnum;
import com.caihao.dubboprovider01.service.DoctorService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/7/7 15:14
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

  @Reference(version = "1.0",
      application = "${dubbo.application.id}",
      url = "dubbo://localhost:12345")
  private DoctorService doctorService;

  @GetMapping("/get_list")
  public Result<List<Doctor>> getDoctorList() {
    List<Doctor> doctorList = doctorService.getDoctorList();
    for (Doctor doctor : doctorList) {
      System.out.println(doctor);
    }
    Result<List<Doctor>> result = new Result<>(ResultEnum.SUCCESS, doctorList);
    System.out.println(result.getMsg());
    return result;
  }

  @GetMapping("/test")
  public Result<String> test(){
    return new Result<>(0,"成功","test success");
  }
}
