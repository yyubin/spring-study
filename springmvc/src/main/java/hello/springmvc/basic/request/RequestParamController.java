package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {} , age = {}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username,
                                 @RequestParam("age") int age) throws IOException {

        log.info("username = {} , age = {}", username, age);

        return "ok";
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam("username") String username,
                                 @RequestParam("age") int age) throws IOException {

        log.info("username = {} , age = {}", username, age);

        return "ok";
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) throws IOException {

        log.info("username = {} , age = {}", username, age);

        return "ok";
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age)
            throws IOException {

        // java에서는 int는 기본형에 null이 불가능함
        // Integer에서는 가능 java의 Integer는 객체형이라서 가능

        // null과  ""는 다르다
        // 요청시 username=  -> 이라고만 보내면 null이 아닌 빈문자

        log.info("username = {} , age = {}", username, age);

        return "ok";
    }


    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age)
            throws IOException {

        // defaultValue는 빈문자의 경우에도 디폴트값 넣어준다

        log.info("username = {} , age = {}", username, age);

        return "ok";
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) throws IOException {

        // defaultValue는 빈문자의 경우에도 디폴트값 넣어준다

        log.info("username = {} , age = {}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) throws IOException {

        // defaultValue는 빈문자의 경우에도 디폴트값 넣어준다

        log.info("HelloData = {}", helloData);

        return "ok";
    }

    @ResponseBody // restcontroller와 같은 역할
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) throws IOException {

        // defaultValue는 빈문자의 경우에도 디폴트값 넣어준다

        log.info("HelloData = {}", helloData);

        return "ok";
    }

}