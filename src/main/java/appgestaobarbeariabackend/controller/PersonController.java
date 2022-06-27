package appgestaobarbeariabackend.controller;

import appgestaobarbeariabackend.model.Person;
import appgestaobarbeariabackend.model.dto.PersonDto;
import appgestaobarbeariabackend.repository.PersonRepository;
import appgestaobarbeariabackend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("person")
public class PersonController {

    private PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("list-clients")
    public ResponseEntity findAllPersons() {
        return new ResponseEntity(this.personService.findAllPersons(), HttpStatus.OK);
    }


    @GetMapping("fetch-client/{document}")
    public ResponseEntity<Person> findClientDocument(@PathVariable String document) {
        var client = personService.findClientByDocument(document);
        return ResponseEntity.ok().body(client);

    }

    @PostMapping("register")
    public ResponseEntity create(@Valid @RequestBody PersonDto personDto) {
        try {
            return new ResponseEntity(this.personService.saveClient(personDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/edit/{document}")
    public ResponseEntity<Void> replace(@PathVariable String document, @RequestBody PersonDto personDto) {
        personService.replace(personDto, document);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/remove/{document}")
    public ResponseEntity<Void> delete(@PathVariable String document) {
        personService.delete(document);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
