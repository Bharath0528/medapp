package com.patient.medapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/appointment-view")
    public String viewAppointmentPage() {
        return "redirect:/appointment-view.html";
    }
    
        @GetMapping("/")
        public String index() {
            return "redirect:/index.html";
        }
    }

