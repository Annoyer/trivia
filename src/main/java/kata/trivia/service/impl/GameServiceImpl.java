package kata.trivia.service.impl;

import kata.trivia.dto.Game;
import kata.trivia.dto.Player;
import kata.trivia.model.User;
import kata.trivia.service.GameService;
import kata.trivia.util.GameUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by joy12 on 2017/12/9.
 */@Service
public class GameServiceImpl implements GameService {

    private Map<Integer,Game> tables = new HashMap<Integer, Game>();

    public List<Game> getAllTables() {
        List<Game> games = new ArrayList<Game>();
        games.addAll(tables.values());
        return games;
    }

    public List<Player> getPlayersByTable(int tableId) {
        List<Player> playerList = new ArrayList<Player>();
        playerList.addAll(tables.get(tableId).getPlayers());
        return playerList;
    }

    /**
     * 用户选桌
     * @param tableId
     * @param user
     * @return 是否加桌成功
     */
    public boolean userChooseTable(int tableId, User user) {
        Game table = tables.get(tableId);
        //如果是空桌，先把桌子加进map
        if (table == null){
            table = new Game(tableId);
            tables.put(tableId,table);
        }

        //若游戏不在进行中，且未满员，加桌成功
        if (!table.isEnoughPlayer() && !table.isGameStart()){
            table.add(user.getUsername(),user);//table会生成player
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
        Game table = tables.get(tableId);
        table.setReady(userId);
        if (table.isEnoughPlayer() && table.isAllPlayerReady()){
//            questionDao.getQuestions……
//            table.prepareQuestions(?,?,?,?);
            table.startGame();
        }
    }

    public void stopDice(int tableId) {
        tables.get(tableId).roll(GameUtil.runDice());
    }

    public void answerQuestion(int tableId, boolean isCorrect) {
        Game table = tables.get(tableId);
        if (isCorrect){
            table.answeredCorrectly();
        } else {
            table.answeredWrong();
        }
    }



}
