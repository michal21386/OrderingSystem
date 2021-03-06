package pl.michal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.michal.dao.Account;
import pl.michal.dao.PasswordChange;
import pl.michal.service.AccountService;

@RequestMapping("account")
@RestController
public class UserController {
	
	private final AccountService accountService;
	private final SessionRegistry sessionRegistry;
	
	@Autowired
	public UserController(AccountService accountService,
			SessionRegistry sessionRegistry) {
		this.accountService = accountService;
		this.sessionRegistry = sessionRegistry;
	}
	
	//U�ytkownik mo�e usun�� swoje konto po podaniu has�a
	@DeleteMapping("user")
	public void deleteAccount(@RequestBody String password, @AuthenticationPrincipal Account currentUser){
		accountService.Delete(password);
		for( SessionInformation out: sessionRegistry.getAllSessions(currentUser, true)) out.expireNow();
	}
	
	@GetMapping("/user")
	public Account account(){
		return accountService.Get();
	}
	
	@PutMapping("/user")
	public void ChangePassword(@RequestBody PasswordChange pass){
		accountService.Update(pass.getOldPassword(), pass.getNewPassword());
	}

}
