package com.meetu.zheng.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetu.zheng.order.mapper.CoffeeMapper;
import com.meetu.zheng.order.model.Coffee;

@RestController
@RequestMapping("coffee")
public class CoffeeController {
	
	@Autowired
	private CoffeeMapper coffeeMapper;
	
	@GetMapping("/list")
	public List<Coffee> showCoffees(){
		return coffeeMapper.findAll();
	}
}
