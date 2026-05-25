package com.example.demo.ServiceTest;

import com.example.demo.Configuration.IncomeBoundaryProperties;
import com.example.demo.Service.TaxService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {

    private TaxService taxService;

    @BeforeEach
    void setUp() {
        taxService = new TaxService(new IncomeBoundaryProperties(
                new IncomeBoundaryProperties.TaxZone(0, 12348),
                new IncomeBoundaryProperties.TaxZone(12349, 17799),
                new IncomeBoundaryProperties.TaxZone(17800, 69878),
                new IncomeBoundaryProperties.TaxZone(69879, 277825),
                new IncomeBoundaryProperties.TaxZone(277826, null)
        ));
    }

    @Test
    void calculateNetReturnsZeroForZeroTaxableIncome() {
        assertThat(taxService.calculateNet(0.0, 1)).isEqualTo(0.0);
    }

    @Test
    void calculateNetreturnsZeroFor10000TaxableIncome(){
        assertThat(taxService.calculateNet(10_000.0, 1)).isEqualTo(0.0);
    }

    @Test
    void calulateNetReturns15_000TaxZone2TaxClass1(){
        assertThat(taxService.calculateNet(15_000.0,1).intValue()).isEqualTo(435);
    }

}