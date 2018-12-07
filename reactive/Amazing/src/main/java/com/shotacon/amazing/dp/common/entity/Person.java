package com.shotacon.amazing.dp.common.entity;

import com.shotacon.amazing.dp.common.interfaces.Human;

import lombok.Data;

@Data
public class Person implements Human {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public void walk() {
		System.out.println(this.name + " walk like a person");
	}

	public void talk() {
		System.out.println(this.name + " talk like a bitch");
	}

	public void littleTalk() {
		System.out.println(this.name + " talk so bitchy");
	}

}
