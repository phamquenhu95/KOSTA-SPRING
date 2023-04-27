package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response-header")
public class ResponseHeaderServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    cookie(resp);

  }

  private void cookie(HttpServletResponse resp) {
    Cookie cookie = new Cookie("myCookie","good");
    cookie.setMaxAge(0); //60 초
    resp.addCookie(cookie);

  }
  private void redirect(HttpServletResponse resp) throws IOException {
    resp.sendRedirect("/index.html");
  }

}
