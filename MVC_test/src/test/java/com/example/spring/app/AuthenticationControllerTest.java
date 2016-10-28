package com.example.spring.app;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@RunWith(SpringRunner.class)
@ContextHierarchy({ @ContextConfiguration({ "/META-INF/spring/app-config.xml", "/META-INF/spring/jdbc-config.xml",
        "/META-INF/spring/security-config.xml" }), @ContextConfiguration("/META-INF/spring/mvc-config.xml") }) //
@WebAppConfiguration
@ActiveProfiles("test")
public class AuthenticationControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).addFilter(new CharacterEncodingFilter("utf-8"))
                // Spring Securityのサーブレットフィルタの追加
                .apply(springSecurity()).build();
    }

    @Test
    public void testFormLogin() throws Exception {
        mockMvc.perform(formLogin().user("user").password("user")).andExpect(status().isFound())
                .andExpect(redirectedUrl("/")).andExpect(authenticated().withRoles("APP1", "APP2"));
    }
}
