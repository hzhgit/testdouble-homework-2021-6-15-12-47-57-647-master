package com.tw.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PrinterTest {

    private Console console;
    private Printer printer;
    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        console = mock(Console.class);
        transaction = mock(Transaction.class);
        printer = new Printer(console);
    }

    @Test
    public void should_print_statement_when_print() {
        //given
        List<Transaction> transactions = Collections.singletonList(transaction);
        //when
        printer.print(transactions);
        //then
        verify(console, times(2)).printLine(any());
    }

    @Test
    public void should_print_statement_with_right_format_when_print() {
        //given
        int runningBalance = 100;
        //when
        when(transaction.date()).thenReturn("2021-06-28");
        when(transaction.amount()).thenReturn(100);
        String result = printer.statementLine(transaction, runningBalance);
        //then
        assertEquals(String.format("%s | %s | %s",transaction.date(), transaction.amount(),runningBalance), result);
    }
}
