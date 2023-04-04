package hello.servelet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 서블릿이 실행되면 이 서비스 메서드가 호출이 된다
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // was가 request, response 객체를 만들어서 서블릿에 던져줌
        // 웹에서 해당 url 검색시 웹브라우저가 요청메세지 생성

        System.out.println("HelloServlet");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        // 톰캣과 같은 was 서버들이 HttpServeltRequest와 같은 인터페이스를 직접 구현
        // 그 구현체들이 찍히는 것을 볼 수 있다

        String username = request.getParameter("username");
        System.out.println(username);

        response.setContentType("text/Plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
