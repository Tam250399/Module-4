package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tam")
public class controllerCaculator {
    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String calculator(
            @RequestParam(name = "firstOperand") float firstOperand,
            @RequestParam( name = "secondOperand") float secondOperand,
            @RequestParam( name = "operator") String operator,
            Model model) {
        double result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0)
                    result = firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
                break;
            default:
                throw new RuntimeException("Unsupported operation");
        }
        model.addAttribute("result",result);
        return "index";
    }
}
