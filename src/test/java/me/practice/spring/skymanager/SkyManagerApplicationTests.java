package me.practice.spring.skymanager;

import me.practice.spring.skymanager.models.Flight;
import me.practice.spring.skymanager.models.FlightBaggage;
import me.practice.spring.skymanager.models.FlightCargo;
import me.practice.spring.skymanager.models.LoadIdentifier;
import me.practice.spring.skymanager.repositories.BaggageRepository;
import me.practice.spring.skymanager.repositories.CargoRepository;
import me.practice.spring.skymanager.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootTest
class SkyManagerApplicationTests {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private BaggageRepository baggageRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createFlight(){
		Flight flight = Flight.builder()
				.flightId(1L)
				.flightNumber(1232L)
				.arrivalIATACode("KRK")
				.departureIATACode("LND")
				.departureDate(new Date()).build();
		this.flightRepository.save(flight);
	}

	@Test
	void createCargoAndBaggage(){
		FlightBaggage baggage = FlightBaggage.builder()
				.id(new LoadIdentifier(1L, 1L))
				.pieces(5)
				.weightKg(323.132)
				.build();
		FlightCargo cargo = FlightCargo.builder()
				.id(new LoadIdentifier(1L, 1L))
				.pieces(10)
				.weightKg(132.3123)
				.build();
		this.baggageRepository.save(baggage);
		this.cargoRepository.save(cargo);
	}

	@Test
	@Transactional
	void showFlights(){
		System.out.println(this.flightRepository.findAll());
	}

}
