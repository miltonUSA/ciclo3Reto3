package com.misiontic.ciclo3.reto3.service;

import com.misiontic.ciclo3.reto3.model.Client;
import com.misiontic.ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        if(client.getId()==null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> clientAux = clientRepository.getClient(client.getId());
            if(clientAux.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
}
