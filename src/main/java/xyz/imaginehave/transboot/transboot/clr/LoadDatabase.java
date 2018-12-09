//package xyz.imaginehave.transboot.transboot.clr;
//
//import lombok.extern.slf4j.Slf4j;
//import xyz.imaginehave.transboot.transboot.entity.Account;
//import xyz.imaginehave.transboot.transboot.entity.Transaction;
//import xyz.imaginehave.transboot.transboot.entity.TransectUser;
//import xyz.imaginehave.transboot.transboot.repository.AccountRepository;
//import xyz.imaginehave.transboot.transboot.repository.TransactionRepository;
//import xyz.imaginehave.transboot.transboot.repository.TransectUserRepository;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//class LoadDatabase {
//	
//	private static final String USERNAME1 = "USERNAME1"; 
//	private static final String USERNAME2 = "USERNAME2"; 
//	private static final String ACCOUNTNAME1 = "ACCOUNTNAME1"; 
//	private static final String ACCOUNTNAME2 = "ACCOUNTNAME2";
//	private static final String DATE1 = "20181209";
//	private static final String DATE2 = "20181109";
//	
//	private TransectUser createUser(String username) {
//		TransectUser user = new TransectUser();
//		user.setUserName(username);
//		user.setKey("key");
//		return user;
//	}
//	
//	
//	private Account createAccount(String accountname, String openedDate, TransectUser transectUser) {
//		Account account = new Account();
//		account.setAccountName(accountname);
//		account.setOpenedDate(LocalDate.parse(openedDate, DateTimeFormatter.ofPattern("yyyyMMdd")));
//		account.setTransectUser(transectUser);
//		return account;
//	}
//	
//	
//	private Transaction createTransaction(double amount, String date, Account payee, Account payer, TransectUser transectUser) {
//		Transaction transaction = new Transaction();
//		transaction.setAmount(BigDecimal.valueOf(amount));
//		transaction.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd")));
//		transaction.setPayee(payee);
//		transaction.setPayer(payer);
//		transaction.setTransectUser(transectUser);
//		return transaction;
//	}
//
//	@Bean
//	CommandLineRunner initDatabase(TransectUserRepository transectUserRepository,
//			AccountRepository accountRepository,
//			TransactionRepository transactionRepository
//			) {
//		return args -> {
//			
//			TransectUser user1 = createUser(USERNAME1);
//			TransectUser user2 = createUser(USERNAME2);
//			
//			log.info("Preloading " + transectUserRepository.save(user1));
//			log.info("Preloading " + transectUserRepository.save(user2));
//			
//			Account account1 = createAccount(ACCOUNTNAME1, DATE1, user1);
//			Account account2 = createAccount(ACCOUNTNAME2, DATE1, user1);
//			
//			log.info("Preloading " + accountRepository.save(account1));
//			log.info("Preloading " + accountRepository.save(account2));
//			
//			Transaction transaction1 = createTransaction(1000.0, DATE1, account1, account2, user1);
//			Transaction transaction2 = createTransaction(1000.0, DATE2, account1, account2, user1);
//			
//			
//			log.info("Preloading " + transactionRepository.save(transaction1));
//			log.info("Preloading " + transactionRepository.save(transaction2));
//		};
//	}
//}