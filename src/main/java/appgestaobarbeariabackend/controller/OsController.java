package appgestaobarbeariabackend.controller;

import appgestaobarbeariabackend.model.dto.OrderDto;
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
    public ResponseEntity create(@RequestBody OrderDto orderDto){
        return new ResponseEntity(this.osService.orderSave(orderDto), HttpStatus.CREATED);

    }

    @GetMapping("/fetch-all")
    public ResponseEntity findAll(){
        return new ResponseEntity(this.osService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/fetch-by-date/{date}")
    public ResponseEntity findByDate(@PathVariable("date") String date){
        return new ResponseEntity(this.osService.findOsByDate(date), HttpStatus.OK);
    }



}
