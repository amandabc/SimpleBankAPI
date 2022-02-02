package codechallenge.bank.domain;

import codechallenge.bank.infra.repository.model.AccountTable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
public class Account {

    private Long id;
    private BigDecimal balance;

    public Account(Long accountId, BigDecimal balance){
        setBalance(balance);
        setId(accountId);
    }

    public AccountTable toEntity(){
        return new AccountTable(this.getId(), this.getBalance());
    }

}


