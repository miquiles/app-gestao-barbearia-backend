package appgestaobarbeariabackend.model;

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
@Table( name = "OS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate osDate;
    private String paymentType;
    private String paymentsStatus;
    private String personDocument;
    private UUID osRegisterNumber;
    private Double osTotalValue;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
