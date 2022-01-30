package codechallenge.bank.infra.repository.model;

import codechallenge.bank.domain.Account;
import codechallenge.bank.domain.Transaction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class TransactionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String txId;
    private BigDecimal amount;
    private String sourceAccountId;
    private String destinationAccountId;


    public TransactionTable(String sourceAccountId, String destinationAccountId, BigDecimal amount){
        this.setSourceAccountId(sourceAccountId);
        this.setDestinationAccountId(destinationAccountId);
        this.setAmount(amount);
    }

    public TransactionTable(String txId, String sourceAccountId, String destinationAccountId, BigDecimal amount){
        this.setTxId(txId);
        this.setSourceAccountId(sourceAccountId);
        this.setDestinationAccountId(destinationAccountId);
        this.setAmount(amount);
    }
    public Transaction toDomain(){
        return new Transaction(getTxId(),getSourceAccountId(),getDestinationAccountId(),getAmount());
    }
}
