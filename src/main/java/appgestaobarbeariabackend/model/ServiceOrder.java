package appgestaobarbeariabackend.model;

import appgestaobarbeariabackend.model.enuns.PaymentsEnum;
import appgestaobarbeariabackend.model.enuns.PaymentsStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate osDate;
    private String paymentType;
    private String paymentsStatus;
    private String clientName;
    private String clientDocument;
    private UUID osRegisterNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;


}
