package com.tw.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountTest {
    private TransactionRepository transactionRepository;
    private Printer printer;
    private Account account;

    @BeforeEach
    public void init() {
        transactionRepository = mock(TransactionRepository.class);
        printer = mock(Printer.class);
        account = new Account(transactionRepository, printer);
    }

    @Test
    void should_transactionRepository_execute_addDeposit_when_account_call_deposit() {
        //given
        int amount = 1;
        //when
        account.deposit(amount);
        //then
        verify(transactionRepository,times(1)).addDeposit(amount);
    }

    @Test
    void should_transactionRepository_execute_addWithdraw_when_account_call_withdraw(){
        //given
        int amount = 1;
        //when
        account.withdraw(amount);
        //then
        verify(transactionRepository,times(1)).addWithdraw(amount);
    }

    @Test
    void should_printer_execute_print_when_account_call_printStatement(){
        //given
        //when
        account.printStatement();
        //then
        verify(printer,times(1)).print(transactionRepository.allTransactions());
    }
}
