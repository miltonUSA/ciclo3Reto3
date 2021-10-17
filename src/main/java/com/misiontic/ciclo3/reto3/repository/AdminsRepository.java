package com.misiontic.ciclo3.reto3.repository;

import com.misiontic.ciclo3.reto3.model.Admins;
import com.misiontic.ciclo3.reto3.repository.crud.AdminsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminsRepository {

    @Autowired
    private AdminsCrudRepository adminsCrudRepository;

    public List<Admins> getAll() {
        return (List<Admins>) adminsCrudRepository.findAll();
    }

    public Optional<Admins> getAdmins(int id) {
        return adminsCrudRepository.findById(id);
    }

    // Este método también es útil para hacer actualizaciones.
    public Admins save(Admins admin) {
        return adminsCrudRepository.save(admin);
    }
}
