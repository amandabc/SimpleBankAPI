package codechallenge.bank.usecase;

import codechallenge.bank.domain.Account;
import codechallenge.bank.infra.repository.AccountRepository;
import codechallenge.bank.infra.repository.model.AccountTable;
import codechallenge.bank.usecase.interfaces.usecase.FetchBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FetchBalanceImpl implements FetchBalance {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public BigDecimal execute(Long accountId){
        AccountTable account = accountRepository.findById(accountId).orElseThrow(() ->
                new EntityNotFoundException("Account "+accountId+ " not found"));
        return account.toDomain().getBalance();
    }

}
