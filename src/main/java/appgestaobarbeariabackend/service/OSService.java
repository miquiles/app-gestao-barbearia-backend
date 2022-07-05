package appgestaobarbeariabackend.service;

import appgestaobarbeariabackend.exception.BadRequestException;
import appgestaobarbeariabackend.model.Order;
import appgestaobarbeariabackend.model.dto.OrderDto;
import appgestaobarbeariabackend.repository.EmployeeRepository;
import appgestaobarbeariabackend.repository.OsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class OSService {

    private OsRepository osRepository;
    private EmployeeRepository employeeRepository;

    public Order orderSave(OrderDto orderDto){

        var employee = employeeRepository.findByEmployeeDocument(orderDto.getEmployeeDocument());
        var orderBuild = Order.builder()
                .osDate(LocalDate.now())
                .osRegisterNumber(UUID.randomUUID())
                .personDocument(orderDto.getPersonDocument())
                .paymentsStatus(orderDto.getPaymentsStatus())
                .paymentType(orderDto.getPaymentType())
                .productList(orderDto.getProducts())
                .osTotalValue(orderDto.getTotalValue())
                .employee(employee.get())
                .build();

        return osRepository.save(orderBuild);
    }

    public List<Order> findAll(){
        return this.osRepository.findAll();
    }

    public List<Order> findOsByDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        return this.osRepository.findByOsDate(localDate).orElseThrow(() -> new BadRequestException("Not found"));
    }

}
