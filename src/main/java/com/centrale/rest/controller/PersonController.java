package com.centrale.rest.controller;

import com.centrale.rest.entity.PersonEntity;
import com.centrale.rest.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value = "/person")
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;


    @GetMapping(value = "/getPersons")
    public Iterable<PersonEntity> getEachPersonEntity(){
       return this.personRepository.findAll();
    }

    @GetMapping(value = "/getPerson/{id}")
    public Optional<PersonEntity> getIdPersonEntity(@PathVariable Long id){return this.personRepository.findById(id);}

    @DeleteMapping (value = "/deletePerson/{id}")
    public void DeletePersons(@PathVariable long id){
        personRepository.deleteById(id);
    }

    @PostMapping(value = "/newPerson")
    public PersonEntity createNewPersonEntity(@RequestBody PersonEntity personEntity) {
        this.personRepository.save(personEntity);
        return personEntity;
    }


    @PostMapping(value = "/verifPerson")
    public boolean verificationUser(@RequestBody PersonEntity personEntity){
        int n = personRepository.countAllByNameAndPassword(personEntity.getName(), personEntity.getPassword());
        if(n==0){return false;}else{return true;}
    }
}
