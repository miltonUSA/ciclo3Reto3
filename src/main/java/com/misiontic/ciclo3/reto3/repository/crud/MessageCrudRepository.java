package com.misiontic.ciclo3.reto3.repository.crud;

import com.misiontic.ciclo3.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
