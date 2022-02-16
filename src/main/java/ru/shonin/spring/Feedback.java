package ru.shonin.spring;

public class Feedback {
    private String text;
    private int estimation;

    public Feedback(String text, int estimation) {
        this.text = text;
        this.estimation = estimation;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "text='" + text + '\'' +
                ", estimation=" + estimation +
                '}';
    }

    public String getText() {
        return text;
    }

    public int getEstimation() {
        return estimation;
    }
}
