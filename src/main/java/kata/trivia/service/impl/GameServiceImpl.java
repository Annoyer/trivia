package kata.trivia.service.impl;

import kata.trivia.dao.QuestionDao;
import kata.trivia.dto.Game;
import kata.trivia.dto.Player;
import kata.trivia.model.User;
import kata.trivia.service.GameService;
import kata.trivia.util.GameUtil;
import kata.trivia.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by joy12 on 2017/12/9.
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    QuestionDao questionDao;

//    private Map<Integer,Game> tables = new HashMap<Integer, Game>();

    public List<Game> getAllTables() {
        List<Game> games = new ArrayList<Game>();
        Map<Integer,Game> tables = WebSocketServer.getTables();
        // 限制最多只有5桌
        for (int i=0; i<5; i++) {
            Game itable = tables.get(i);
            if (itable != null){
                games.add(itable);
            } else {
                games.add(new Game(i));
            }
        }
        return games;
    }

    public List<Player> getPlayersByTable(int tableId) {
        List<Player> playerList = new ArrayList<Player>();
        playerList.addAll(WebSocketServer.getTable(tableId).getPlayers());
        return playerList;
    }

    /**
     * 用户选桌
     * @param tableId
     * @param user
     * @return 是否加桌成功
     */
    public boolean userChooseTable(int tableId, User user, int initialPlace) {
        Game table = WebSocketServer.getTable(tableId);
        //如果是空桌，先把桌子加进map
        if (table == null){
            table = new Game(tableId);
            WebSocketServer.addTable(table);
        }

        //若游戏不在进行中，且未满员，加桌成功
        if (!table.isEnoughPlayer() && !table.isGameStart()){
            table.add(user.getUsername(),user,initialPlace);//table会生成player
            return true;
        }
        //游戏满员或正在进行，加桌失败
        return false;

    }

    /**
     * 玩家准备，同时检查，如果该桌所有人都ready且满员，则游戏开始
     *
     * ---- 这个方法还没写完，差注释掉的那部分（在游戏开始之前去数据库拿问题并装载）
     * @param tableId
     * @param userId
     */
    public void setPlayerReady(int tableId, int userId) {
        Game table = WebSocketServer.getTable(tableId);
        table.setReady(userId);
        if (table.isEnoughPlayer() && table.isAllPlayerReady()){
            table.prepareQuestions(questionDao.selectByDomain("pop"),
                    questionDao.selectByDomain("science"),
                    questionDao.selectByDomain("sports"),
                    questionDao.selectByDomain("rock"));
            table.startGame();
        }
    }

    public void stopDice(int tableId) {
        WebSocketServer.getTable(tableId).roll(GameUtil.runDice());
    }

    public void answerQuestion(int tableId, boolean isCorrect) {
        Game table = WebSocketServer.getTable(tableId);
        if (isCorrect){
            table.answeredCorrectly();
        } else {
            table.answeredWrong();
        }
    }



}
