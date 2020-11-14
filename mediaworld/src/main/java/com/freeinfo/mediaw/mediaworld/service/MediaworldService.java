package com.freeinfo.mediaw.mediaworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeinfo.mediaw.mediaworld.connector.MediaWorldFeignClient;
import com.freeinfo.mediaw.mediaworld.exception.ExceptionHandeler;
import com.freeinfo.mediaw.mediaworld.exception.InvalidCodeException;
import com.freeinfo.mediaw.mediaworld.exception.MediaworldException;
import com.freeinfo.mediaw.mediaworld.model.MediaAvabilityDTO;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MediaworldService {

	@Autowired
	private MediaWorldFeignClient mediaWorldFeignClient;

	public MediaAvabilityDTO mediaWorldAvability(String cordinate, String itemCode)
			throws MediaworldException, InvalidCodeException {

		MediaAvabilityDTO response = new MediaAvabilityDTO();
		try {

			response = mediaWorldFeignClient.searchOnLocation(itemCode, cordinate);

			if (null == response) {

				log.error("Errore: InvalidCodeException nella gestione dell'itemCode: " + itemCode + " con coordinate: "
						+ cordinate);
				throw new InvalidCodeException();

			}

			if (("Terni").equals(response.getStoresList().getStores().get(0).getName())
					&& ("Perugia").equals(response.getStoresList().getStores().get(1).getName())) {

				log.error("Errore: MediaworldException nella gestione dell'itemCode: " + itemCode + " con coordinate: "
						+ cordinate);
				throw new MediaworldException();

			}

		} catch (FeignException ex) {
			log.error("Errore: MediaworldException nella gestione dell'itemCode: " + itemCode + " con coordinate: "
					+ cordinate);
			throw new MediaworldException(ex.getMessage());
		}

		return response;
	}

}
