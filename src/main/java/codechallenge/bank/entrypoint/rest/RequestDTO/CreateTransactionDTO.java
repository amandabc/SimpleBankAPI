package codechallenge.bank.entrypoint.rest.RequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)
public class CreateTransactionDTO {

    private Long sourceAccountId;
    private Long destinationAccountId;
    private BigDecimal amount;

}
