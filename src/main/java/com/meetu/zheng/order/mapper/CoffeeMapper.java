package com.meetu.zheng.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
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
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "create_time", property = "createdAt")
	})
	Coffee findById(@Param("id") Long id);
}
