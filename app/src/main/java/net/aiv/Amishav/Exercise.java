package net.aiv.Amishav;

import java.util.Random;

public class Exercise {

    private Random ran;
    private int firstNum;
    private int secondNum;

    public Exercise(){
        ran = new Random();
    }

    private void updateFirstNum() {
        firstNum = ran.nextInt(10);
    }

    public int[] multiBoard() {

        updateFirstNum();
        secondNum = ran.nextInt(10);

        return new int[] {firstNum, secondNum};

    }

    public int[] multiTo20() {

        updateFirstNum();
        secondNum = ran.nextInt(11) + 10;

        return new int[] {firstNum, secondNum};

    }

    public int[] challenge() {

        updateFirstNum();
        secondNum = ran.nextInt(90) + 10;

        return new int[] {firstNum, secondNum};

    }

    public boolean checkAnswer(int answer) {
        return firstNum * secondNum == answer;
    }

}
