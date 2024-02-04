package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewErrorController {

    @GetMapping("/purchaseError")
    public String purchaseError() {
        return "purchaseError";
    }
}