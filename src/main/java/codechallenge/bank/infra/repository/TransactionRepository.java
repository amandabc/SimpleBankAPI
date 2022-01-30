package codechallenge.bank.infra.repository;

import codechallenge.bank.infra.repository.model.TransactionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionTable,String> {

}
