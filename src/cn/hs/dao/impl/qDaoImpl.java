package cn.hs.dao.impl;

import cn.hs.dao.qDao;
import cn.hs.entity.Questionnaire;
import cn.hs.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现questionnaire表的操作功能
 */
public class qDaoImpl implements qDao {
    @Override
    public List<Questionnaire> select(int startIndex, int pageNum) {
        String sql = "select * from questionnaire order by id desc limit ?,?";
        Object obj[] = {startIndex,pageNum};
        ResultSet resultSet = JDBCUtil.query(sql, obj);
        List<Questionnaire> list = new ArrayList<>();
        while(true){
            try {
                if (!resultSet.next()) break;
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String gender = resultSet.getString(4);
                String email = resultSet.getString(5);
                String file = resultSet.getString(6);
                Questionnaire questionnaire =new Questionnaire(name,age,gender,email,file);
                list.add(questionnaire);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        JDBCUtil.close();
        return list;
    }

    @Override
    public int selectCount() {
        String sql = "select count(id) from questionnaire";
        Object obj[] = {};
        int count = 0;
        ResultSet resultSet = JDBCUtil.query(sql, obj);
        while(true){
            try {
                if (!resultSet.next()) break;
                count = resultSet.getInt(1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        JDBCUtil.close();
        return count;
    }

    @Override
    public int add(Questionnaire questionnaire) {
        String sql = "insert into questionnaire values(0,?,?,?,?,?)";
        Object obj[] = {questionnaire.getName(), questionnaire.getAge(),questionnaire.getGender(),questionnaire.getEmail(), questionnaire.getFile()};
        int i = JDBCUtil.update(sql, obj);
        return i;
    }




}
