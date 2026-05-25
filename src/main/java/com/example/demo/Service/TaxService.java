package com.example.demo.Service;

import com.example.demo.Configuration.IncomeBoundaryProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaxService{
    /*
        | Zone | Taxable income (zvE) | Formula                                          |
    | ---- | -------------------- | ------------------------------------------------ |
    | 1    | 0 € – 12,348 €       | (ESt = 0)                                        |
    | 2    | 12,349 € – 17,799 €  | (ESt = (914.51 \cdot y + 1400)\cdot y)           |
    | 3    | 17,800 € – 69,878 €  | (ESt = (173.10 \cdot z + 2397)\cdot z + 1034.87) |
    | 4    | 69,879 € – 277,825 € | (ESt = 0.42x - 11135.63)                         |
    | 5    | above 277,825 €      | (ESt = 0.45x - 19470.38)                         |
     */

    private final IncomeBoundaryProperties incomeBoundaryProperties;
    private static final Logger logger = LoggerFactory.getLogger(TaxService.class);

    public TaxService(IncomeBoundaryProperties incomeBoundaryProperties){
        this.incomeBoundaryProperties = incomeBoundaryProperties;
    }


    public Double calculateNet(Double taxableIncome, Integer taxClass)
    {
        return calculateAmountZone2(taxableIncome)
                + calculateAmountZone3(taxableIncome)
                + calculateAmountZone4(taxableIncome)
                + calculateAmountZone5(taxableIncome);
    }

    private Double calculateAmountZone2(Double taxableIncome) {
        Double taxesToPay;
        Integer lowerBoundTaxZoneTwo = incomeBoundaryProperties.taxZoneTwo().lowerBoundary();

        Double helperVariable = (taxableIncome - lowerBoundTaxZoneTwo)/10_000.0;//10.000 is a magic number defined by the department of finances in Germany
        taxesToPay = (914.51 * helperVariable + 1400)*helperVariable; //914.51 and 1400 are magic numbers defined by the department of finances in Germany

        return taxesToPay;
    }

    private Double calculateAmountZone3(Double taxableIncome) {
        return 0.0;
    }

    private Double calculateAmountZone4(Double taxableIncome) {
        return 0.0;
    }

    private Double calculateAmountZone5(Double taxableIncome) {
        return 0.0;
    }
}