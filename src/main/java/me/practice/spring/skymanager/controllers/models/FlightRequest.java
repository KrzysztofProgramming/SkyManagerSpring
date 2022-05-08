package me.practice.spring.skymanager.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
public class FlightRequest {
    @NotNull
    @EqualsAndHashCode.Include
    private Long flightId;
    private Long flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private Date departureDate;

    public void setDepartureDate(String departureDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
        this.departureDate = format.parse(departureDate);
    }
}
