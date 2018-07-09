package com.gs.qiuzhi.pojo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mapper映射类
 */
@Mapper
public interface UserMapper {

    public List<User> findAll();
}
