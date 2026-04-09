package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.ITravellerMgmtService;
import com.nt.vo.TravellerVo;

@RestController
@RequestMapping("/traveller-api")
public class TravellerOperationsRestController {
	
	@Autowired
    private ITravellerMgmtService travellerService;
	
	 @PostMapping("/save")
	    public ResponseEntity<String> registerTraveller(@RequestBody TravellerVo vo) {
	        try {
	            //use service
	            String msg = travellerService.registerTraveller(vo);
	            return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	        }
	        catch (Exception e) {
	            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 //==========================
	 //2nd end point for retrieving all records
	 @GetMapping("/findAll")
	 public ResponseEntity<?> displayAllTravellers(){
	     try {
	     //use service
	     List<TravellerVo> listVO=travellerService.showAllTravellers();
	     return new ResponseEntity<List<TravellerVo>>(listVO,HttpStatus.OK);
	     }
	     catch(Exception e) {
	     return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }
	


//==================================
	
@GetMapping("/find/{id}")
public ResponseEntity<Object> showTravellerById(@PathVariable Integer id) {
    try {
        //use service
        TravellerVo vo = travellerService.showTravellerById(id);
        return new ResponseEntity<Object>(vo, HttpStatus.OK);
    } //try
    catch(Exception e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//=======================================
@PatchMapping("/update/{currentLocation}/{headingTo}")
public ResponseEntity<String> updateHeadingToByCurentLocation(@PathVariable String currentLocation, 
                                                              @PathVariable String headingTo) {
    //use service
    String msg = travellerService.updateHeadingToByCurrentLocation(currentLocation, headingTo);
    return new ResponseEntity<String>(msg, HttpStatus.OK);
}
//===========================================================

@PutMapping("/fullupdate")
 public ResponseEntity<String> modifyTraveller(@RequestBody TravellerVo vo){
   //use Service
    String msg=travellerService.updateTraveller(vo);
     return new ResponseEntity<String>(msg, HttpStatus.OK);
 }
//==============================================
 @DeleteMapping("/remove/{id}")
 public ResponseEntity<String> removeTravellerById(@PathVariable int id){
     //use service
     String msg=travellerService.deleteTravellerById(id);
     System.out.println("TravellerOperationsRestController.removeTravellerById()"); // change
     return new ResponseEntity<String>(msg, HttpStatus.OK);
     
 }



}
