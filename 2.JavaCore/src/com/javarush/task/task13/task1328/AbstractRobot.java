package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable{
    //public abstract BodyPart attack();
   // public abstract BodyPart defense();
    //public abstract String getName();

    private static int hitCount;
    public String name;



    public String getName() {
        return name;
    }

    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = (int) (Math.random() * 4) + 1;

        if (hitCount == 4) {
            attackedBodyPart = BodyPart.CHEST;
        } else if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
            hitCount = 0;
        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defencedBodyPart = null;
        hitCount = (int) (Math.random() * 4) + 1;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defencedBodyPart = BodyPart.ARM;
            hitCount = 0;
        } else if (hitCount == 4) {

            defencedBodyPart = BodyPart.CHEST;
        }
        return defencedBodyPart;
    }
}
