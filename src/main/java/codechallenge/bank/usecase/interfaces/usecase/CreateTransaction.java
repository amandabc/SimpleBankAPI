package codechallenge.bank.usecase.interfaces.usecase;

import codechallenge.bank.domain.Transaction;

import java.math.BigDecimal;

public interface CreateTransaction {

    Transaction execute(Long sourceAccountId, Long destinationAccountId, BigDecimal amount) throws Exception;

}
