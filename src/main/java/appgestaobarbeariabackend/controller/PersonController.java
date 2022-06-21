package appgestaobarbeariabackend.controller;

import appgestaobarbeariabackend.model.Client;
import appgestaobarbeariabackend.repository.ClientRepository;
import appgestaobarbeariabackend.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("person")
public class PersonController {

    private ClientRepository clientRepository;
    private final ClientService clientService;

    @PostMapping("register")
    public ResponseEntity create(@RequestBody Client client){
        try {
            return new ResponseEntity(this.clientService.saveClient(client), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

    }
    @GetMapping("fetch-client/{document}")
    public ResponseEntity findClient(@PathVariable String cpf){
        try {
            return new ResponseEntity(this.clientService.findClientByDocument(cpf), HttpStatus.CONTINUE);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("list-clients")
    public ResponseEntity findAllClients(){
       return new ResponseEntity(this.clientRepository.findAll(), HttpStatus.OK);
    }





}
