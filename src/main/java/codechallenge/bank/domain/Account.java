package codechallenge.bank.domain;

import codechallenge.bank.infra.repository.model.AccountTable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Account {

    private String id;
    private BigDecimal balance;

    public Account(BigDecimal balance){
        setBalance(balance);
    }

    public Account(String accountId, BigDecimal balance){
        setBalance(balance);
        setId(accountId);
    }

    public AccountTable toEntity(){
        return new AccountTable(this.getId(), this.getBalance());
    }


}


