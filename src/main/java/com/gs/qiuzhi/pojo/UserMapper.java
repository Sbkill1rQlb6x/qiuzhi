package com.gs.qiuzhi.pojo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mapper映射类
 */
@Mapper
public interface UserMapper {

    public List<User> findAll();
    public User userLogin(String userName,String password);
    public int userRegister(User user);
    public String checkRegister(String user_phone);
    public int updateUserFace(String path,String userOnlyId);
    public int updateUserNickName(String nickName,String userOnlyId);
    public User checkOriginalPass(String originalPass,String userOnlyId);
    public int updatePass(String newPass,String userOnlyId);
    public List<User> findHotUser();
    public User findUserById(String user_only_id);

}
