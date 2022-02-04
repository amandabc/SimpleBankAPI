package codechallenge.bank.infra.repository;

import codechallenge.bank.infra.repository.model.TransactionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionTable,Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    TransactionTable save(TransactionTable transactionTable);
}
