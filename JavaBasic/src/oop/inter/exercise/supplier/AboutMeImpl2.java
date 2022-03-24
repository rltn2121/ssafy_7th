package oop.inter.exercise.supplier;

import oop.inter.exercise.common.AboutMe;

public class AboutMeImpl2 implements AboutMe{

	@Override
	public String yourName() {
		return "박기수";
	}

	@Override
	public String yourFavoriteCompany() {
		return "Naver";
	}

	@Override
	public String supportMessageToAll() {
		// TODO Auto-generated method stub
		return "영차영차";
	}

}
