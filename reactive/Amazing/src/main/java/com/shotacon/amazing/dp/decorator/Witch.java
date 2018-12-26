package com.shotacon.amazing.dp.decorator;

public class Witch extends RoleDecorator {

	public Witch(HeroModel heroModel) {
		super();
		this.name = heroModel.name;
		this.abilities = "控火";
	}

	@Override
	public void show() {
		super.show();
		System.out.println("你的角色转职为女巫, 获得能力: " + abilities);
	}

}
