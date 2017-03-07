package pl.michal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.michal.dao.Account;
import pl.michal.repository.AccountRepository;

@Service
public class AccountDetailsService implements UserDetailsService{

	public final AccountRepository accountRepository;
	
	@Autowired
	public AccountDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		return account;
	}

}
