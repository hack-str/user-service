package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Listing;

@FeignClient(name="listing-service",fallback=ListingClientFallback.class)
public interface ListingClient {
	
	@GetMapping("/listings/user/{userId}")
	public List<Listing> getListingsByUserId(@PathVariable("userId")int id);

}
