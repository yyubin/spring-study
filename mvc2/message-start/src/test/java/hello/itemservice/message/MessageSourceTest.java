package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;
    @Test
    void helloMessage() {
        String result = ms.getMessage("hello", null, Locale.US);
        assertThat(result).isEqualTo("hello");
    }

//    @Test
//    void notFoundMessageCode() {
//        assertThatThrownBy(() -> ms.getMessage("no_code", null, Locale.KOREA))
//                .isInstanceOf(NoSuchMessageException.class);
//    }

    @Test
    void notFoundMessage() {
        String result = ms.getMessage("no_code", null, "기본 메세지", Locale.getDefault());
        assertThat(result).isEqualTo("기본 메세지");
    }

    @Test
    void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"Spring"}, Locale.getDefault());
        assertThat(message).isEqualTo("안녕 Spring");
    }

    @Test
    void defaultLang() {
        Locale.setDefault(Locale.KOREA);
        assertThat(ms.getMessage("hello", null, Locale.getDefault())).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.US)).isEqualTo("hello");

    }

    @Test
    void enLang() {
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }

}
