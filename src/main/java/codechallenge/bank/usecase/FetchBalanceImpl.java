package codechallenge.bank.usecase;

import codechallenge.bank.usecase.interfaces.FetchBalance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FetchBalanceImpl implements FetchBalance {

    @Override
    public BigDecimal execute(String accountId){
        return new BigDecimal(10);
    }

}
