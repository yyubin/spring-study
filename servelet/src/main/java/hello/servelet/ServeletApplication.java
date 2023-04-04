package hello.servelet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 현재 패키지 기준 하위 패키지들의 모든 서블릿을 찾아서 자동으로 등록해줌
@SpringBootApplication
public class ServeletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServeletApplication.class, args);
    }

}
