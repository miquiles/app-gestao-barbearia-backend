package appgestaobarbeariabackend.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeDto {

    @NotEmpty(message = "Name field is required")
    private String name;

    @NotEmpty(message = "Document field is required")
    private String employeeDocument;

    @NotEmpty(message = "Occupation field is required")
    private String occupation;
}
