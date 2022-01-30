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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

        private final CreateAccount createAccount;
        private final FetchBalance fetchBalance;
        private final CreateTransaction createTransaction;

    @PostMapping("/account")
    public ResponseEntity<AccountDTO> createAccount(UriComponentsBuilder uriBuilder){
        Account account = createAccount.execute();
        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountDTO(account));
    }

    @GetMapping(value = "/{accountId}/balance")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FetchBalanceResponseDTO> fetchBalanceById(@PathVariable Long accountId){

        return ResponseEntity.ok().body(new FetchBalanceResponseDTO(fetchBalance.execute(accountId)));
    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionDTO> createTransaction(
                                        @RequestBody CreateTransactionDTO createTransactionDTO,
                                        UriComponentsBuilder uriBuilder){
        try {
            Transaction transaction = createTransaction.execute(
                    createTransactionDTO.getSourceAccountId(),
                    createTransactionDTO.getDestinationAccountId(),
                    createTransactionDTO.getAmount());

            URI uri = uriBuilder.path("/transaction/{id}").buildAndExpand(transaction.getTxId()).toUri();
            return ResponseEntity.created(uri).body(new TransactionDTO(transaction));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }



}
