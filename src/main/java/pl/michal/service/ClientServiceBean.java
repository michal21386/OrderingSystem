package pl.michal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michal.dao.Client;
import pl.michal.repository.ClientRepository;

/**
 * 
 * @author Michal
 *
 */

@Service
public class ClientServiceBean implements ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientServiceBean(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client get() {
		return clientRepository.findAuthorizedClient();
	}
	
	@Override
	@Transactional
	public void update(Client newClient) {
		Client client = clientRepository.findAuthorizedClient();
		if(newClient != null){
			if(newClient.getCompanyName()!=null) client.setCompanyName(newClient.getCompanyName());
			if(newClient.getEmail()!=null) client.setEmail(newClient.getEmail());
			if(newClient.getFirstName()!=null) client.setFirstName(newClient.getFirstName());
			if(newClient.getLastName()!=null) client.setLastName(newClient.getLastName());
			if(newClient.getPhoneNo()!=null) client.setPhoneNo(newClient.getPhoneNo());
		}
	}

}
