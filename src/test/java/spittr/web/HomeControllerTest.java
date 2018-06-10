package spittr.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(new HomeController()).build();
    }

    @Test
    public void testRootPage() throws Exception {
        renderHomeView("/");
    }

    @Test
    public void testHomePage() throws Exception {
        renderHomeView("/homepage");
    }

    private void renderHomeView(String requestUrl) throws Exception {
        mockMvc.perform(get(requestUrl)).andExpect(view().name("home"));
    }
}