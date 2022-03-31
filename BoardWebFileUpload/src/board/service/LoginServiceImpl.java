package board.service;

import board.dao.LoginDao;
import board.dao.LoginDaoImpl;
import board.dto.UserDto;

public class LoginServiceImpl implements LoginService{
	
	private static LoginServiceImpl instance = new LoginServiceImpl();
	
	private LoginServiceImpl() {}
	
	
	public static LoginServiceImpl getInstance() {
		return instance;
	}
	
	LoginDao loginDao = LoginDaoImpl.getInstance();
	
	// session 에 사용자 정보를 저장하기 위해 UserDto 를 리턴
	@Override
	public UserDto login(String userEmail, String userPassword) {
		
		UserDto userDto = loginDao.login(userEmail);
		
		if( userDto != null && userDto.getUserPassword().equals(userPassword)) {
			return userDto;
		}else {
			return null;
		}
	}
}

