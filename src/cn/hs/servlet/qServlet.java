package cn.hs.servlet;

import cn.hs.dao.qDao;
import cn.hs.dao.impl.qDaoImpl;
import cn.hs.entity.Questionnaire;
import cn.hs.util.Page;
import cn.hs.util.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * 处理questionnaire前段请求信息
 */
@WebServlet("/qServlet")
public class qServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 1 获取请求参数列表
            String cp = req.getParameter("currentPage");
            if(cp==null){
                cp = "1";
            }
            // 2 计算page相关信息
            int currentPage = Integer.parseInt(cp);
            int pageNum = 2;
            qDao questionnaireDao = new qDaoImpl();
            int count = questionnaireDao.selectCount();
            Page<Questionnaire> page = new Page<>(currentPage,pageNum,count);
            List<Questionnaire> questionnaires = questionnaireDao.select(page.getStartIndex(), pageNum);
            page.setList(questionnaires);

        // 3 给出响应
            req.setAttribute("page",page);
            req.getRequestDispatcher("/pages/list.jsp").forward(req,resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
