package com.shotacon.flux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shotacon.flux.entity.User;
import com.shotacon.flux.respository.UserRespository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRespository userRespository;

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public Flux<User> handleFindAllUser() {
		return Flux.create(response -> {
			userRespository.findAllUser().forEach(user -> {
				response.next(user);
			});
//			try {
				response.complete();
//			} catch (InterruptedException e) {
//				log.error("", e);
//			}
		});
	}
}
