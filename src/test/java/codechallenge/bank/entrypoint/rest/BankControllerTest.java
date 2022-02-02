package codechallenge.bank.entrypoint.rest;

import codechallenge.bank.domain.Account;
import codechallenge.bank.domain.Transaction;
import codechallenge.bank.entrypoint.rest.RequestDTO.CreateTransactionDTO;
import codechallenge.bank.entrypoint.rest.ResponseDTO.AccountDTO;
import codechallenge.bank.entrypoint.rest.ResponseDTO.FetchBalanceResponseDTO;
import codechallenge.bank.entrypoint.rest.ResponseDTO.TransactionDTO;
import codechallenge.bank.usecase.interfaces.usecase.CreateAccount;
import codechallenge.bank.usecase.interfaces.usecase.CreateTransaction;
import codechallenge.bank.usecase.interfaces.usecase.FetchBalance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankControllerTest {

    @InjectMocks
    private BankController controller;

    @Mock private CreateAccount createAccountUsecase;
    @Mock private CreateTransaction createTransactionUsecase;
    @Mock private FetchBalance fetchBalanceUsecase;

    private UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();


    @Test
    void shouldCreateAccountAndReturnAccountData(){

        final Account returnAccount = MocksUtil.createMockForAccount();
        when(createAccountUsecase.execute()).thenReturn(returnAccount);

        final ResponseEntity<AccountDTO> response = controller.createAccount(uriBuilder);

        assertEquals(returnAccount.getBalance(), response.getBody().getBalance());
        assertEquals(returnAccount.getId(), response.getBody().getId());
    }

    @Test
    void shouldFetchBalanceAndReturnBalanceData(){

        final BigDecimal balance = new BigDecimal(10);
        when(fetchBalanceUsecase.execute(any())).thenReturn(balance);

        final ResponseEntity<FetchBalanceResponseDTO> response = controller.fetchBalanceById(1L);

        assertEquals(balance,response.getBody().getBalance());

    }

    @Test
    void shouldPerformTransactionAndReturnTransactionData() throws Exception {

        final Transaction returnTransaction = MocksUtil.createMockForTransaction();
        final CreateTransactionDTO createMockForCreateTransactionDTO = MocksUtil.createMockForCreateTransactionDTO();
        when(createTransactionUsecase.execute(any(),any(), any())).thenReturn(returnTransaction);

        final ResponseEntity<TransactionDTO> response = controller.createTransaction(createMockForCreateTransactionDTO,uriBuilder);

        assertEquals(returnTransaction.getTxId(),response.getBody().getTxId());
        assertEquals(returnTransaction.getAmount(),response.getBody().getAmount());
        assertEquals(returnTransaction.getSourceAccountId(),response.getBody().getSourceAccountId());
        assertEquals(returnTransaction.getDestinationAccountId(),response.getBody().getDestinationAccountId());

    }

}
