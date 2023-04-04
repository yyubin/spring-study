package hello.servelet.web.frontcontroller.v3;

import hello.servelet.web.frontcontroller.ModelView;
import hello.servelet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
    // 서블릿 스펙이 빠짐
}
