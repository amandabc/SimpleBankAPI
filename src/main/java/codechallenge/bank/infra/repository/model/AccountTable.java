package codechallenge.bank.infra.repository.model;

import codechallenge.bank.domain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@Builder(toBuilder = true)

@NoArgsConstructor
public class AccountTable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;

    @Version
    private Integer version;

    public AccountTable(Long id, BigDecimal balance){
        setId(id);
        setBalance(balance);
    }

    public AccountTable(Long id, BigDecimal balance, Integer version){
        setId(id);
        setBalance(balance);
        setVersion(version);
    }

    public AccountTable(BigDecimal balance){
        setBalance(balance);
    }

    public Account toDomain(){
        return new Account(this.id,this.balance);
    }

}



