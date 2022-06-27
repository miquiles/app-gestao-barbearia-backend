package appgestaobarbeariabackend.controller;

import appgestaobarbeariabackend.model.ServiceOrder;
import appgestaobarbeariabackend.service.OSService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OsController {

    private final OSService osService;


    @PostMapping("create")
    public ResponseEntity create(@RequestBody ServiceOrder serviceOrder){
        return new ResponseEntity(this.osService.orderSave(serviceOrder), HttpStatus.CREATED);

    }

    @GetMapping("/fetch-all")
    public ResponseEntity findAll(){
        return new ResponseEntity(this.osService.findAll(), HttpStatus.OK);
    }



}
