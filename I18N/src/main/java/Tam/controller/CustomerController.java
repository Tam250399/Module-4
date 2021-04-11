package Tam.controller;

import Tam.model.Customer;
import Tam.model.Product;
import Tam.service.customerService.ICustomerService;
import Tam.service.productService.IProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
@Autowired
    private ICustomerService customerService;

@Autowired
    private IProductService productService;

@GetMapping("/create-customer")
    public ModelAndView showCreate(){
    ModelAndView modelAndView = new ModelAndView("/customer/create");
    modelAndView.addObject("customer", new Customer());
    return modelAndView;
}

@PostMapping("create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
    customerService.save(customer);
    ModelAndView modelAndView = new ModelAndView("/customer/create");
    modelAndView.addObject("customer",new Customer());
    modelAndView.addObject("message","New customer successfully");
    return modelAndView;
}
@GetMapping("/customers")
public ModelAndView listCustomer(@RequestParam("t") Optional<String> t){
    List<Customer> customer = customerService.findAll();
    ModelAndView modelAndView = new ModelAndView("/customer/list");
    modelAndView.addObject("customers", customer );
    return modelAndView;
}

}
