package kata.trivia.service.impl;

import kata.trivia.dao.UserDao;
import kata.trivia.dto.Result;
import kata.trivia.model.User;
import kata.trivia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joy12 on 2017/12/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User signup(User user){
        if(userDao.getUserByNickName(user.getUsername())!=null){
            return null;
        }
        else{
        Integer id=userDao.addUser(user);
        return userDao.getUserById(id);
        }
    }
    @Override
    public User login(User user){
        return userDao.getUser(user.getUsername(),user.getPassword());
    }
}
