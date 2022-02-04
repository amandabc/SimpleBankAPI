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

    @Version
    private Integer version;

    public TransactionTable(BigDecimal amount, Long sourceAccountId, Long destinationAccountId){
        setAmount(amount);
        setSourceAccountId(sourceAccountId);
        setDestinationAccountId(destinationAccountId);
    }

    public TransactionTable(Long txId, BigDecimal amount, Long sourceAccountId, Long destinationAccountId){
        setTxId(txId);
        setSourceAccountId(sourceAccountId);
        setDestinationAccountId(destinationAccountId);
        setAmount(amount);
    }

    public TransactionTable(Long txId, BigDecimal amount, Long sourceAccountId, Long destinationAccountId, Integer version){
        setTxId(txId);
        setSourceAccountId(sourceAccountId);
        setDestinationAccountId(destinationAccountId);
        setAmount(amount);
        setVersion(version);
    }

    public Transaction toDomain(){
        return new Transaction(getTxId(),getSourceAccountId(),getDestinationAccountId(),getAmount());
    }
}
