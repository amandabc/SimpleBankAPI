package codechallenge.bank.entrypoint.rest.ResponseDTO;

import java.math.BigDecimal;

public class FetchBalanceResponseDTO {
    private BigDecimal balance;

    public FetchBalanceResponseDTO(BigDecimal balance){
        this.balance = balance;
    }

}
