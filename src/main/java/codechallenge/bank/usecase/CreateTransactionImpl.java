package codechallenge.bank.usecase;

import codechallenge.bank.usecase.interfaces.CreateTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTransactionImpl implements CreateTransaction {

    @Override
    public String execute(String from, String to, String typeOfTransaction){
        return "Executed";
    }

}
