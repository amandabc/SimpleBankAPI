package codechallenge.bank.entrypoint.rest.ResponseDTO;


import codechallenge.bank.domain.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionDTO {
    private String txId;
    private String sourceAccountId;
    private String destinationAccountId;
    private BigDecimal amount;

    public TransactionDTO(Transaction transaction){
        setTxId(transaction.getTxId());
        setSourceAccountId(transaction.getSourceAccountId());
        setDestinationAccountId(transaction.getDestinationAccountId());
        setAmount(transaction.getAmount());
    }

}