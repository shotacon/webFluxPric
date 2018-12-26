package com.shotacon.amazing.dp.decorator;

public class Bitch extends RoleDecorator {

	public Bitch(HeroModel heroModel) {
		super();
		this.name = heroModel.name;
		this.abilities = "Bitchy";
	}

	@Override
	public void show() {
		super.show();
		System.out.println("你的角色转职为碧池, 获得能力: " + abilities);
	}

}
