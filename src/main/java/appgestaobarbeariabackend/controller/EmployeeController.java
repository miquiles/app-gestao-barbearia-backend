package appgestaobarbeariabackend.controller;

import appgestaobarbeariabackend.model.Employee;
import appgestaobarbeariabackend.model.dto.EmployeeDto;
import appgestaobarbeariabackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;



    @GetMapping("list-employees")
    public ResponseEntity findAllEmployee() {
        return new ResponseEntity(this.employeeService.findAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("fetch-employee/{document}")
    public ResponseEntity<Employee> findEmployeeDocument(@PathVariable String document) {
        var employee = employeeService.findEmployeeByDocument(document);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("register")
    public ResponseEntity create(@Valid @RequestBody EmployeeDto employeeDto) {
        try {
            return new ResponseEntity(this.employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/remove/{document}")
    public ResponseEntity<Void> delete(@PathVariable String document) {
        employeeService.delete(document);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
