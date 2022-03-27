package board.service;

import board.dao.LoginDao;
import board.dao.LoginDaoImpl;
import board.dto.UserDto;

public class LoginServiceImpl implements LoginService{

	private static LoginServiceImpl instance = new LoginServiceImpl();
	
	private LoginServiceImpl() {};
	
	public static LoginServiceImpl getInstance() {
		return instance;
	}	
	
	LoginDao loginDao = LoginDaoImpl.getInstance();
	
	@Override
	public UserDto login(String userEmail, String userPassword) {
		UserDto userDto = loginDao.login(userEmail);
		
		if( userDto != null && userDto.getUserPassword().equals(userPassword)) {
			System.out.println("Login Success!!");
			return userDto;
		}else {
			System.out.println("Login Fail!!");
			return null;
		}
	}

}
