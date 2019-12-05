package com.revature.intercom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Listing;
import com.revature.services.CachingService;

@Component
public class ListingClientFallback implements ListingClient {

	@Autowired
	private CachingService cachingService;
	
	public List<Listing> getListingsByUserId(@PathVariable("userId")int id){
		return cachingService.returnCachedListings(id);
	}
	
}
