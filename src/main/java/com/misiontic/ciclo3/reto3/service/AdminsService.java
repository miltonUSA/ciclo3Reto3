package com.misiontic.ciclo3.reto3.service;

import com.misiontic.ciclo3.reto3.model.Admins;
import com.misiontic.ciclo3.reto3.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminsService {

    @Autowired
    private AdminsRepository adminsRepository;

    public List<Admins> getAll() {
        return adminsRepository.getAll();
    }
    
    public Optional<Admins> getAdmins(int id) {
        return adminsRepository.getAdmins(id);
    }

    public Admins save(Admins admin) {
        if(admin.getId() == null) {
            return adminsRepository.save(admin);
        } else {
            Optional<Admins> adminAux = adminsRepository.getAdmins(admin.getId());
            if(adminAux.isEmpty()) {
                return adminsRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
}
