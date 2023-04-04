package hello.servelet.web.frontcontroller.v3;

import hello.servelet.web.frontcontroller.ModelView;
import hello.servelet.web.frontcontroller.MyView;
import hello.servelet.web.frontcontroller.v3.ControllerV3;
import hello.servelet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servelet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servelet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private final Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // front-controller에서 요청된 URI 정보 받음

        // /front-controller/v1/members
        String requestURI = request.getRequestURI();

        // 해당되는 URL 마다 각각의 컨트롤러 생성해줌
        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 요청정보에서 파라미터 정보들 담아서 컨트롤러로 저장,
        // 컨트롤러에서는 기존과 다르게 reqeust, response 객체를 사용하지 않고 model View 를 생성하여 리턴
        // 리턴 받은 모델 뷰에는 각각의 논리 이름이 담김
        // 모델 뷰에서는 화면에 사용될 아이템들이 모두 담긴다
        // paramMap
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();// 논리 이름일 뿐임

        // 뷰 리졸버에서 논리 이름을 물리 주소로 변경
        MyView view = viewResolver(viewName);

        // 뷰에서는 모델 뷰 안에 담겨진 모델에서 모든 데이터를 꺼내 response 객체에 담는다
        // 그 후 렌더링
        view.render(mv.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
