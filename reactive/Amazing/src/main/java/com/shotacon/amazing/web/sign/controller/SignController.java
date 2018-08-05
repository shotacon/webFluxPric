package com.shotacon.amazing.web.sign.controller;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.shotacon.amazing.utils.SignatureUtil;

import reactor.core.publisher.Mono;

@Controller
public class SignController {

	private static final Logger logger = LoggerFactory.getLogger(SignController.class);

	@GetMapping("/checkSignature")
	public Mono<String> checkSignature(ServerRequest request) throws NoSuchAlgorithmException {
		String signature = request.pathVariable("signature");
		String timestamp = request.pathVariable("timestamp");
		String nonce = request.pathVariable("nonce");
		String echostr = request.pathVariable("echostr");
		logger.debug("CheckSignature with {},{},{}", signature, timestamp, nonce);

		if (SignatureUtil.signature(timestamp, nonce, signature)) {
			return Mono.just(echostr);
		}
		return Mono.just("Check Signature Failed");
	}
}
