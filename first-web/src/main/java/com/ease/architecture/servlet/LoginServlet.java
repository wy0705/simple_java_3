package com.ease.architecture.servlet;

import com.ease.architecture.service.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.getCookies();

        //使用username,password查询相应的用户是否存在于数据库中
        //如果存在，返回hello,如果不存在提示错误
//        resp.setCharacterEncoding("UTF-8");
        if (userService.findUserByNameAndPassword(username, DigestUtils.md5Hex(password)) == null) {
            resp.getWriter().print("用户不存在或用户名、密码错误");
            return;
        }
        resp.getWriter().print("hello" + username);
    }
}
