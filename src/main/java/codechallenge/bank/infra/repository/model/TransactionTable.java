package codechallenge.bank.infra.repository.model;

import codechallenge.bank.domain.Transaction;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionTable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long txId;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long destinationAccountId;

    public TransactionTable(BigDecimal amount, Long sourceAccountId, Long destinationAccountId){
        this.setAmount(amount);
        this.setSourceAccountId(sourceAccountId);
        this.setDestinationAccountId(destinationAccountId);
    }

    public TransactionTable(Long txId, BigDecimal amount, Long sourceAccountId, Long destinationAccountId){
        this.setTxId(txId);
        this.setSourceAccountId(sourceAccountId);
        this.setDestinationAccountId(destinationAccountId);
        this.setAmount(amount);
    }

    public Transaction toDomain(){
        return new Transaction(getTxId(),getSourceAccountId(),getDestinationAccountId(),getAmount());
    }
}
