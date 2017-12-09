package kata.trivia.dto;

import kata.trivia.model.Question;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by benwu on 14-5-28.
 * 负责分配问题
 */
public class QuestionMaker {
    public static final int MAX_NUMBER_OF_QUESTIONS = 50; //最大问题数，可更改
    // by j: 分类问题列表，游戏初始化时从数据库取出; 问题类从Question修改为数据库对应模型Question类
    //ps：Question应该有Check方法
    private LinkedList<Question> popQuestions = new LinkedList<Question>();
    private LinkedList<Question> scienceQuestions = new LinkedList<Question>();
    private LinkedList<Question> sportsQuestions = new LinkedList<Question>();
    private LinkedList<Question> rockQuestions = new LinkedList<Question>();

    private String errorMsg;// by j：错误信息

    public void addPopQuestionList(List<Question> popQuestion) {
        popQuestions.addAll(popQuestion);
    }

    public void addScienceQuestionList(List<Question> scienceQuestion) {
        scienceQuestions.addAll(scienceQuestion);
    }

    public void addSportsQuestionList(List<Question> sportsQuestion) {
        sportsQuestions.addAll(sportsQuestion);
    }

    public void addRockQuestionList(List<Question> rockQuestion) {
        rockQuestions.addAll(rockQuestion);
    }

    public void addPopQuestion(Question popQuestion) {
        popQuestions.add(popQuestion);
    }

    public void addScienceQuestion(Question scienceQuestion) {
        scienceQuestions.add(scienceQuestion);
    }

    public void addSportsQuestion(Question sportsQuestion) {
        sportsQuestions.add(sportsQuestion);
    }

    public void addRockQuestion(Question rockQuestion) {
        rockQuestions.add(rockQuestion);
    }

    /**
     * 分配问题的方式从拿出队列的第一个问题并将其删去，改成随机访问队列中的任意一个问题
     * 并做好判空
     */
    public Question distributePopQuestion() {
        if (popQuestions==null || popQuestions.size()==0){
            errorMsg = "哦！我没有这类型的问题！";
            return new Question(errorMsg);
        }
        return popQuestions.get(randomNum(popQuestions.size()));
    }

    public Question distributeScienceQuestion() {
        if (scienceQuestions==null || scienceQuestions.size()==0){
            errorMsg = "哦！我没有这类型的问题！";
            return new Question(errorMsg);
        }
        return scienceQuestions.get(randomNum(scienceQuestions.size()));
    }

    public Question distributeSportsQuestion() {
        if (sportsQuestions==null || sportsQuestions.size()==0){
            errorMsg = "哦！我没有这类型的问题！";
            return new Question(errorMsg);
        }
        return sportsQuestions.get(randomNum(sportsQuestions.size()));
    }

    public Question distributeRockQuestion() {
        if (rockQuestions==null || rockQuestions.size()==0){
            errorMsg = "哦！我没有这类型的问题！";
            return new Question(errorMsg);
        }
        return rockQuestions.get(randomNum(rockQuestions.size()));
    }

    private int randomNum(int len){
        Random random = new Random();
        return random.nextInt(len);
    }


}
