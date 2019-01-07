package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.PalTrackerApplication;
import io.pivotal.pal.tracker.WelcomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class, webEnvironment = RANDOM_PORT)
public class WelcomeControllerTestDemo {

    @Test
    public void itSaysHello() throws Exception {
        WelcomeController controller = new WelcomeController("${WELCOME_MESSAGE}");

        assertThat(controller.sayHello()).isEqualTo("Hello from test");
    }
}
