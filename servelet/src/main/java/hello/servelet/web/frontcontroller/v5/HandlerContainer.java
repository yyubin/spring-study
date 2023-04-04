package hello.servelet.web.frontcontroller.v5;

import hello.servelet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servelet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servelet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servelet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servelet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servelet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servelet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.servelet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class HandlerContainer {

    final Map<String,Object> handlerMappingMap = new HashMap<>();
    final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public HandlerContainer() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }
    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }
}
