package test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
@ContextConfiguration(classes={ WebConfig.class})  
public class TesthHelloController {
	@Autowired  
	private WebApplicationContext webApplicationContext;  
	
	private MockMvc mockMvc;
	
	@Before  
    public void init(){  
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();  
    }  
	
    @Test  
    public void printBeans(){  
        String[] beans=webApplicationContext.getBeanDefinitionNames();  
        /*for (String bean : beans) {  
            System.out.println(bean);  
        }  */
    }  
    
	@Test
	public void testHello() throws Exception {
		this.mockMvc.perform(get("/hello").param("myname", "yuki").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("helloyuki"));
	}
	
	@Test
	public void testAOP() throws Exception {
		this.mockMvc.perform(get("/testAOP").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk());
	}
	
}
