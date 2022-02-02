package codechallenge.bank.entrypoint.rest.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)

public class FetchBalanceResponseDTO {
    private BigDecimal balance;

    public FetchBalanceResponseDTO(BigDecimal balance){
        setBalance(balance);
    }

}
