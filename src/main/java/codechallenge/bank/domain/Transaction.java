package codechallenge.bank.domain;

import codechallenge.bank.infra.repository.model.TransactionTable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Transaction {
    private String txId;
    private String sourceAccountId;
    private String destinationAccountId;
    private BigDecimal amount;

    public TransactionTable toEntity() {
        return new TransactionTable(
                getTxId(),
                getSourceAccountId(),
                getDestinationAccountId(),
                getAmount());
    }

    public Transaction(String txId, String sourceAccountId, String destinationAccountId, BigDecimal amount){
        setTxId(txId);
        setSourceAccountId(sourceAccountId);
        setDestinationAccountId(destinationAccountId);
        setAmount(amount);
    }

}