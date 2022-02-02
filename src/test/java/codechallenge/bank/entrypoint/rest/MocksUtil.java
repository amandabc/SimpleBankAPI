package codechallenge.bank.entrypoint.rest;

import codechallenge.bank.domain.Account;
import codechallenge.bank.domain.Transaction;
import codechallenge.bank.entrypoint.rest.RequestDTO.CreateTransactionDTO;
import codechallenge.bank.entrypoint.rest.ResponseDTO.FetchBalanceResponseDTO;

import java.math.BigDecimal;

public class MocksUtil {

    public static Account createMockForAccount(){
        return Account.builder()
                .id(1L)
                .balance(new BigDecimal(0))
                .build();
    }

    public static Transaction createMockForTransaction(){
        return Transaction.builder()
                .txId(1L)
                .sourceAccountId(1L)
                .destinationAccountId(2L)
                .amount(new BigDecimal(10))
                .build();
    }


    public static CreateTransactionDTO createMockForCreateTransactionDTO() {
        return CreateTransactionDTO.builder()
                .sourceAccountId(1L)
                .destinationAccountId(2L)
                .amount(new BigDecimal(10))
                .build();
    }

    public static FetchBalanceResponseDTO createMockForFetchBalanceResponseDTO() {
        return FetchBalanceResponseDTO.builder()
                .balance(new BigDecimal(10))
                .build();

    }
}
