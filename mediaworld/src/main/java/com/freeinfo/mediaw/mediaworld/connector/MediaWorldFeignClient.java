package com.freeinfo.mediaw.mediaworld.connector;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.freeinfo.mediaw.mediaworld.model.MediaAvabilityDTO;

@FeignClient(name="FeignMW", url = "${client.mediaworld.base_url}")
public interface MediaWorldFeignClient {

    @GetMapping("{itemCode}/{cordinate}")
    MediaAvabilityDTO searchOnLocation(
            @PathVariable("itemCode") String itemCode,
            @PathVariable("cordinate") String cordinate
    );
}
