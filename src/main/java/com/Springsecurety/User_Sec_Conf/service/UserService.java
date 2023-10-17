package com.Springsecurety.User_Sec_Conf.service;

import com.Springsecurety.User_Sec_Conf.dao.UserDao;
import com.Springsecurety.User_Sec_Conf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserDao userDao;
    @Autowired
    public UserService(@Qualifier("UserDao") UserDao userDao) {
        this.userDao = userDao;
    }
    public Optional<User> getById(int id){
        return userDao.findById(id);
    }
    public Iterable<User> getAll(){
        return userDao.findAll();
    }

    public String addUser(User user){
        User result = userDao.save(user);
        if(result!=null){
            return "Utente salvato correttamente";
        }
        return "Errore nel salvataggio";
    }

    public  String updateUser(int id, User user){
        user.setId(id);
        User result= userDao.save(user);
        if (result != null){
            return "Utente aggiornato corretamente";
        }else{
            return "Errore nell'aggiornamento dell'utente";
        }
    }

    public String deleteUser(int id){
        Optional<User> userToDelete = userDao.findById(id);
        if(userToDelete.isEmpty()){
            return "user non trovato";
        }else {
            userDao.delete(userToDelete.get());
            return "Utente eliminato correttamente";
        }
    }

}
