package codechallenge.bank.usecase.interfaces;

public interface CreateTransaction {
    String execute(String from, String to, String typeOfTransaction);
}
