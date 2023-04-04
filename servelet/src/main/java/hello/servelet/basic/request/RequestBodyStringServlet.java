package hello.servelet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        // 현재는 바이트 코드

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // 바이트 코드를 스트링으로 변환해줌
        // 바이트를 문자로 변환할 때는 어떤 인코딩인지 알려줘야 한다.

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
