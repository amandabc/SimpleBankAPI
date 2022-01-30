package codechallenge.bank.entrypoint.rest.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateTransactionDTO {

    private String sourceAccountId;
    private String destinationAccountId;
    private BigDecimal amount;

}
