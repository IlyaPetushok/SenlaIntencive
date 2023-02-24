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
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.Role;
import vapeshop.test.config.H2Config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@WebAppConfiguration
public class UserUnitTest {

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
    }


    private MockMvc mockMvc;


    @Test
    public void testGetByIdUser() throws Exception {
        MvcResult mvcResult1=mockMvc.perform(get("/user/find/{id}", "1")).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testAddUser() throws Exception {
        MvcResult mvcResult=mockMvc.perform(post("/user/add")
                        .content(asJsonString(new UserDTOForRegistration("Petushok","Ilya","Aleksandrovich","login22222","pass","a332222@mail",new Role(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        char id=mvcResult.getResponse().getContentAsString().charAt(6);
        MvcResult mvcResult1=mockMvc.perform(get("/user/find/{id}", id)).andReturn();
        Assertions.assertFalse(mvcResult1.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void testUpdateUser() throws Exception {
        mockMvc.perform(post("/user/update")
                        .content(asJsonString(new UserDTOForRegistration(1,"Pet","Ilsya","Aleksa","log","pass","a2@mail",new Role(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUpgradeRequired());
        MvcResult mvcResult1=mockMvc.perform(get("/user/find/{id}", "1")).andReturn();
        Assertions.assertEquals(mvcResult1.getResponse().getContentAsString(),asJsonString(new UserDTOForRegistration(1,"Pet","Ilsya","Aleksa","log","pass","a2@mail",new Role(1))));
    }


    @Test()
    public void testGetAllCategory() throws Exception {
        MvcResult mvcResult=mockMvc.perform(get("/user/getAll")).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test()
    public void testDeleteCategory() throws Exception {
        MvcResult mvcResult=mockMvc.perform(post("/user/add")
                        .content(asJsonString(new UserDTOForRegistration("Pet","Ilsya","Aleksa","log1111","pass","a11+2@mail",new Role(1))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        char id=mvcResult.getResponse().getContentAsString().charAt(6);
        MvcResult mvcResult1=mockMvc.perform(post("/user/delete/{id}",id)).andReturn();
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
