package com.spring.california.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.california.model.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {
	Optional<Tour> findByname(String Url);

	@Query("SELECT t from Tour t WHERE t.name LIKE CONCAT('%', :query,'%')")
	List<Tour> searchTours(String query);

	
}
