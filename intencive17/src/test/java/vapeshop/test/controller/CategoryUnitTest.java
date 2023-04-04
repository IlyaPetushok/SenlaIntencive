package vapeshop.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import project.vapeshop.config.SpringApplicationConfig;
import project.vapeshop.dto.product.CategoryDTO;
import vapeshop.test.config.H2Config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class, SpringApplicationConfig.class})
@WebAppConfiguration
public class CategoryUnitTest {
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
    }

    private MockMvc mockMvc;


    @Test
    public void testGetByIdCategory() throws Exception {
        MvcResult mvcResult1 = mockMvc.perform(get("/categories/{category-id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testAddCategory() throws Exception {
        mockMvc.perform(post("/categories")
                        .content(asJsonString(new CategoryDTO("Vape")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        MvcResult mvcResult1 = mockMvc.perform(get("/categories/{id}", "4")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testUpdateCategory() throws Exception {
        mockMvc.perform(put("/categories")
                        .content(asJsonString(new CategoryDTO(3, "Vaporizer")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUpgradeRequired());
        MvcResult mvcResult1 = mockMvc.perform(get("/categories/{id}", "3")).andReturn();
        Assertions.assertEquals(mvcResult1.getResponse().getContentAsString(), "{\"id\":3,\"name\":\"Vaporizer\"}");
    }


    @Test()
    public void testGetAllCategory() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/categories")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test()
    public void testDeleteCategory() throws Exception {
        MvcResult mvcResult1 = mockMvc.perform(delete("/categories/{id}", "4")).andReturn();
        Assertions.assertEquals(mvcResult1.getResponse().getContentAsString(), "true");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
