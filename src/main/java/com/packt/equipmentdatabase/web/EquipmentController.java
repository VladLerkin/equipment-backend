package com.packt.equipmentdatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.equipmentdatabase.domain.Equipment;
import com.packt.equipmentdatabase.domain.EquipmentRepository;

@RestController
public class EquipmentController {
	@Autowired
	private EquipmentRepository repository;

	@RequestMapping("/equipments")
	public Iterable<Equipment> getEquipments() {
		return repository.findAll();
	}
}
