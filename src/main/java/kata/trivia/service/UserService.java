package kata.trivia.service;


import kata.trivia.dto.Result;
import kata.trivia.model.User;

/**
 * Created by joy12 on 2017/12/3.
 */
public interface UserService {
    User signup(User user);
    User login(User user);
    boolean countWinLose(User user, boolean isWinner);
}
