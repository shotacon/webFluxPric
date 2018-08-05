package com.shotacon.amazing.utils;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

import com.shotacon.amazing.config.WechatConstant;

public class SignatureUtil {

	public static boolean signature(String timestamp, String nonce, String signature) throws NoSuchAlgorithmException {
		String[] arr = new String[] { WechatConstant.token, timestamp, nonce };
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for (String str : arr) {
			sb.append(str);
		}
		String sha1Hex = DigestUtils.sha1Hex(sb.toString()).toUpperCase();
		return sha1Hex.equals(signature.toUpperCase()) ? true : false;
	}
}
