package codechallenge.bank.usecase;

import codechallenge.bank.usecase.interfaces.CreateAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAccountImpl implements CreateAccount {

    @Override
    public String execute(){
        return "Executed";
    }
}
