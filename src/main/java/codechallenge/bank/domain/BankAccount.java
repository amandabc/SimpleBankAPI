package codechallenge.bank.domain;

import java.math.BigDecimal;

public class BankAccount {

    public BankAccount(String accountId, BigDecimal balance){
        this.accountId = accountId;
        this.balance = balance;
    }
    private String accountId;
    private BigDecimal balance;
}
