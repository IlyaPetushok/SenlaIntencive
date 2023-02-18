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
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import vapeshop.test.config.JpaConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@WebAppConfiguration
public class RatingUnitTest {

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
    }


    private MockMvc mockMvc;

    @Test
    public void testGetByIdRating() throws Exception {
        MvcResult mvcResult1=mockMvc.perform(get("/rating/find/{id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testAddRating() throws Exception {
        char id=mockMvc.perform(post("/rating/add")
                        .content(asJsonString(new RatingDTOFullInfo("good", 3, new ItemDTOInfoForCatalog(1), new UserDTOAfterAuthorization(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString().charAt(6);
        MvcResult mvcResult1 = mockMvc.perform(get("/rating/find/{id}", id)).andReturn();
        Assertions.assertEquals(mvcResult1.getResponse().getContentAsString(),"{\"id\":"+id+",\"comment\":\"good\",\"quantityStar\":3,\"idUser\":1}");

    }

    @Test
    public void testUpdateRating() throws Exception {
        char id=mockMvc.perform(post("/rating/add")
                        .content(asJsonString(new RatingDTOFullInfo("good", 3, new ItemDTOInfoForCatalog(1), new UserDTOAfterAuthorization(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString().charAt(6);
        MvcResult mvcResult = mockMvc.perform(post("/rating/update")
                        .content(asJsonString(new RatingDTOFullInfo(Character.digit(id,10),"bad", 3, new ItemDTOInfoForCatalog(1), new UserDTOAfterAuthorization(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUpgradeRequired()).andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(), "{\"id\":"+id+",\"comment\":\"bad\",\"quantityStar\":3,\"idUser\":1}");
    }


    @Test()
    public void testGetAllRating() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/rating/getAll")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test()
    public void testDeleteRating() throws Exception {
        char id=mockMvc.perform(post("/rating/add")
                        .content(asJsonString(new RatingDTOFullInfo("good", 3, new ItemDTOInfoForCatalog(1), new UserDTOAfterAuthorization(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString().charAt(6);
        MvcResult mvcResult = mockMvc.perform(post("/rating/delete/{id}", id))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
