package appgestaobarbeariabackend.model.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PersonDto {

    @NotEmpty(message = "FirstName field is required")
    @NotNull(message = "FirstName field cannot be null")
    private String firstName;

    @NotEmpty(message = "SeconName field is required")
    @NotNull(message = "SeconName field cannot be null")
    private String secondName;

    @NotEmpty(message = "BonDate field is required")
    @NotNull(message = "BonDate field cannot be null")
    private String bornDate;

    @NotEmpty(message = "Document field is required")
    @NotNull(message = "Document field cannot be null")
    private String document;

    @NotEmpty(message = "DDD field is required")
    @NotNull(message = "DDD field cannot be null")
    private String ddd;

    @NotEmpty(message = "NumberPhone field is required")
    @NotNull(message = "NumberPhone field cannot be null")
    private String numberPhone;


    @NotEmpty(message = "Mail field is required")
    @NotNull(message = "Mail field cannot be null")
    private String mail;

}
