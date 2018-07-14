package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    private static final int SPITTLE_COUNT = 20;
    public static final String VIEW_FILE_PATH = "/webapp/WEB-INF/views/spittles.jsp";
    public static final int MAX = 238900;

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findSpittles(MAX, SPITTLE_COUNT))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(spittleRepository);
        MockMvc mvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView(VIEW_FILE_PATH))
                .build();

        mvc.perform(get("/spittles?max=" + MAX + "&count=" + SPITTLE_COUNT))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

        verify(spittleRepository).findSpittles(MAX, SPITTLE_COUNT);
    }
}