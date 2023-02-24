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
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;
import vapeshop.test.config.H2Config;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@WebAppConfiguration
public class OrderUnitTest {
    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
    }

    private MockMvc mockMvc;


    @Test
    public void testGetByIdOrder() throws Exception {
        MvcResult mvcResult1 = mockMvc.perform(get("/order/find/{id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testAddOrder() throws Exception {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1));
        char id=mockMvc.perform(post("/order/add")
                        .content(asJsonString(new OrderDTOFullInfo(new Date(2023, Calendar.FEBRUARY,26), StatusOrder.Sent,150.0,new User(1),itemList)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString().charAt(6);
        MvcResult mvcResult1 = mockMvc.perform(get("/order/find/{id}", id)).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testUpdateCategory() throws Exception {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1));
        mockMvc.perform(post("/order/update")
                        .content(asJsonString(new OrderDTOFullInfo(1,new Date(2023, Calendar.FEBRUARY,26),StatusOrder.Accepted,150.0,new User(1),itemList)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUpgradeRequired());
        MvcResult mvcResult1 = mockMvc.perform(get("/order/find/{id}", "1")).andReturn();
        Assertions.assertEquals(mvcResult1.getResponse().getContentAsString(), "{\"id\":1,\"date\":61635502800000,\"status\":\"прибыл\",\"price\":150.0}");
    }


    @Test()
    public void testGetAllOrder() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/order/getAll")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test()
    public void testDeleteOrder() throws Exception {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1));
        mockMvc.perform(post("/order/add")
                        .content(asJsonString(new OrderDTOFullInfo(new Date(2023, Calendar.FEBRUARY,26),StatusOrder.Arrived,150.0,new User(1),itemList)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        MvcResult mvcResult1 = mockMvc.perform(post("/order/delete/{id}", "2")).andReturn();
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
