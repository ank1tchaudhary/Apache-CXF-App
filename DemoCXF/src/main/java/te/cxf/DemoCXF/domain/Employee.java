package te.cxf.DemoCXF.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Employee Name is required")
    @NotEmpty(message = "Employee Name can't be Empty")
    private String name;

    @NotNull(message = "Employee Department is required")
    @NotEmpty(message = "Employee Department can't be Empty")
    private String dept;

    @NotNull(message = "Employee Salary is required")
    @Positive(message = "Employee Salary must be grater then 0")
    private double salary;

    @NotNull(message = "Employee Email is required")
    @NotEmpty(message = "Employee Email can't be Empty")
    @Email(message = "Employee Email is invalid")
    private String email;


    @NotNull(message = "Employee Date of Birth is required")
    @NotEmpty(message = "Employee Date of Birth can't be Empty")
    private String dob;

    @NotNull(message = "Employee Phone is required")
    private long phone;
}




