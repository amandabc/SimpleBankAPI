package codechallenge.bank.usecase;

import codechallenge.bank.domain.Account;
import codechallenge.bank.infra.repository.model.AccountTable;
import codechallenge.bank.infra.repository.model.TransactionTable;

import java.math.BigDecimal;

public class MocksUtil {
    public static AccountTable createMockForAccountTable() {
        return AccountTable.builder()
                .id(1L)
                .balance(new BigDecimal(10))
                .build();
    }

    public static AccountTable createMockForAccountTable(long id, BigDecimal balance) {
        return AccountTable.builder()
                .id(id)
                .balance(balance)
                .build();
    }

    public static Account createMockForAccount(long id, BigDecimal balance) {
        return Account.builder()
                .id(id)
                .balance(balance)
                .build();
    }

    public static TransactionTable createMockForTransactionTable() {
        return TransactionTable.builder()
                .txId(1L)
                .sourceAccountId(1L)
                .destinationAccountId(2L)
                .amount(new BigDecimal(10.0))
                .build();
    }
}
