package com.meetu.zheng.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.meetu.zheng.order.model.Customer;

@Mapper
public interface CustomerMapper {
	
	@Insert("insert into t_customer (name, password, create_time, update_time"
			+ "values (#{name}, #{password}, now(), now())")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	Long save(Customer customer);
	
	//try not to write "select *"
	@Select("select * from t_customer where name = #{name}")
	@Results(id = "customerMap", value = {
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "name", property = "name"),
			@Result(column = "password", property = "password"),
			@Result(column = "create_time", property = "createdAt"),
			@Result(column = "upadte_time", property = "updatedAt")
		})
	Customer findByName(@Param("name") String name);
}
