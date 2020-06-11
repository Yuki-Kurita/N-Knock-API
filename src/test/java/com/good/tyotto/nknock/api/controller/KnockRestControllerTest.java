package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.service.KnockService;
import com.good.tyotto.nknock.api.util.UnitTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class KnockRestControllerTest {

    @Mock
    private KnockService knockService;

    @InjectMocks
    private  KnockRestController target;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void testAdd() throws Exception {
        Knock input = new Knock();
        Mockito.doNothing().when(knockService).add(ArgumentMatchers.any(Knock.class));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/knock")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UnitTestUtil.entity2JsonText(new Knock())));

        Mockito.verify(knockService, Mockito.times(1)).add(ArgumentMatchers.any(Knock.class));
    }
}
