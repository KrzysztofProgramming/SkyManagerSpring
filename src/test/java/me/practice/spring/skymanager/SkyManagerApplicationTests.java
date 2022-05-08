package me.practice.spring.skymanager;

import me.practice.spring.skymanager.models.Flight;
import me.practice.spring.skymanager.models.FlightBaggage;
import me.practice.spring.skymanager.models.FlightCargo;
import me.practice.spring.skymanager.models.LoadIdentifier;
import me.practice.spring.skymanager.repositories.BaggageRepository;
import me.practice.spring.skymanager.repositories.CargoRepository;
import me.practice.spring.skymanager.repositories.FlightRepository;
import me.practice.spring.skymanager.searchers.FlightSearcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.ZoneIdEditor;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@SpringBootTest
class SkyManagerApplicationTests {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private BaggageRepository baggageRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightSearcher flightSearcher;

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


	@Test
	void testSearch(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone(TimeZone.getTimeZone("America/Mexico_City"));
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println(this.flightSearcher.statsByDateAndCode(calendar.getTime(), new Date(), "KRK"));
		System.out.println(this.flightSearcher.statsByDateAndNumber(calendar.getTime(), new Date(), 1232L));
	}
}
