package com.meetu.zheng.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.meetu.zheng.order.model.Coffee;

@Mapper
public interface CoffeeMapper {
	@Insert("insert into t_coffee (name, price, create_time, update_time)"
			+ "values (#{name}, #{price}, now(), now())")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	Long save(Coffee coffee);
	
	@Select("select * from t_coffee where id = #{id}")
	@Results(id = "coffeeMap", value = {
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "price", property = "price"),
		@Result(column = "create_time", property = "createdAt"),
		@Result(column = "upadte_time", property = "updatedAt")
	})
	Coffee findById(@Param("id") Long id);
	
	@Select("select * from t_coffee")
	@ResultMap(value = "coffeeMap")
	List<Coffee> findAll();
}
