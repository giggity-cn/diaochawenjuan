package cn.hs.dao.impl;

import cn.hs.dao.UserDao;
import cn.hs.entity.User;
import cn.hs.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现dao接口
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User login(String username) {
        String sql = "select * from user where username=?";
        Object obj[] = {username};
        ResultSet resultSet = JDBCUtil.query(sql, obj);
        User user = null;  // 定义一个全局的user对象
        while (true){
            try {
                if (!resultSet.next()) break;
                int id = resultSet.getInt(1);
                String uname = resultSet.getString(2);
                String password = resultSet.getString(3);
                String email = resultSet.getString(4);
                String phone = resultSet.getString(5);

                user = new User(id,uname,password,email,phone);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        JDBCUtil.close();
        return user;
    }


    @Override
    public int  add(User user) {
        String sql ="insert into user values(null,?,?,null,null)";
        Object obj[] = {user.getUsername(),user.getPassword()};
        int i = JDBCUtil.update(sql,obj);
        return i;
    }
}
