package codechallenge.bank.domain;

import codechallenge.bank.infra.repository.model.AccountTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class Account {

    private Long id;
    private BigDecimal balance;

    public Account(BigDecimal balance){
        setBalance(balance);
    }

    public Account(Long accountId, BigDecimal balance){
        setBalance(balance);
        setId(accountId);
    }

    public AccountTable toEntity(){
        return new AccountTable(this.getId(), this.getBalance());
    }


}


