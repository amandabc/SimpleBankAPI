package codechallenge.bank.usecase;

import codechallenge.bank.domain.Account;
import codechallenge.bank.infra.repository.model.AccountTable;
import codechallenge.bank.infra.repository.AccountRepository;
import codechallenge.bank.usecase.interfaces.usecase.CreateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateAccountImpl implements CreateAccount {

    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public Account execute(){
        return accountRepository.save(new AccountTable(new BigDecimal(0))).toDomain();
    }
}
