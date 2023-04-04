package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        // stream은 바이트코드이므로 항상 어떤 인코딩 사용해야할지 말해줘야함
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("inputStream = {}" , s);

        response.getWriter().write("ok");

    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {

        // stream은 바이트코드이므로 항상 어떤 인코딩 사용해야할지 말해줘야함
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("inputStream = {}" , s);

        responseWriter.write("ok");

    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        String body = httpEntity.getBody();
        log.info("messageBody = {}" , body);

        return new ResponseEntity<String>("ok", HttpStatus.CREATED);

    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String body) throws IOException {

        log.info("messageBody = {}" , body);

        return "ok";

    }

}
