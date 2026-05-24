package com.example.demo.RestController;

import com.example.demo.Entity.TaxRequest;
import com.example.demo.Service.TaxService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaxRequestRestEndpoint {

    private final TaxService taxService;

    public TaxRequestRestEndpoint(TaxService taxService){
        this.taxService = taxService;
    }

    @PostMapping("/hello")
    public String getHello(@Valid @RequestBody TaxRequest taxableIncome){
        return taxService.calculateNet(taxableIncome.taxableIncome(), taxableIncome.taxClass()).toString();
    }
}