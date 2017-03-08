package pl.michal.service;

import pl.michal.dao.Client;

public interface ClientService {

	public Client get();
	public void update(Client newClient);
	
}
