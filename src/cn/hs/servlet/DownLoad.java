package cn.hs.servlet;

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
import java.lang.annotation.Repeatable;

/**
 *  实现图片下载功能
 */
@WebServlet("/downLoad")
public class DownLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取图片名称
        String filename = req.getParameter("filename");
        // 2. 获取图片的文件对象
        File file = new File("e:/file",filename);
        // 3. 创建当前文件的自救输入流
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        // 4. 获取响应对象的字节输出流
        // 注意： 是下载，还是预览 ， 需要设置不同的响应头信息
        resp.setHeader("Content-Disposition","attachment;filename="+filename); // 下载
        ServletOutputStream out = resp.getOutputStream();
        // 5.读写文件
        byte b[] = new byte[1024];
        int num = 0;
        while( (num = bin.read(b))!=-1 ){
            out.write(b,0,num);
        }
        // 6.释放资源
        out.close();
        bin.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
