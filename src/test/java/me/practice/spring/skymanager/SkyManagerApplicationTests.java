package me.practice.spring.skymanager;

import me.practice.spring.skymanager.models.FlightCargo;
import me.practice.spring.skymanager.repositories.BaggageRepository;
import me.practice.spring.skymanager.repositories.CargoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SkyManagerApplicationTests {

	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private BaggageRepository baggageRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void saveExampleSpell(){
		cargoRepository.save(new FlightCargo(19L, 323.22, 123));
	}

	@Test
	void readeCargo(){

	}

}
