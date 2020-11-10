package com.freeinfo.mediaw.mediaworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeinfo.mediaw.mediaworld.connector.MediaWorldFeignClient;
import com.freeinfo.mediaw.mediaworld.model.MediaAvabilityDTO;

@Service
public class MediaworldService {

	@Autowired
	private MediaWorldFeignClient mediaWorldFeignClient;
	
	public MediaAvabilityDTO mediaWorldAvability(String cordinate, String itemCode) {
		
		return mediaWorldFeignClient.searchOnLocation(itemCode, cordinate);
		
	}
	
}
