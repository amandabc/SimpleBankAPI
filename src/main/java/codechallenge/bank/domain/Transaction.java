package codechallenge.bank.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
public class Transaction {

    private Long txId;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private BigDecimal amount;

    public Transaction(Long txId, Long sourceAccountId, Long destinationAccountId, BigDecimal amount){
        setTxId(txId);
        setSourceAccountId(sourceAccountId);
        setDestinationAccountId(destinationAccountId);
        setAmount(amount);
    }

}