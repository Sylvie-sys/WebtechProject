package com.social.controller;

import com.social.model.Inpatient;
import com.social.serviceLayer.InpatientService;
import com.social.serviceLayer.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InpatientController {

    @Autowired
    private InpatientService service;

    @GetMapping("/inpatients")
    public String ShowInpatientList(Model model){

        List<Inpatient> listInpatients=service.listAll();
        model.addAttribute("listInpatients", listInpatients);
        return "patient_form";

    }
//    @GetMapping("/inpatients")
//    public String ShowInpatientForm(Model model){
//        model.addAttribute("listInpatients", new Inpatient());
//        return "inpatients";
//    }

//    @GetMapping  ("/patient_form/new")
//    public String saveInpatient(@ModelAttribute Inpatient patient, RedirectAttributes ra){
//        service.save(patient);
//        ra.addAttribute("message", "Data has been saved successfully save");
//        return "patient_form";
//
//    }

//    @GetMapping ("/inpatients/new")
//    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
//        try {
//            Inpatient patient=service.get(id);
//            model.addAttribute("patient", patient);
//            model.addAttribute("pageTitle", "Edit Inpatient ( ID "+id+")");
//            return "inpatient_form";
//
//        }catch (UserNotFoundException e){
//
//              ra.addAttribute("message", e.getMessage());
//        }
//
//        return "redirect:/inpatients";
//
//    }
//    @GetMapping("/inpatients/delete/{id}")
//    public String DeleteInpatient(@PathVariable ("id") Integer id, RedirectAttributes ra){
//
//        try{
//            service.delete(id);
//        }catch (UserNotFoundException e){
//            ra.addAttribute("message", e.getMessage());
//        }
//        return "redirect:/inpatients";
//    }


}




//package com.social.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class InpatientController {
//  @GetMapping("")
//    public String showHomePage() {
//return "inpatients";
//  }
//
//
//}