package appgestaobarbeariabackend.service;

import appgestaobarbeariabackend.exception.BadRequestException;
import appgestaobarbeariabackend.model.Employee;
import appgestaobarbeariabackend.model.dto.EmployeeDto;
import appgestaobarbeariabackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    public final EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }


    public Employee findEmployeeByDocument(String document) {
        return employeeRepository.findByEmployeeDocument(document).orElseThrow(() -> new BadRequestException("Object not found! DOCUMENT: "
                + document + ", Tipo: " + EmployeeService.class.getName()));
    }

    public void delete(String document) {
        employeeRepository.delete(findEmployeeByDocument(document));
    }

    public Employee saveEmployee(EmployeeDto employeeDto) throws Exception {
        var employeetExists = employeeRepository.findByEmployeeDocument(employeeDto.getEmployeeDocument()).isEmpty();
        if (employeetExists) {
            Employee employee = Employee.builder()
                    .name(employeeDto.getName())
                    .employeeDocument(employeeDto.getEmployeeDocument())
                    .occupation(employeeDto.getOccupation())
                    .build();
            return this.employeeRepository.save(employee);
        } else {
            throw new Exception("Employee exists");
        }
    }
}
