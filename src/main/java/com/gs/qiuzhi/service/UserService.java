package com.gs.qiuzhi.service;


import com.gs.qiuzhi.pojo.User;
import com.gs.qiuzhi.pojo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> findAll()
    {
        return userMapper.findAll();
    }

    public User checkUserLogin(String userName,String password){
        return userMapper.userLogin(userName,password);
    }

    public boolean userRegister(User user){
        return userMapper.userRegister(user) > 0;
    }

    public String checkRegister(String user_phone){
        return userMapper.checkRegister(user_phone);
    }

    public int updateUserFace(String path,String userOnlyId)
    {
        return userMapper.updateUserFace(path,userOnlyId);
    }

    public boolean updateUserNickName(String nickName,String userOnlyId){
        return userMapper.updateUserNickName(nickName,userOnlyId)>0;
    }

    public boolean checkOriginalPass(String originalPass,String userOnlyId){
        if (userMapper.checkOriginalPass(originalPass,userOnlyId)!=null){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updatePass(String newPass,String userOnlyId){
        return userMapper.updatePass(newPass,userOnlyId)>0;
    }

    public List<User> findHotUser()
    {
        return userMapper.findHotUser();
    }

    public User wxFindUserById(String user_only_id){
        return userMapper.findUserById(user_only_id);
    }
}
