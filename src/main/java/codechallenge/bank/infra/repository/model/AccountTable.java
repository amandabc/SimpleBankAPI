package codechallenge.bank.infra.repository.model;

import codechallenge.bank.domain.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class AccountTable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private BigDecimal balance;

    public AccountTable(String id, BigDecimal balance){
        setId(id);
        setBalance(balance);
    }

    public AccountTable(BigDecimal balance){
        setBalance(balance);
    }

    public Account toDomain(){
        return new Account(this.id,this.balance);
    }


}



