package com.fleming99.StylistSG.controllers;

import com.fleming99.StylistSG.application.CustomerServiceImpl;
import com.fleming99.StylistSG.application.JobTypeServiceImpl;
import com.fleming99.StylistSG.application.JobsServiceImpl;
import com.fleming99.StylistSG.application.StylistEmployeeServiceImpl;
import com.fleming99.StylistSG.core.entities.*;
import com.fleming99.StylistSG.core.usecases.EntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobsController {

    private final EntityService<Jobs> jobsService;

    private final EntityService<Customer> customerService;

    private final EntityService<JobType> jobTypeService;

    private final EntityService<StylistEmployee> stylistEmployee;

    private final EntityService<PaymentDetails> paymentDetailsEntityService;

    @Autowired
    public JobsController(EntityService<Jobs> jobsService, EntityService<Customer> customerService, EntityService<JobType> jobTypeService, EntityService<StylistEmployee> stylistEmployee, EntityService<PaymentDetails> paymentDetailsEntityService) {
        this.jobsService = jobsService;
        this.customerService = customerService;
        this.jobTypeService = jobTypeService;
        this.stylistEmployee = stylistEmployee;
        this.paymentDetailsEntityService = paymentDetailsEntityService;
    }

    @GetMapping("/jobs-list")
    public String showJobsList(Model theModel){

        theModel.addAttribute("jobList", jobsService.findAll());

        return "jobs/jobs-list";
    }

    @GetMapping("/create-new-job")
    public String createJob(Model theModel){

        List<Customer> customers = customerService.findAll();
        List<JobType> jobTypes = jobTypeService.findAll();
        List<StylistEmployee> stylistEmployees = stylistEmployee.findAll();

        theModel.addAttribute("job", new Jobs());
        theModel.addAttribute("customersList", customers);
        theModel.addAttribute("jobType", jobTypes);
        theModel.addAttribute("stylist", stylistEmployees);

        return "jobs/create-new-job";
    }

    @PostMapping("/save-job")
    public String saveJob(
            @Valid @ModelAttribute("job") Jobs jobs,
            BindingResult bindingResult, Model theModel){

        if(bindingResult.hasErrors()){

            System.out.println(bindingResult);
            theModel.addAttribute("registrationError", "Impossible");
            theModel.addAttribute("job", new Jobs());
            return "jobs/create-new-job";
        }

        if (jobs.getInitialDate() == null){
            jobs.setInitialDate(LocalDate.now());
        }
        jobs.setJobStatus(true);

        jobsService.save(jobs);

        return "redirect:/jobs/jobs-list";
    }

    @GetMapping("/update-job")
    public String updateJob(@RequestParam("jobId") int theId, Model theModel){

        List<Customer> customers = customerService.findAll();
        List<JobType> jobTypes = jobTypeService.findAll();
        List<StylistEmployee> stylistEmployees = stylistEmployee.findAll();
        List<PaymentDetails> paymentDetails = paymentDetailsEntityService.findAll();

        theModel.addAttribute("job", jobsService.findById(theId));
        theModel.addAttribute("customersList", customers);
        theModel.addAttribute("jobType", jobTypes);
        theModel.addAttribute("stylist", stylistEmployees);
        theModel.addAttribute("paymentDetails", paymentDetails);

        return "jobs/update-job";
    }

    @GetMapping("/delete-job")
    public String deleteJob(@RequestParam("jobId") int theId){

        jobsService.deleteById(theId);

        return "redirect:/jobs/jobs-list";
    }


}
