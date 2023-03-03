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
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.entity.product.Category;
import vapeshop.test.config.H2Config;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class, SpringApplicationConfig.class})
@WebAppConfiguration
public class ItemUnitTest {
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
    }
    private MockMvc mockMvc;


    @Test
    public void testGetByIdItem() throws Exception {
        MvcResult mvcResult1=mockMvc.perform(get("/items/{id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testAddItem() throws Exception {
        mockMvc.perform(post("/items")
                        .content(asJsonString(new ItemDTOFullInfo("photo4", "HotSpot BubleGum", new Category("Испарители,Картриджы,Койлы"), new BigDecimal(Double.toString(23.0)), 15)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        MvcResult mvcResult1=mockMvc.perform(get("/items/{id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testUpdateItem() throws Exception {
        mockMvc.perform(put("/items")
                        .content(asJsonString(new ItemDTOFullInfo(1,"photo4", "HotSpot BubleGum Update", new Category("Испарители,Картриджы,Койлы"), new BigDecimal(Double.toString(23.0)), 15)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUpgradeRequired());
        MvcResult mvcResult1=mockMvc.perform(get("/items/{id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().contains("name" + ":" + "HotSpot BubleGum Update"));
    }


    @Test
    public void testGetAllItem() throws Exception {
        MvcResult mvcResult=mockMvc.perform(get("/items")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteItem() throws Exception {
        mockMvc.perform(post("/items")
                        .content(asJsonString(new ItemDTOFullInfo("photo4", "HotSpot BubleGum", new Category("Испарители,Картриджы,Койлы"), new BigDecimal(Double.toString(23.0)), 15)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        MvcResult mvcResult1=mockMvc.perform(delete("/items/{id}","4")).andReturn();
        Assertions.assertEquals(mvcResult1.getResponse().getContentAsString(),"true");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
