package cn.hs.dao;

import cn.hs.entity.User;

import java.util.List;

/**
 *  java操作user表的通用的接口
 */
public interface UserDao {
    /**
     *  根据username来查询
     * @param username
     * @return
     */
    User login(String username);



    int  add(User user);
}
