package utils;

public class Constants {

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class Attack{
        public static final int ATTACK = 0;
    }

    public static class playerConstants{
        public static final int RUNNING = 1;
        public static final int IDLE = 0;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK1 = 6;
        public static final int ATTACK_JUMP1 = 7;
        public static final int ATTACK_JUMP2 = 8;

        public static int getSpriteAmmount(int player_Action)
        {
            if(player_Action == RUNNING)
                return 6;
            if(player_Action == IDLE)
                return 5;
            if(player_Action == HIT)
                return 4;
            if(player_Action == JUMP || player_Action == ATTACK1 || player_Action == ATTACK_JUMP1 || player_Action == ATTACK_JUMP2)
                return 3;
            if(player_Action == GROUND)
                return 2;
            if(player_Action == FALLING)
                return 1;

            return 1;
        }
    }
}
