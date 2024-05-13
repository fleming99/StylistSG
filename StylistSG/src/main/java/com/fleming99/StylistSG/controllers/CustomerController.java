package com.fleming99.StylistSG.controllers;

import com.fleming99.StylistSG.application.CustomerAddressServiceImpl;
import com.fleming99.StylistSG.application.CustomerServiceImpl;
import com.fleming99.StylistSG.core.entities.Customer;
import com.fleming99.StylistSG.core.entities.CustomerAddress;
import com.fleming99.StylistSG.core.usecases.EntityService;
import com.fleming99.StylistSG.core.validation.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final EntityService<Customer> customerService;
    private final EntityService<CustomerAddress> addressService;

    @Autowired
    public CustomerController(EntityService<Customer> customerService, EntityService<CustomerAddress> addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }

    @GetMapping("/customers-list")
    public String showCustomersList(Model theModel){

        theModel.addAttribute("customerList", customerService.findAll());

        return "customers/customers-list";
    }

    @GetMapping("/create-customer")
    public String createCustomer(Model theModel){

        theModel.addAttribute("customer", new CustomerDTO());

        return "customers/create-customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomer(
            @Valid @ModelAttribute("customer") CustomerDTO customerDTO,
            BindingResult bindingResult, Model theModel){

        if(bindingResult.hasErrors()){
            theModel.addAttribute("registrationError", "has Errors");
            theModel.addAttribute("customer", new CustomerDTO());

            return "customers/create-customer";
        }

        CustomerAddress address = new CustomerAddress();

        address.setCustomerStreetName(customerDTO.getCustomerStreetName());
        address.setCustomerNeighborhood(customerDTO.getCustomerNeighborhood());
        address.setCustomerHouseNumber(customerDTO.getCustomerHouseNumber());
        address.setCustomerCity(customerDTO.getCustomerCity());
        address.setCustomerState(customerDTO.getCustomerState());
        address.setCustomerCountry(customerDTO.getCustomerCountry());

        Customer customer = new Customer();

        customer.setCustomerFirstName(customerDTO.getCustomerFirstName());
        customer.setCustomerLastName(customerDTO.getCustomerLastName());
        customer.setCustomerEmail(customerDTO.getCustomerEmail());
        customer.setCustomerAge(LocalDate.now().getYear() - customerDTO.getCustomerBirthDate().getYear());
        customer.setCustomerPhoneNumber(customerDTO.getCustomerPhoneNumber());
        customer.setCustomerBirthDate(customerDTO.getCustomerBirthDate());
        customer.setCustomerAddressId(address);

        customerService.save(customer);

        return "redirect:/customers/customers-list";
    }

    @GetMapping("/update-customer")
    public String updateCustomer(@RequestParam("customerId") int theId, Model theModel){

        theModel.addAttribute("customer",  customerService.findById(theId));

        return "customers/update-customer";
    }

    @PostMapping("/process-update-customer")
    public String updateCustomerProcess(@RequestParam("customerId") int theId,
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult, Model theModel){

        if(bindingResult.hasErrors()){
            theModel.addAttribute("registrationError", "has Errors");
            theModel.addAttribute("customer", customerService.findById(theId));

            return "customers/create-customer";
        }

        customerService.save(customer);

        return "redirect:/customers/customers-list";
    }

    @GetMapping("/delete-customer")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        customerService.deleteById(theId);

        return "redirect:/customers/customers-list";
    }

}
