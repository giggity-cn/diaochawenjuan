package cn.hs.servlet;

import cn.hs.dao.impl.qDaoImpl;
import cn.hs.dao.qDao;
import cn.hs.entity.Questionnaire;
import cn.hs.util.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 *  实现图片预览功能
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = UploadUtils.upload(req);
        // 2 获取参数
        String name = map.get("name");
        int age =Integer.parseInt(map.get("age"));
        String gender = map.get("gender");
        String email = map.get("email");
        String file = map.get("attachment");
        System.out.println(name+age+gender);
        // 3 组成对象
        Questionnaire questionnaire = new Questionnaire(name,age,gender,email,file);
        // 链接数据库
        qDao questionnaireDao = new qDaoImpl();
        questionnaireDao.add(questionnaire);
        resp.sendRedirect("/qServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
