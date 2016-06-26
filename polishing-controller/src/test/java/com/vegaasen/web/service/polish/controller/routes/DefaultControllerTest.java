package com.vegaasen.web.service.polish.controller.routes;

import com.vegaasen.web.service.polish.controller.config.WebConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = WebConfiguration.class)
@WebAppConfiguration
public class DefaultControllerTest {

    @Resource
    private WebApplicationContext applicationContext;
    private MockMvc mockMvc;
    @Resource
    private MessageSource messageSource;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(applicationContext).build();
    }

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(get("/")).andReturn().getResponse().getContentAsString().contains("heisann");
    }

}