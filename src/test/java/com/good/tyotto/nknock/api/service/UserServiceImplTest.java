package com.good.tyotto.nknock.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTest {

    @Nested public class UseMockitoTest {
        @Mock
        private UserRepository userRepository;

        @BeforeEach
        public void before() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testFind() {
            // setup
            UserSelector input = new UserSelector();
            User findResult = new User();
            Mockito.doReturn(findResult).when(userRepository).find(input);
            UserServiceImpl target = new UserServiceImpl(userRepository);

            // when
            User user = target.find(input);

            // then
            assertEquals(findResult, user);
            Mockito.verify(userRepository, Mockito.times(1)).find(input);
        }

        @Test
        public void testAdd() {
            // setup
            User input = new User();
            UserServiceImpl target = new UserServiceImpl(userRepository);

            target.add(input);

            Mockito.verify(userRepository, Mockito.times(1)).insert(input);
        }
    }
}
