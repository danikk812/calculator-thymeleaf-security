package by.tms.calculatorthymeleaf.controller;

import by.tms.calculatorthymeleaf.model.Operation;
import by.tms.calculatorthymeleaf.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public ModelAndView getCalculatorPage(ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        modelAndView.addObject("operationForm", new Operation());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView doCalculation(@Valid @ModelAttribute("operationForm") Operation operation,
                                           BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession) {
        if (!bindingResult.hasErrors()) {
            if (!(operation.getOperation().equals("div") && operation.getSecondNum() == 0)) {
                calculatorService.calculate(operation);
                modelAndView.addObject("result", operation);
            } else {
                modelAndView.addObject("result", "Divide by zero!");
            }
        }
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

}
