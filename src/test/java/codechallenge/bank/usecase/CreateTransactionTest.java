package codechallenge.bank.usecase;

import codechallenge.bank.domain.Account;
import codechallenge.bank.domain.Transaction;
import codechallenge.bank.infra.repository.AccountRepository;
import codechallenge.bank.infra.repository.TransactionRepository;
import codechallenge.bank.infra.repository.model.AccountTable;
import codechallenge.bank.infra.repository.model.TransactionTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class CreateTransactionTest {

    @InjectMocks
    private CreateTransactionImpl useCase;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;


    @Test
    void shouldCreateTransactionIfSourceAccountHasBalanceLargerOrEqualToAmountToBeTransferred() throws Exception {
        final Account sourceAccount = MocksUtil.createMockForAccount(1L, new BigDecimal(10.0));
        final Account destinationAccount = MocksUtil.createMockForAccount(2L, new BigDecimal(0.0));
        final BigDecimal amount = new BigDecimal(10.0);

        final AccountTable sourceAccountTable = MocksUtil.createMockForAccountTable(1L, new BigDecimal(10.0));
        final AccountTable destinationAccountTable = MocksUtil.createMockForAccountTable(2L, new BigDecimal(0.0));
        final TransactionTable transactionTable = MocksUtil.createMockForTransactionTable();

        when(accountRepository.findById(any())).thenReturn(Optional.of(sourceAccountTable), Optional.of(destinationAccountTable));

        when(transactionRepository.save(any())).thenReturn(transactionTable);

        final Transaction transaction = useCase.execute(sourceAccount.getId(), destinationAccount.getId(),amount);

        assertEquals(transaction.getAmount(),amount);
        assertEquals(transaction.getSourceAccountId(),sourceAccount.getId());
        assertEquals(transaction.getDestinationAccountId(), destinationAccount.getId());

        verify(accountRepository, times(2)).findById(any());
        verify(accountRepository, times(2)).save(any());
        verify(transactionRepository, times(1)).save(any());

    }

    @Test
    void shouldThrowExceptionWhenTryingToTransferAmountLargerThanSourceAccountBalance(){
        final Account sourceAccount = MocksUtil.createMockForAccount(1L, new BigDecimal(10.0));
        final Account destinationAccount = MocksUtil.createMockForAccount(2L, new BigDecimal(0.0));
        final BigDecimal amount = new BigDecimal(20.0);

        final AccountTable sourceAccountTable = MocksUtil.createMockForAccountTable(1L, new BigDecimal(10.0));
        final AccountTable destinationAccountTable = MocksUtil.createMockForAccountTable(2L, new BigDecimal(0.0));
        final TransactionTable transactionTable = MocksUtil.createMockForTransactionTable();

        assertThrows(Exception.class, ()->useCase.execute(sourceAccount.getId(), destinationAccount.getId(),amount));
    }

    @Test
    void shouldThrowExceptionIfOneOfTheAccountsDoesntExist(){
        final Long sourceAccountId = 1L;
        final Long destinationAccountId = 2L;

        final BigDecimal amount = new BigDecimal(20.0);

        when(accountRepository.findById(any()))
                .thenThrow(new EntityNotFoundException("Account "+sourceAccountId+ " not found"));

        assertThrows(EntityNotFoundException.class, ()->useCase.execute(sourceAccountId, destinationAccountId,amount));

    }





}
