package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.intercom.ListingClient;
import com.revature.models.Listing;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.util.MailService;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	ListingClient lc;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.getOne(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

	public void sendNotification(int userId, int listingId, int loggedInId) {
		MailService ms = new MailService();
		Listing list = null;
		List<Listing> lists = lc.getListingsByUserId(userId);
		System.out.println(lists);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
			if (lists.get(i).getId() == listingId) {
				System.out.println("yes");
				list = lists.get(i);
			}
		}
		if (list != null) {
			ms.sendEmail(userRepository.findOne(loggedInId), userRepository.findOne(userId), list);
		}
	}
}
