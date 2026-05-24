package com.example.demo.Entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TaxRequest(@NotNull @Min(0) Double taxableIncome) {
}