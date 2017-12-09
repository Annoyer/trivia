package kata.trivia.model;

import kata.trivia.websocket.WebSocketServer;

/**
 * Created by joy12 on 2017/12/3.
 */
public class User {
    private Integer id;
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
