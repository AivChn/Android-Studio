package net.aiv.Amishav;

import java.util.HashMap;
import java.util.Random;

public class Exercise {

    private Random ran;
    private int firstNum;
    private int secondNum;

    private HashMap<String, User> userHash;
    private User currentUser;
    private int latestExercise;

    public Exercise(){
        ran = new Random();
        userHash = new HashMap<>();
        latestExercise = 0;
    }

    private void updateFirstNum() {
        firstNum = ran.nextInt(10);
    }

    public void addUser(String username){

        if (userHash.containsKey(username)){
            currentUser = userHash.get(username);
        } else {
            User newUser = new User(username);
            userHash.put(username, newUser);
            currentUser = newUser;
        }

    }

    public int[] multiBoard() {

        latestExercise = 1;

        updateFirstNum();
        secondNum = ran.nextInt(10);

        return new int[] {firstNum, secondNum};

    }

    public int[] multiTo20() {

        latestExercise = 2;

        updateFirstNum();
        secondNum = ran.nextInt(11) + 10;

        return new int[] {firstNum, secondNum};

    }

    public int[] challenge() {

        latestExercise = 3;

        updateFirstNum();
        secondNum = ran.nextInt(90) + 10;

        return new int[] {firstNum, secondNum};

    }

    public boolean checkAnswer(int answer) {

        switch (latestExercise){
            case 1:
                currentUser.addScore(5);
            case 2:
                currentUser.addScore(10);
            case 3:
                currentUser.addScore(20);
        }

        return firstNum * secondNum == answer;
    }

}
