package ru.shonin.spring.stockRobot;

public interface Robot{
    void act();
    String getName();
    void setShare(Share share);
}

class RobotImpl implements Robot {
    Share sh;
    Action action;
    String shareName;

    public RobotImpl(String s, Action action) {
        this.shareName = s;
        sh = new Share(8,s);
        sh.robots.add(this);
        this.action = action;
    }


    @Override
    public void act() {
        action.act(sh);
    }
}
