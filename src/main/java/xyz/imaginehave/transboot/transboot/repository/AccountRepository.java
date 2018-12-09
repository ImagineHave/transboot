package xyz.imaginehave.transboot.transboot.repository;

import org.springframework.transaction.annotation.Transactional;

import xyz.imaginehave.transboot.transboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

}
