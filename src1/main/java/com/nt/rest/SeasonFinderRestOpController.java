package com.nt.rest;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderRestOpController {
	
	//endpoint 1
	@GetMapping("/display")
	public ResponseEntity<String> showSeasonName()
	{
		System.out.println("SeasonFinderRestOpController.showSeasonName()");
		//find season
		String season=null;
		LocalDate ld=LocalDate.now();
		int month=ld.getMonthValue();
		if(month>=7 && month<=10)
		season="rainy season";
		else if(month>=3 && month<=6)
			season="summer season";
		else
		season="winter season";
		
		//write output to consumer app;
		return new ResponseEntity<String>(season,HttpStatus.OK);
		
	}

}





