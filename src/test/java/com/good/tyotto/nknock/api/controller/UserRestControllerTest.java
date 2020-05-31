package com.good.tyotto.nknock.api.controller;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.service.UserService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRestControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserRestController target;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void testFindSetEmail() throws Exception {
        // setup
        User findResult = new User();
        ArgumentMatcher<UserSelector> matcher = argument -> {
            assertEquals("test@tyotto.xx.xx", argument.getEmail());
            return true;
        };

        Mockito.doReturn(findResult).when(userService).find(Mockito.argThat(matcher));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/users")
                .param("email", "test@tyotto.xx.xx"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // then: テスト結果の検証。戻り値、Mockの呼び出し方法、回数など
        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
        Mockito.verify(userService, Mockito.times(1)).find(Mockito.argThat(matcher));
    }

    /**
     * ユーザ登録による検証
     */
    @Test
    public void testAdd() throws Exception {
        // setup: 事前準備
        Mockito.doNothing().when(userService).add(ArgumentMatchers.any(User.class));
        // when: 対象のAPIリクエストを実行
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(UnitTestUtil.entity2JsonText(new User())));
        // then: テスト結果の検証。戻り値、Mockの呼び出し方法、回数など
        Mockito.verify(userService, Mockito.times(1)).add(ArgumentMatchers.any(User.class));
    }
}
