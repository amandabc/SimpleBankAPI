package codechallenge.bank.usecase.interfaces;

import java.math.BigDecimal;

public interface FetchBalance {

    BigDecimal execute(String accountId);
}
