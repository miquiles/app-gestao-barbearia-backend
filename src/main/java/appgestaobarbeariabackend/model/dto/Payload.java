package appgestaobarbeariabackend.model.dto;

import appgestaobarbeariabackend.model.Client;
import appgestaobarbeariabackend.model.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
@Data
public class Payload {
    public Client client;
    public List<Product> productList;
    private String paymentType;
    private String paymentsStatus;





}
