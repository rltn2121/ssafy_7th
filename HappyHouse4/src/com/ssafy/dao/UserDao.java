package com.ssafy.dao;

import com.ssafy.dto.UserDto;

public interface UserDao {
   public int register(UserDto userDto);
   public UserDto login(String Member_id);
   public int remove(String Member_id);
   public UserDto view(String Member_id);
   public int edit(String Member_id, String pwd, String name, String address, String tell);
}