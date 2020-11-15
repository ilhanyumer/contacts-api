package name.ilhan.contacts;

import name.ilhan.contacts.controller.ContactController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactTest {

    @Autowired
    private ContactController contactController;

    @Test
    public void contextLoads() {
        assertThat(contactController).isNotNull();
    }
}
