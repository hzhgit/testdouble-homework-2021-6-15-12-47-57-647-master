package com.tw.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.List;

public class TransactionRepositoryTest {
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void init() {
        Clock clock = mock(Clock.class);
        transactionRepository = new TransactionRepository(clock);
    }

    @Test
    void should_amount_equals_original_add_incoming_when_addDeposit() {
        //given
        int amount = 100;
        List<Transaction> transactionList = transactionRepository.allTransactions();

        //when
        transactionRepository.addDeposit(amount);

        //then
        assertEquals(100, transactionList.get(0).amount());
    }

    @Test
    void should_amount_equals_original_withdraw_incoming_when_addWithdraw() {
        //given
        int amount = 100;
        List<Transaction> transactionList = transactionRepository.allTransactions();

        //when
        transactionRepository.addWithdraw(amount);

        //then
        assertEquals(-100, transactionList.get(0).amount());
    }

}
