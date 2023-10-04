package com.spring.california.service;
import java.util.List;

import com.spring.california.dto.TourDto;
import com.spring.california.model.Tour;


public interface TourService {
	List<TourDto> findAllTours();

	TourDto findTourById(long tourId);

	Tour saveTour(TourDto tourDto);

	void updateTour(TourDto tour);

	List<TourDto> searchTours(String query);

	void delete(Long tourId);
	


}
