package com.good.tyotto.nknock.api.service;

import static org.junit.Assert.assertEquals;
import com.good.tyotto.nknock.api.domain.KnockList;
import com.good.tyotto.nknock.api.domain.KnockListGroup;
import com.good.tyotto.nknock.api.domain.KnockListSelector;
import com.good.tyotto.nknock.api.repository.KnockListRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class KnockListServiceImplTest {

    @Nested
    public class UseMockitoTest {
        @Mock
        private KnockListRepository knockListRepository;

        @BeforeEach
        public void before() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void testFindAll() {
            List<KnockList> findResult = new ArrayList<>();
            Mockito.doReturn(findResult).when(knockListRepository).findAll();
            KnockListServiceImpl target = new KnockListServiceImpl(knockListRepository);

            KnockListGroup knockListGroup = target.findAll();

            assertEquals(findResult, knockListGroup.getKnockLists());
            Mockito.verify(knockListRepository, Mockito.times(1)).findAll();
        }

        @Test void testFind() {
            List<KnockList> findResult = new ArrayList<>();
            KnockListSelector selector = new KnockListSelector();
            Mockito.doReturn(findResult).when(knockListRepository).find(selector);
            KnockListServiceImpl target = new KnockListServiceImpl(knockListRepository);

            KnockListGroup knockListGroup = target.find(selector);

            assertEquals(findResult, knockListGroup.getKnockLists());
            Mockito.verify(knockListRepository, Mockito.times(1)).find(selector);
        }

        @Test void testAdd() {
            KnockList knockList = new KnockList();
            Mockito.doNothing().when(knockListRepository).add(knockList);
            KnockListServiceImpl target = new KnockListServiceImpl(knockListRepository);

            target.add(knockList);

            Mockito.verify(knockListRepository, Mockito.times(1)).add(knockList);
        }

        @Test void testSet() {
            KnockList knockList = new KnockList();
            Mockito.doNothing().when(knockListRepository).set(knockList);
            KnockListServiceImpl target = new KnockListServiceImpl(knockListRepository);

            target.set(knockList);

            Mockito.verify(knockListRepository, Mockito.times(1)).set(knockList);
        }

        @Test void testRemove() {
            int knockListId = 1;
            Mockito.doNothing().when(knockListRepository).remove(knockListId);
            KnockListServiceImpl target = new KnockListServiceImpl(knockListRepository);

            target.remove(knockListId);

            Mockito.verify(knockListRepository, Mockito.times(1)).remove(knockListId);
        }
    }
}
