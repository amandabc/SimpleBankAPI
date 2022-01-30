package codechallenge.bank.domain;

import codechallenge.bank.infra.repository.model.TransactionTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    private Long txId;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private BigDecimal amount;

    public TransactionTable toEntity() {
        return new TransactionTable(
                getTxId(),
                getSourceAccountId(),
                getDestinationAccountId(),
                getAmount());
    }

    public Transaction(Long txId, Long sourceAccountId, Long destinationAccountId, BigDecimal amount){
        setTxId(txId);
        setSourceAccountId(sourceAccountId);
        setDestinationAccountId(destinationAccountId);
        setAmount(amount);
    }

}