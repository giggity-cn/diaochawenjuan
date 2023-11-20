package cn.hs.servlet;

import cn.hs.dao.UserDao;
import cn.hs.dao.impl.UserDaoImpl;
import cn.hs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器层，处理登录功能
 */

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    // 处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.设置编码方式 【过滤器】
        // 2，处理请求信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checked = req.getParameter("checked");
        if(checked == null || checked == ""){
            req.setAttribute("error","请输入验证码");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        if(!"8888".equals(checked)){
            req.setAttribute("error","验证码有误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        // 3，链接数据库
        UserDao userDao = new UserDaoImpl();
        User login = userDao.login(username);
        // 4，处理并给出响应
         // 用户名不存在需要注册
         if(login == null){
             User user = new User();
             user.setUsername(username);
             user.setPassword(password);
             userDao.add(user);
             req.getSession().setAttribute("user",user);
             resp.sendRedirect("/pages/main.jsp");
         }
         // 密码错误
        try {
            if(!password.equals(login.getPassword())){
                req.setAttribute("error","密码有误！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("user",login);
        resp.sendRedirect("/pages/main.jsp");
    }
    // 处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
