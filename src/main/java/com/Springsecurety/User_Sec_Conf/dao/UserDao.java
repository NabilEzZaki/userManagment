package com.Springsecurety.User_Sec_Conf.dao;

import com.Springsecurety.User_Sec_Conf.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
