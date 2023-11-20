package cn.hs.dao;

import cn.hs.entity.Questionnaire;

import java.util.List;

/**
 * 编写对teacher表操作的接口信息
 */
public interface qDao {
    /**
     *  分页查询
     * @param startIndex
     * @param pageNum
     * @return
     */
    List<Questionnaire> select(int startIndex, int pageNum);


    int selectCount();


    int add(Questionnaire questionnaire);



}
