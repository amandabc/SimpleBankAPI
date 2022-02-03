package codechallenge.bank.usecase;

import codechallenge.bank.domain.Account;
import codechallenge.bank.infra.repository.AccountRepository;
import codechallenge.bank.infra.repository.model.AccountTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)

class CreateAccountTest {

    @InjectMocks
    private CreateAccountImpl useCase;

    @Mock private AccountRepository accountRepository;

    @Test
    void shouldCreateAccountSuccessfully(){

        AccountTable accountTable = MocksUtil.createMockForAccountTable();

        when(accountRepository.save(any())).thenReturn(accountTable);

        final Account account = useCase.execute();

        assertEquals(account.getBalance(),accountTable.toDomain().getBalance() );
        assertEquals(account.getId(),accountTable.toDomain().getId());

        verify(accountRepository, times(1)).save(any());
    }
}
