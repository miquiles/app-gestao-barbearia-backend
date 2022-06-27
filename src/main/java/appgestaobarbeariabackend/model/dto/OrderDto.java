package appgestaobarbeariabackend.model.dto;

import appgestaobarbeariabackend.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    // client
    private String document;

    // produto
    private List<Product> products;

    //OS
    private String paymentType;
    private String paymentsStatus;



}
