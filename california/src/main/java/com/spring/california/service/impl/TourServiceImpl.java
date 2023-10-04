package com.spring.california.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.california.dto.TourDto;
import com.spring.california.model.Tour;
import com.spring.california.repository.TourRepository;
import com.spring.california.service.TourService;

@Service
public class TourServiceImpl implements TourService{

	private TourRepository tourRepository;
	
	@Autowired
	public TourServiceImpl(TourRepository tourRepository) {
		this.tourRepository = tourRepository;
	}


	@Override
	public List<TourDto> findAllTours() {
		List<Tour> tours= tourRepository.findAll();
		return tours.stream().map((tour)-> mapToTourDto(tour)).collect(Collectors.toList());
	}
	
	private TourDto mapToTourDto(Tour tour) {
		TourDto tourDto=TourDto.builder()
				.id(tour.getId())
				.name(tour.getName())
				.content(tour.getContent())
				.photoUrl(tour.getPhotoUrl())
				.build();
		return tourDto;
		
	}


	@Override
	public TourDto findTourById(long tourId) {
		Tour tour=tourRepository.findById(tourId).get();
		return mapToTourDto(tour);
	}


	@Override
	public Tour saveTour(TourDto tourDto) {
		Tour tour=mapToTour(tourDto);
		return tourRepository.save(tour);
	}


	@Override
	public void updateTour(TourDto tourDto) {
		Tour tour=mapToTour(tourDto);
		tourRepository.save(tour);
	}


	private Tour mapToTour(TourDto tour) {
		Tour tourDto=Tour.builder()
				.id(tour.getId())
				.name(tour.getName())
				.photoUrl(tour.getPhotoUrl())
				.content(tour.getContent())
				.build();
		return tourDto;
	}


	@Override
	public List<TourDto> searchTours(String query) {
		List<Tour> tours=tourRepository.searchTours(query);
		return tours.stream().map(tour ->mapToTourDto(tour)).collect(Collectors.toList());
	}


	@Override
	public void delete(Long tourId) {
		tourRepository.deleteById(tourId);
		
	}
}

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.spring.california.model.Tour;
//import com.spring.california.repository.TourRepository;

//@Service
//public class TourServiceImpl {
//    private final TourRepository tourRepository;
//
//    @Autowired
//    public TourService(TourRepository tourRepository) {
//        this.tourRepository = tourRepository;
//    }
//
//    public List<Tour> getAllTours() {
//        return tourRepository.findAll();
//    }
//
//    public Tour getTourById(Long id) {
//        return tourRepository.findById(id)
//            .orElseThrow(() -> new TourNotFoundException(id));
//    }
//
//    public Tour createTour(Tour tour) {
//        return tourRepository.save(tour);
//    }
//
//    public void deleteTour(Long id) {
//        if (!tourRepository.existsById(id)) {
//            throw new TourNotFoundException(id);
//        }
//        tourRepository.deleteById(id);
//    }
//}
