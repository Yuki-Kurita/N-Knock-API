package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.repository.KnockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class KnockServiceImplTest {

    @Nested
    public class UserMockitoTest {
        @Mock
        private KnockRepository knockRepository;

        @BeforeEach
        public void before() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testAdd() {
            Knock input = new Knock();
            KnockServiceImpl target = new KnockServiceImpl(knockRepository);

            target.add(input);
            Mockito.verify(knockRepository, Mockito.times(1)).add(input);
        }
    }
}
