package pl.michal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.michal.dao.Account;
import pl.michal.repository.AccountRepository;

//@Transactional
@Service
public class AccountServiceBean implements AccountService{

	private final AccountRepository accountRepository;

	
	@Autowired
	public AccountServiceBean(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void Delete(String password) {
		Account account = accountRepository.findAuthorizedAccount();
		if(new BCryptPasswordEncoder().matches(password, account.getPassword())){
			accountRepository.delete(account);
		}
	}

	@Override
	public Account Get() {
		return accountRepository.findAuthorizedAccount();
	}

	@Override
	@Transactional
	public void Update(String oldPassword, String newPassword) throws BadCredentialsException {
		Account account = accountRepository.findAuthorizedAccount();
		if(new BCryptPasswordEncoder().matches(oldPassword, account.getPassword())){
			account.setPassword(new BCryptPasswordEncoder().encode(newPassword));
		}
		else throw new BadCredentialsException("Podano nieprawid³owe has³o");
	}

}
