package net.aiv.Amishav;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private Exercise exercise;
    private MutableLiveData<Integer> firstNum;
    private MutableLiveData<Integer> secondNum;

    public MainViewModel() {

        exercise = new Exercise();
        firstNum = new MutableLiveData<>();
        secondNum = new MutableLiveData<>();

    }

    public void exerciseChallenge() {
        int[] nums = exercise.challenge();
        firstNum.setValue(nums[0]);
        secondNum.setValue(nums[1]);
    }

    public void exerciseMultiTo20() {
        int[] nums = exercise.multiTo20();
        firstNum.setValue(nums[0]);
        secondNum.setValue(nums[1]);
    }

    public void exerciseMultiBoard() {
        int[] nums = exercise.multiBoard();
        firstNum.setValue(nums[0]);
        secondNum.setValue(nums[1]);
    }

    public boolean checkAnswer(int answer) {
        return exercise.checkAnswer(answer);
    }

    public MutableLiveData<Integer> getFirstNum() {
        return firstNum;
    }

    public MutableLiveData<Integer> getSecondNum() {
        return secondNum;
    }
}
