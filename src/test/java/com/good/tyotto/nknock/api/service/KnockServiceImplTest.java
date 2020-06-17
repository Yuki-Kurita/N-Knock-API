package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.Knock;
import com.good.tyotto.nknock.api.domain.KnockGroup;
import com.good.tyotto.nknock.api.domain.KnockSelector;
import com.good.tyotto.nknock.api.repository.KnockRepository;
import java.util.List;
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
        public void testFind() {
            KnockSelector selector = new KnockSelector();
            KnockServiceImpl target = new KnockServiceImpl(knockRepository);

            target.find(selector);
            Mockito.verify(knockRepository, Mockito.times(1)).find(selector);
        }

        @Test
        public void testAdd() {
            Knock input = new Knock();
            KnockServiceImpl target = new KnockServiceImpl(knockRepository);

            target.add(input);
            Mockito.verify(knockRepository, Mockito.times(1)).add(input);
        }

        @Test void testSet() {
            Knock input = new Knock();
            KnockServiceImpl target = new KnockServiceImpl(knockRepository);

            target.set(input);
            Mockito.verify(knockRepository, Mockito.times(1)).set(input);
        }

        @Test void testRemove() {
            int input = 1;
            KnockServiceImpl target = new KnockServiceImpl(knockRepository);

            target.remove(input);
            Mockito.verify(knockRepository, Mockito.times(1)).remove(input);
        }
    }
}
