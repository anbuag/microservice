package com.spring.california.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.california.dto.TourDto;
import com.spring.california.model.Tour;
import com.spring.california.service.TourService;
@Controller
public class TourController{
	private TourService tourService;

	@Autowired 
	public TourController(TourService tourService) {
		this.tourService = tourService;
	}
	
	@GetMapping("/price")
	public String price() {
		return "price";
	}
	
	@GetMapping("/tours")
	public String listTours(Model model) {
		List<TourDto> tours=tourService.findAllTours();
		model.addAttribute("tours", tours);
		return "tours-list";
	}
	@GetMapping("/tours/new")
	public String createClubForm(Model model) {
		Tour tour=new Tour();
		model.addAttribute("tour",tour);
		return "tours-create";
	}
	@PostMapping("/tours/new")
	public String saveTour(@Valid @ModelAttribute("tour")TourDto tourDto,BindingResult result, Model model) {
//		if(result.hasErrors()) {
//			model.addAttribute("tour", tourDto);
//			return "tours-create";
//		}
		tourService.saveTour(tourDto);
		return "redirect:/tours";
	}
	
	@GetMapping("/tours/{tourId}/edit")
	public String editTourForm(@PathVariable("tourId")Long tourId,Model model) {
		TourDto tour=tourService.findTourById(tourId);
		model.addAttribute("tour", tour);
		return "tours-edit";
	}
	@PostMapping("/tours/{tourId}/edit")
	public String updateTour(@PathVariable("tourId") Long tourId,
							@Valid @ModelAttribute("tour")TourDto tour,
							BindingResult result) {
		if(result.hasErrors()) {
			return "tours-edit";
		}
		tour.setId(tourId);
		tourService.updateTour(tour);
		return "redirect:/tours";
	}
	
	@GetMapping("/tours/{tourId}")
	public String tourDetail(@PathVariable("tourId")long tourId, Model model) {
		TourDto tourDto=tourService.findTourById(tourId);
		model.addAttribute("tour", tourDto);
		return "tours-detail";
	}
	
	@GetMapping("/tours/search")
	public String searchTour(@RequestParam( value = "query")String query,Model model) {
		List<TourDto> tours=tourService.searchTours(query);
		model.addAttribute("tours", tours);
		return "tours-list";
	}
	
	@GetMapping("/tours/{tourId}/delete")
	public String deleteTour(@PathVariable("tourId")Long tourId) {
		tourService.delete(tourId);
		return "redirect:/tours";
	}
	
//	 @GetMapping("/register")
//	    public String getRegisterForm(Model model) {
//	        RegistrationDto user = new RegistrationDto();
//	        model.addAttribute("user", user);
//	        return "register";
//	    }
//
//	    @PostMapping("/register/save")
//	    public String register(@Valid @ModelAttribute("user")RegistrationDto user,
//	                           BindingResult result, Model model) {
//	        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
//	        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
//	            return "redirect:/register?fail";
//	        }
//	        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
//	        if(existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
//	            return "redirect:/register?fail";
//	        }
//	        if(result.hasErrors()) {
//	            model.addAttribute("user", user);
//	            return "register";
//	        }
//	        userService.saveUser(user);
//	        return "redirect:/clubs?success";
//	    }
	
}












