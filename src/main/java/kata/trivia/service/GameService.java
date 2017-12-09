package kata.trivia.service;

import kata.trivia.dto.Game;
import kata.trivia.dto.Player;
import kata.trivia.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by joy12 on 2017/12/9.
 */
public interface GameService {

    List<Game> getAllTables();

    List<Player> getPlayersByTable(int tableId);

    boolean userChooseTable(int tableId, User user);

    void setPlayerReady(int tableId, int playerId);

    void stopDice(int tableId);

    void answerQuestion(int tableId, boolean isCorrect);

}
