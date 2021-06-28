package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    void should_transactionRepository_execute_addDeposit_when_account_call_deposit() {
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository,printer);
        int amount = 1;
        //when
        account.deposit(amount);
        //then
        verify(transactionRepository,times(1)).addDeposit(amount);
    }

    @Test
    void should_transactionRepository_execute_addWithdraw_when_account_call_withdraw(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository,printer);
        int amount = 1;
        //when
        account.withdraw(amount);
        //then
        verify(transactionRepository,times(1)).addWithdraw(amount);
    }

    @Test
    void should_printer_execute_print_when_account_call_printStatement(){
        //given
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository,printer);
        //when
        account.printStatement();
        //then
        verify(printer,times(1)).print(transactionRepository.allTransactions());
    }
}
