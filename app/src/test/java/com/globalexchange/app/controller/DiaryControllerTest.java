package com.globalexchange.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DiaryControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void diaryPartnerList() throws Exception {
        log.info("members : " + mockMvc.perform(MockMvcRequestBuilders.get("/diary/partnerList")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void partnerDetail() throws Exception{
        log.info("partner : " + mockMvc.perform(MockMvcRequestBuilders.get("/diary/partnerDetail")
                .param("memberNumber", "84")
        ).andReturn().getModelAndView().getModelMap());
    }
}