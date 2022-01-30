package codechallenge.bank.usecase.interfaces.usecase;


import java.math.BigDecimal;

public interface FetchBalance {

    BigDecimal execute(Long accountId);
}
