package com.freeinfo.mediaw.mediaworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeinfo.mediaw.mediaworld.model.MediaAvabilityDTO;
import com.freeinfo.mediaw.mediaworld.service.MediaworldService;

@RestController
@RequestMapping(value = "/mediaworld")
public class MediaworldController {

	@Autowired
	MediaworldService mediaworldService;

	@GetMapping(value = "/avability")
	public ResponseEntity<MediaAvabilityDTO> getAvability(@RequestParam(value = "itemCode") String itemCode,
			@RequestParam(value = "cordinate") String cordinate) {

		return new ResponseEntity<MediaAvabilityDTO>(mediaworldService.mediaWorldAvability(cordinate, itemCode),
				HttpStatus.OK);

	}

}
