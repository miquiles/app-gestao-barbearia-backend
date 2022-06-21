package appgestaobarbeariabackend.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String secondName;
    @Column(length = 30, nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String bornDate;
    @Column(length = 11, nullable = false)
    private String document;
    @Column(length = 3, nullable = false)
    private int ddd;
    @Column(length = 10, nullable = false)
    private int numberPhone;
    @Column(length = 50)
    private String mail;

}
