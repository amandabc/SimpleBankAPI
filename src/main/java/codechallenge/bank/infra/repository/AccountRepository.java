package codechallenge.bank.infra.repository;

import codechallenge.bank.infra.repository.model.AccountTable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;


import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountTable,Long> {

    @Transactional
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    AccountTable save(AccountTable accountTable);

    @Transactional
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<AccountTable> findById(Long id);
}
