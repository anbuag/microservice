package com.spring.california.dto;



import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TourDto {

	private long id;
	@NotEmpty(message = "Tour name should not be empty")
	private String name;
	@NotEmpty(message = "PhotoUr should not be empty")
	private String photoUrl;
	@NotEmpty(message = "Content should not be empty")
	private String content;
	

}
