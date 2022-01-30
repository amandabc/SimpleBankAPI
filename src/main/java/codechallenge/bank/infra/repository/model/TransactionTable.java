package codechallenge.bank.infra.repository.model;

import codechallenge.bank.domain.Account;
import codechallenge.bank.domain.Transaction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionTable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txId;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long destinationAccountId;

    public TransactionTable(Long sourceAccountId, Long destinationAccountId, BigDecimal amount){
        this.setSourceAccountId(sourceAccountId);
        this.setDestinationAccountId(destinationAccountId);
        this.setAmount(amount);
    }

    public TransactionTable(Long txId, Long sourceAccountId, Long destinationAccountId, BigDecimal amount){
        this.setTxId(txId);
        this.setSourceAccountId(sourceAccountId);
        this.setDestinationAccountId(destinationAccountId);
        this.setAmount(amount);
    }

    public Transaction toDomain(){
        return new Transaction(getTxId(),getSourceAccountId(),getDestinationAccountId(),getAmount());
    }
}
