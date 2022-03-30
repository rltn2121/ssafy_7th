package com.ssafy.dto;

public class NoteBook {
	private String noteCode;
	private String model;
	private int price;
	private String company;
	public NoteBook(String noteCode, String model, int price, String company) {
		super();
		this.noteCode = noteCode;
		this.model = model;
		this.price = price;
		this.company = company;
	}
	public NoteBook() {
		super();
	}
	public String getNoteCode() {
		return noteCode;
	}
	public void setNoteCode(String noteCode) {
		this.noteCode = noteCode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "NoteBook [noteCode=" + noteCode + ", model=" + model + ", price=" + price + ", company=" + company
				+ "]";
	}
	
	
}
