package ru.shonin.spring.stockRobot;

public interface Action {
    public void act(Share sh);
}
class SberRobot implements Action {
    Share sh;

    public void act() {
        if (sh.getName() == "sber" && sh.getCost() < 2) {
            System.out.println("buy");
        }
    }

    @Override
    public void act(Share sh) {
        act();
    }
}

    class VTBRobot implements Action {
        Share sh;

        public void act() {
            if (sh.getName() == "sber" && sh.getCost() < 2) {
                System.out.println("buy");
            }
        }

        @Override
        public void act(Share sh) {

        }
    }

    class VTBRobot2 implements Action{
        Share sh;
        public void act() {
            if (sh.getName() == "vtbr" && sh.getCost() > 4) {
                System.out.println("sell");
            }
        }

        @Override
        public void act(Share sh) {

        }
    }
