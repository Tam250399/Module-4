package Tam.controller;

import Tam.model.Customer;
import Tam.model.Provinces;
import Tam.service.CustomerService;
import Tam.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Provinces province = provinceService.findById(id);
        if(province == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(province);

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", province);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/provinces")
    public ModelAndView listProvinces() {
        Iterable<Provinces> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }


    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Provinces());
        return modelAndView;
    }


    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Provinces provinces) {
        provinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Provinces());
        modelAndView.addObject("message", "New province created successdfully");
        return modelAndView;
    }


    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Provinces provinces = provinceService.findById(id);
        if (provinces != null) {
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", provinces);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }

    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Provinces provinces) {
        provinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", provinces);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;

    }
    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Provinces provinces = provinceService.findById(id);
        if (provinces != null) {
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", provinces);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
@PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Provinces provinces){
        provinceService.remove(provinces.getId());
        return "redirect:provinces";

}


}

