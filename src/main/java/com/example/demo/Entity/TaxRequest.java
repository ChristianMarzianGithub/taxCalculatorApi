package com.example.demo.Entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TaxRequest(
        @NotNull @Min(0)
        Double taxableIncome,

        @NotNull @Min(1) @Max(5)
        Integer taxClass)
{
}