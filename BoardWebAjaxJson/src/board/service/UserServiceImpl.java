package board.service;

import board.dao.UserDao;
import board.dao.UserDaoImpl;
import board.dto.UserDto;

public class UserServiceImpl implements UserService{
	UserDao userDao = UserDaoImpl.getInstance();

	private UserServiceImpl() {};
	private static UserServiceImpl instance = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		return instance;
	}
	
	
	@Override
	public UserDto register(String userName, String userEmail, String userPassword) {
		UserDto userDto = new UserDto();
		userDto.setUserName(userName);
		userDto.setUserEmail(userEmail);
		userDto.setUserPassword(userPassword);
		
		int result = userDao.register(userDto);
		
		if(result != 0) {
			System.out.println("Register Success!!");
			return userDto;
		}
		else {
			System.out.println("Register Fail!!");
			return null;
		}
	}

}
