package com.good.tyotto.nknock.api.controller;

import static org.junit.Assert.assertEquals;
import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import com.good.tyotto.nknock.api.service.KnockService;
import com.good.tyotto.nknock.api.util.UnitTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
    public void testFind() throws  Exception {
        ArgumentMatcher<KnockSelector> matcher = argument -> {
            assertEquals(0, argument.getKnockListId());
            return true;
        };
        KnockGroup findResult = new KnockGroup();
        Mockito.doReturn(findResult).when(knockService).find(Mockito.argThat(matcher));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/knock/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
        Mockito.verify(knockService, Mockito.times(1)).find(Mockito.argThat(matcher));
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

    @Test
    public void testSet() throws Exception {
        Knock input = new Knock();
        Mockito.doNothing().when(knockService).set(ArgumentMatchers.any(Knock.class));

        mockMvc.perform(MockMvcRequestBuilders
                .patch("/knock")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UnitTestUtil.entity2JsonText(new Knock())));

        Mockito.verify(knockService, Mockito.times(1)).set(ArgumentMatchers.any(Knock.class));
    }

    @Test
    public void testRemove() throws Exception {

        int input = 1;
        Mockito.doNothing().when(knockService).remove(1);

        mockMvc.perform(MockMvcRequestBuilders.delete("/knock/1/"));

        Mockito.verify(knockService, Mockito.times(1)).remove(input);
    }
}
