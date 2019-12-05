package com.revature.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Listing;

@Service
public class CachingService {
	
	private HashMap<Integer, List<Listing>> listingCache = new HashMap<>();
	
	public void cacheListing(List<Listing> listings) {
		if(listings!=null && listings.size()>0) {
			listingCache.putIfAbsent(listings.get(0).getId(), listings);
		}
	}
	
	public List<Listing> returnCachedListings(int id){
		return listingCache.get(id);
	}

}
