package com.misiontic.ciclo3.reto3.service;

import com.misiontic.ciclo3.reto3.model.Cabin;
import com.misiontic.ciclo3.reto3.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll() {
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id) {
        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin cabin) {
        if(cabin.getId() == null) {
            return cabinRepository.save(cabin);
        } else {
            Optional<Cabin> cabinAux = cabinRepository.getCabin(cabin.getId());
            if(cabinAux.isEmpty()) {
                return cabinRepository.save(cabin);
            } else {
                return cabin;
            }
        }
    }
}
