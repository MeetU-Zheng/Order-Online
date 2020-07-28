package com.meetu.zheng.order.model;

import java.util.Date;

import org.joda.money.Money;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Coffee {
	private Long id;
	private String name;
	private Money price;
	private Date createdAt;
	private Date updateAt;
}
