package com.misiontic.ciclo3.reto3.web;

import com.misiontic.ciclo3.reto3.model.Admins;
import com.misiontic.ciclo3.reto3.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admins")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminsController {

    @Autowired
    private AdminsService adminsService;

    @GetMapping("/all")
    public List<Admins> getAdmins() {
        return adminsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admins> getAdmin(@PathVariable("id") int id) {
        return adminsService.getAdmins(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admins save(@RequestBody Admins admin) {
        return adminsService.save(admin);
    }
}
