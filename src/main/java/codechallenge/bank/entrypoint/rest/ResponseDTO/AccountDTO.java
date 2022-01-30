package codechallenge.bank.entrypoint.rest.ResponseDTO;

import codechallenge.bank.domain.Account;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountDTO {

    private String id;
    private BigDecimal balance;

    public AccountDTO (Account account){
        setId(account.getId());
        setBalance(account.getBalance());
    }
}
