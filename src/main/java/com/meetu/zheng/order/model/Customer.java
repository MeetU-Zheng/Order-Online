package com.meetu.zheng.order.model;

import java.util.Date;

import org.joda.money.Money;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Customer {
	//TODO:id,createdAt can be abstracted into a base class 
	private Long id;
	private String name;
	//TODO:passwords need to avoid clear text
	private String password;
	private Date createdAt;
	private Date updatedAt;
}
