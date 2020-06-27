package com.good.tyotto.nknock.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListGroup;
import com.good.tyotto.nknock.api.domain.TagList;
import com.good.tyotto.nknock.api.service.KnockListService;
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

public class KnockListRestControllerTest {

    @Mock
    private KnockListService knockListService;

    @InjectMocks
    private KnockListRestController target;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    /**
     * 全件取得によるテスト
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        KnockListGroup findResult = new KnockListGroup();
        Mockito.doReturn(findResult).when(knockListService).findAll();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/knocklist/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
        Mockito.verify(knockListService, Mockito.times(1)).findAll();
    }

    @Test void testFindTag() throws Exception {
        TagList findResult = new TagList();
        Mockito.doReturn(findResult).when(knockListService).findTag();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/knocklist/tags"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
        Mockito.verify(knockListService, Mockito.times(1)).findTag();

    }

     @Test void testGetLatestId() throws Exception {
        int findResult = 1;
        Mockito.doReturn(findResult).when(knockListService).getLatestId();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/knocklist/latest"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
        Mockito.verify(knockListService, Mockito.times(1)).getLatestId();

    }

    @Test void testAdd() throws Exception {
        Mockito.doNothing().when(knockListService).add(ArgumentMatchers.any(KnockList.class));

       mockMvc.perform(MockMvcRequestBuilders
               .post("/knocklist/")
               .contentType(MediaType.APPLICATION_JSON)
               .content(UnitTestUtil.entity2JsonText(new KnockList())));

       Mockito.verify(knockListService, Mockito.times(1)).add(ArgumentMatchers.any(KnockList.class));
    }

    @Test void testSet() throws Exception {
        Mockito.doNothing().when(knockListService).set(ArgumentMatchers.any(KnockList.class));

        mockMvc.perform(MockMvcRequestBuilders
                .patch("/knocklist/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(UnitTestUtil.entity2JsonText((new KnockList()))));

       Mockito.verify(knockListService, Mockito.times(1)).set(ArgumentMatchers.any(KnockList.class));
    }

    @Test void testRemove() throws Exception {
        int knockListId = 1;
        Mockito.doNothing().when(knockListService).remove(knockListId);

        mockMvc.perform(MockMvcRequestBuilders.patch("/knocklist/1/"));
        Mockito.verify(knockListService, Mockito.times(1)).remove(knockListId);
    }

}
