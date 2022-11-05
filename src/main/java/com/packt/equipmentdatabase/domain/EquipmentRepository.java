package com.packt.equipmentdatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
	// Fetch cars by brand
	List<Equipment> findByBrand(@Param("brand") String brand);

	// Fetch cars by color
	List<Equipment> findByModel(@Param("model") String model);
}
