package codechallenge.bank.usecase;

import codechallenge.bank.domain.Account;
import codechallenge.bank.domain.Transaction;
import codechallenge.bank.infra.repository.AccountRepository;
import codechallenge.bank.infra.repository.TransactionRepository;
import codechallenge.bank.infra.repository.model.AccountTable;
import codechallenge.bank.infra.repository.model.TransactionTable;
import codechallenge.bank.usecase.interfaces.usecase.CreateTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateTransactionImpl implements CreateTransaction {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public Transaction execute(String sourceAccountId, String destinationAccountId, BigDecimal amount) {

        AccountTable sourceAccountTable = accountRepository.findById(sourceAccountId).orElseThrow(() -> new EntityNotFoundException(sourceAccountId));
        Account sourceAccount = sourceAccountTable.toDomain();
        if (amount.compareTo(sourceAccount.getBalance())<0) {
            //error
        } else {
            AccountTable destinationAccountTable = accountRepository.findById(destinationAccountId).orElseThrow(() -> new EntityNotFoundException(destinationAccountId));
            Account destinationAccount = destinationAccountTable.toDomain();

            sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
            destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

            accountRepository.save(sourceAccount.toEntity());
            accountRepository.save(destinationAccount.toEntity());

            return transactionRepository.save(new TransactionTable(sourceAccountId, destinationAccountId, amount)).toDomain();

        }
        }
    }