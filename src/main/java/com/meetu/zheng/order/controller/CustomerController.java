package com.meetu.zheng.order.controller;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.meetu.zheng.order.api.CommonResult;
import com.meetu.zheng.order.mapper.CustomerMapper;
import com.meetu.zheng.order.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@PostMapping("/signIn")
	public CommonResult signIn(@RequestBody Map params, HttpSession session) {
		Customer customer=customerMapper.findByName((String)params.get("name"));
		if(customer.getPassword().equals(params.get("password"))) {
			session.setAttribute("customer", customer.getName());
		}
		
		Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", "11111");
        tokenMap.put("tokenHead", "22222222");
        return CommonResult.success(tokenMap);
	}
}
