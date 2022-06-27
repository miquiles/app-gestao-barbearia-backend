package appgestaobarbeariabackend.model.dto;

import appgestaobarbeariabackend.model.Person;
import appgestaobarbeariabackend.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Payload {
    public Person person;
    public List<Product> productList;
    private String paymentType;
    private String paymentsStatus;





}
