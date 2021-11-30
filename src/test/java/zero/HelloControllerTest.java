package zero;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


public class HelloControllerTest {
    private static final Logger LOG = LoggerFactory.getLogger(HelloControllerTest.class);
    @InjectMocks
    private HelloController helloController;

    private MockMvc mockMvc;

    @Before
    public void before() {
        initMocks(this);
        this.mockMvc = standaloneSetup(this.helloController).build();
    }

    @Test
    public void homeAssertService() throws Exception {
        // note: we don't call the controller method manually here!
        this.mockMvc
            .perform(
                get("/").accept(MediaType.ALL_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().string("Greetings from Spring Boot!"))
            .andReturn();
    }
}
