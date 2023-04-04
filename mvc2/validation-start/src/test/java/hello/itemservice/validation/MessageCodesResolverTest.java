package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

    MessageCodesResolver ms = new DefaultMessageCodesResolver();
    
    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = ms.resolveMessageCodes("required", "item");
        for (String messageCode: messageCodes) {
            System.out.println("messageCode : " + messageCode);
        }
        Assertions.assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] strings = ms.resolveMessageCodes("required", "item", "itemName", String.class);

        for (String string : strings) {
            System.out.println("string = " + string);
        }

        Assertions.assertThat(strings).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required");
    }

}
