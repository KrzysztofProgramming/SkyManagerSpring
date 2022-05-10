package me.practice.spring.skymanager.controllers;

import me.practice.spring.skymanager.controllers.models.CodeAndDateRequest;
import me.practice.spring.skymanager.controllers.models.FlightRequest;
import me.practice.spring.skymanager.controllers.models.LoadRequest;
import me.practice.spring.skymanager.controllers.models.NumberAndDateRequest;
import me.practice.spring.skymanager.models.Flight;
import me.practice.spring.skymanager.models.FlightBaggage;
import me.practice.spring.skymanager.models.FlightCargo;
import me.practice.spring.skymanager.repositories.BaggageRepository;
import me.practice.spring.skymanager.repositories.CargoRepository;
import me.practice.spring.skymanager.repositories.FlightRepository;
import me.practice.spring.skymanager.searchers.FlightSearcher;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "http://localhost:4100/", maxAge = 3600)
@RequestMapping("api/")
public class MainController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private BaggageRepository baggageRepository;

    @Autowired
    private FlightSearcher flightSearcher;

    @PutMapping("uploadFlights")
    public ResponseEntity<?> uploadFlights(@RequestBody @Valid List<FlightRequest> flights){
        try {
            this.flightRepository.saveAll(flights.stream().map(Flight::new).collect(Collectors.toList()));
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("uploadLoads")
    public ResponseEntity<?> uploadLoads(@RequestBody @Valid List<LoadRequest> loads){
        List<FlightCargo> cargo = new LinkedList<>();
        List<FlightBaggage> baggage = new LinkedList<>();
        loads.forEach(load->{
            cargo.addAll(load.getCargo().stream().map(model -> new FlightCargo(model, load.getFlightId())).toList());
            baggage.addAll(load.getBaggage().stream().map(model->new FlightBaggage(model, load.getFlightId())).toList());
        });
        try {
            this.cargoRepository.saveAll(cargo);
            this.baggageRepository.saveAll(baggage);
        }
        catch(DataIntegrityViolationException e){
            if(e.getCause() instanceof ConstraintViolationException)
                return ResponseEntity.badRequest().body("Nonexistent flightId");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("flightNumberStats")
    public ResponseEntity<?> getNumberDateStats(@Valid @RequestBody NumberAndDateRequest request){
        return ResponseEntity.ok(this.flightSearcher.statsByDateAndNumber(
                request.getStartDate(), request.getEndDate(), request.getFlightNumber()));
    }

    @PostMapping("IATACodeStats")
    public ResponseEntity<?> getCodeDateStats(@Valid @RequestBody CodeAndDateRequest request){
        return ResponseEntity.ok(this.flightSearcher.statsByDateAndCode(
                request.getStartDate(), request.getEndDate(), request.getCode()));
    }
}
