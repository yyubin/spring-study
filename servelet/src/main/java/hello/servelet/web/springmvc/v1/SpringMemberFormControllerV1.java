package hello.servelet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Component // 스프링빈으로 등록
//@RequestMapping // requestMappingHandlerMapping 이 찾아낼수 있음
@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
        // 뷰 리졸버가 논리 뷰 이름을 받아 렌더링 해줄 것임
    }
}
