package com.devweb.rh.controller;

import com.devweb.rh.model.Service;
import com.devweb.rh.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Service> liste(){
        return serviceRepository.findAll();
    }
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Service add(@RequestBody(required = false) Service s){
        return serviceRepository.save(s);
    }


}
