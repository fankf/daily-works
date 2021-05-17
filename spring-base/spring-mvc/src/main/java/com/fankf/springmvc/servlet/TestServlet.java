package com.fankf.springmvc.servlet;

import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet("/servlet")
public class TestServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        List<Cookie> sessionKeyCookie = Arrays.stream(cookies).filter(ck -> "session_key".equals(ck.getName())).collect(Collectors.toList());
        String uuid = UUID.randomUUID().toString();
        if (sessionKeyCookie.size() == 0) {
            Cookie cookie = new Cookie("session_key", uuid);
            resp.addCookie(cookie);
        }
        //有则获取，没有则创建
        HttpSession session = req.getSession(true);
        String session_key = (String) session.getAttribute("session_key");
        if (StringUtils.isEmpty(session_key)) {
            session.setAttribute("session_key", uuid);
        }
        resp.getWriter().write("session_key is" + uuid);
    }
}
