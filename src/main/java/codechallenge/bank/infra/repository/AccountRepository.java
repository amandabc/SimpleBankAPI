package codechallenge.bank.infra.repository;

import codechallenge.bank.infra.repository.model.AccountTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountTable,String> {

}
