package com.example.demo.Service;

import com.example.demo.Configuration.IncomeBoundaryProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaxService{

    private final IncomeBoundaryProperties incomeBoundaryProperties;
    private static final Logger logger = LoggerFactory.getLogger(TaxService.class);

    public TaxService(IncomeBoundaryProperties incomeBoundaryProperties){
        this.incomeBoundaryProperties = incomeBoundaryProperties;
    }


    public Double calculateNet(Double taxableIncome)
    {
        logger.info("logger läuft");
        logger.info(incomeBoundaryProperties.taxZoneThree().lowerBoundary().toString());

        return calculateAmountZone1(taxableIncome)
                + calculateAmountZone2(taxableIncome)
                + calculateAmountZone3(taxableIncome)
                + calculateAmountZone4(taxableIncome);
    }


    private Double calculateAmountZone1(Double taxableIncome) {
        validateGrossRange(taxableIncome,
                incomeBoundaryProperties.taxZoneOne().lowerBoundary(),
                incomeBoundaryProperties.taxZoneOne().upperBoundary()
        );

        Double grossAmountToTax = 0.0;

        return taxableIncome;
    }

    private Double calculateAmountZone2(Double taxableIncome) {
        validateGrossRange(taxableIncome,
                incomeBoundaryProperties.taxZoneTwo().lowerBoundary(),
                incomeBoundaryProperties.taxZoneTwo().upperBoundary()
        );

        return taxableIncome;
    }

    private Double calculateAmountZone3(Double taxableIncome) {
        validateGrossRange(taxableIncome,
                incomeBoundaryProperties.taxZoneThree().lowerBoundary(),
                incomeBoundaryProperties.taxZoneThree().upperBoundary()
        );

        return taxableIncome;
    }

    private Double calculateAmountZone4(Double taxableIncome) {
        validateGrossRange(taxableIncome,
                incomeBoundaryProperties.taxZoneFour().lowerBoundary(),
                incomeBoundaryProperties.taxZoneFour().upperBoundary()
        );

        return taxableIncome;
    }

    private Double calculateAmountZone5(Double taxableIncome) {
        validateGrossRange(taxableIncome,
                incomeBoundaryProperties.taxZoneFive().lowerBoundary(),
                incomeBoundaryProperties.taxZoneFive().upperBoundary()
        );

        return taxableIncome;
    }

    private boolean validateGrossRange(Double taxableIncome, int lowerBoundary, int upperBoundary){

        return false;
    }
}