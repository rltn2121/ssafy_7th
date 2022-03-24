package board.service;

import board.dao.LoginDao;
import board.dao.LoginDaoImpl;
import board.dto.UserDto;

public class LoginServiceImpl implements LoginService{
	LoginDao loginDao = LoginDaoImpl.getInstance();

	private LoginServiceImpl() {};
	private static LoginServiceImpl instance = new LoginServiceImpl();
	public static LoginServiceImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public UserDto login(String userEmail, String userPassword) {
		UserDto userDto = loginDao.login(userEmail);
		
		if(userDto != null && userDto.getUserPassword().equals(userPassword))
			System.out.println("Login Success!!");
		else
			System.out.println("Login Fail!!");
		
		return userDto;
	}

}
