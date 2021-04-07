package by.tms.calculatorthymeleaf.service;

import by.tms.calculatorthymeleaf.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private double sum(double firstNumber, double secondNum) {
        return firstNumber + secondNum;
    }

    private double sub(double firstNumber, double secondNum) {
        return firstNumber - secondNum;
    }

    private double mult(double firstNumber, double secondNum) {
        return firstNumber * secondNum;
    }

    private double div(double firstNumber, double secondNum) {
        return firstNumber / secondNum;
    }

    public Operation calculate(Operation operation) {
        switch (operation.getOperation()) {
            case "sum":
                operation.setResult(sum(operation.getFirstNum(), operation.getSecondNum()));
                break;
            case "sub":
                operation.setResult(sub(operation.getFirstNum(), operation.getSecondNum()));
                break;
            case "mult":
                operation.setResult(mult(operation.getFirstNum(), operation.getSecondNum()));
                break;
            case "div":
                operation.setResult(div(operation.getFirstNum(), operation.getSecondNum()));
                break;
            default:
                throw new IllegalStateException("Wrong operation type!");
        }
        return operation;
    }


}
