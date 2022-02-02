package codechallenge.bank.usecase;

import codechallenge.bank.infra.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
 class FetchBalanceTest {

    @InjectMocks
    private FetchBalanceImpl useCase;

    @Mock private AccountRepository accountRepository;

    @Test
    void shouldRaiseExceptionWhenAccountIsNotFount(){
        when(accountRepository.findById(any())).thenReturn(Optional.empty());

        final Long id = new Random().nextLong();
        assertThrows(EntityNotFoundException.class, () -> useCase.execute(id));

        verify(accountRepository, times(1)).findById(any());
    }

    @Test
    void shouldReturnFetchedBalance(){
        when(accountRepository.findById(any())).thenReturn(Optional.of(MocksUtil.createMockForAccountTable()));

        final BigDecimal balance = useCase.execute(1L);

        assertEquals(new BigDecimal(10), balance);
        verify(accountRepository, times(1)).findById(any());



    }

}
