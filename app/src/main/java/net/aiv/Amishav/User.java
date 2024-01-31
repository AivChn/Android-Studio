package net.aiv.Amishav;

public class User {

    private String name;
    private int score;

    public User(String username){
        this.name = username;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int toAdd){
        score += toAdd;
    }

}
