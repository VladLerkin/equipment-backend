package com.packt.equipmentdatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.equipmentdatabase.domain.Equipment;
import com.packt.equipmentdatabase.domain.EquipmentRepository;
import com.packt.equipmentdatabase.domain.Owner;
import com.packt.equipmentdatabase.domain.OwnerRepository;
import com.packt.equipmentdatabase.domain.User;
import com.packt.equipmentdatabase.domain.UserRepository;

@SpringBootApplication
public class EquipmentdatabaseApplication implements CommandLineRunner {	
	private static final Logger logger = 
			LoggerFactory.getLogger(EquipmentdatabaseApplication.class);

	@Autowired
	private EquipmentRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(EquipmentdatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db 
		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new  Owner("Mary" , "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		// Add car object and link to owners and save these to db
		Equipment equipmen1 = new Equipment("LOREN COOK", "202 CPS-A",
				"ADF-7011202", 2021, 59000, owner1);
		Equipment equipmen2 = new Equipment("LOREN COOK", "203 CPS-A",
				"SSJ-7011203", 2019, 29000, owner2);
		Equipment equipmen3 = new Equipment("LOREN COOK", "204 CPS-A",
				"KKO-7011204", 2020, 39000, owner2);
		repository.saveAll(Arrays.asList(equipmen1, equipmen2, equipmen3));

		for (Equipment equipment : repository.findAll()) {
			logger.info(equipment.getBrand() + " " + equipment.getModel());
		}

		urepository.save(new User("user1", 
				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		urepository.save(new User("admin1", 
				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}
}
