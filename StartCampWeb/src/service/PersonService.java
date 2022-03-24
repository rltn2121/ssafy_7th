package service;

import dao.PersonDao;
import dto.PersonDto;

public class PersonService {
	public PersonDto getPerson(int personId) {
		PersonDao dao = new PersonDao();
		PersonDto dto = dao.getPerson(personId);
		return dto;
	}
}
