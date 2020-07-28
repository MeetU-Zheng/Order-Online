package com.meetu.zheng.order.model;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString(callSuper = true)
public class CoffeeOrder {
	private Long id;
	private List<Coffee> items;
	private Date createdAt;
	private Date updateAt;
}
