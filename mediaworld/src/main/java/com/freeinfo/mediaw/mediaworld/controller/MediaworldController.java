package com.freeinfo.mediaw.mediaworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeinfo.mediaw.mediaworld.exception.InvalidCodeException;
import com.freeinfo.mediaw.mediaworld.exception.MediaworldException;
import com.freeinfo.mediaw.mediaworld.model.MediaAvabilityDTO;
import com.freeinfo.mediaw.mediaworld.service.MediaworldService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/mediaworld")
@Slf4j
public class MediaworldController {

	@Autowired
	MediaworldService mediaworldService;

	@GetMapping(value = "/avability")
	public ResponseEntity<MediaAvabilityDTO> getAvability(@RequestParam(value = "itemCode") String itemCode,
			@RequestParam(value = "cordinate") String cordinate) throws MediaworldException, InvalidCodeException {

		MediaAvabilityDTO response = mediaworldService.mediaWorldAvability(cordinate, itemCode);
		log.debug("Ritiro dei dati per le cordinate: "+ cordinate + " con itemCode: " + itemCode);
		
		return new ResponseEntity<MediaAvabilityDTO>(response,HttpStatus.OK);

	}

}
