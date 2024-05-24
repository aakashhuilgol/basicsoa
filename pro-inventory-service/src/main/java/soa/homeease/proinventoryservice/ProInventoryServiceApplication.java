package soa.homeease.proinventoryservice;

import soa.homeease.proinventoryservice.invent.Inventory;
import soa.homeease.proinventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ProInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProInventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setName("Anakin");
			inventory1.setAvailable(Boolean.TRUE);

			Inventory inventory2 = new Inventory();
			inventory2.setName("Pin");
			inventory2.setAvailable(Boolean.FALSE);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}
}
