package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;
import web.servlet.data.HelloData;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
  private ObjectMapper mapper = new ObjectMapper();
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletInputStream inputStream = req.getInputStream();
    String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
    HelloData helloData = mapper.readValue(messageBody, HelloData.class);

    System.out.println("helloData.user" + helloData.getUsername()
        + ", helloData.age " + helloData.getAge());
    resp.getWriter().println(helloData.getUsername() + " : " + helloData.getAge());

  }
}
