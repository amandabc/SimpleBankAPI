package codechallenge.bank.entrypoint.rest;

import codechallenge.bank.entrypoint.rest.ResponseDTO.FetchBalanceResponseDTO;
import codechallenge.bank.usecase.interfaces.CreateAccount;
import codechallenge.bank.usecase.interfaces.CreateTransaction;
import codechallenge.bank.usecase.interfaces.FetchBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {
        private final CreateAccount createAccount;
        private final FetchBalance fetchBalance;
        private final CreateTransaction createTransaction;

    @PostMapping("/create")
    public String createAccount(){
        return createAccount.execute();

    }

    @GetMapping("/balance/{accountId}")
    public FetchBalanceResponseDTO fetchBalanceById(String accountId){
        return new FetchBalanceResponseDTO(fetchBalance.execute(accountId));
    }

    @PostMapping("/transaction/{from}/{to}/{typeOfTransaction}")
    public String createTransaction(String from, String to, String typeOfTransaction){
        return createTransaction.execute(from, to,typeOfTransaction);
    }



}
