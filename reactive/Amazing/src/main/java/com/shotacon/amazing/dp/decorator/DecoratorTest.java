package com.shotacon.amazing.dp.decorator;

public class DecoratorTest {

	public static void main(String[] args) {

		BaseHuman joe = new Witch(new HeroModel("joe"));
		joe.show();

		Bitch lucy = new Bitch(new HeroModel("lucy"));
		lucy.show();
		
	}
}
