package com.example.demo.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix= "tax-service")
public record IncomeBoundaryProperties(
        TaxZone taxZoneOne,
        TaxZone taxZoneTwo,
        TaxZone taxZoneThree,
        TaxZone taxZoneFour,
        TaxZone taxZoneFive)
{
    public record TaxZone(
            Integer lowerBoundary,
            Integer upperBoundary
    ){}
}