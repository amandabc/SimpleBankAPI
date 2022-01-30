package codechallenge.bank.usecase.interfaces.usecase;

import codechallenge.bank.domain.Transaction;

import java.math.BigDecimal;

public interface CreateTransaction {
    Transaction execute(String sourceAccountId, String destinationAccountId, BigDecimal amount);
}
