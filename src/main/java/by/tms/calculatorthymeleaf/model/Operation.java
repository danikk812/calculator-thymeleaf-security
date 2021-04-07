package by.tms.calculatorthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    @NotNull
    private double firstNum;
    @NotNull
    private double secondNum;
    @NotBlank
    @Pattern(regexp = "^([a-z]{3,4})$",  message = "Should be only 3-4 symbols of operation")
    private String operation;
    private double result;

    public Operation(double firstNum, double secondNum, String operation) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operation = operation;
    }

    @Override
    public String toString() {
        return firstNum + " " + operation + " " + secondNum + " = " + result;
    }
}
