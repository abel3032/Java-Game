package levels;

public class level {

    private int[][] lvlData;

    public level(int[][] lvlData)
    {
        this.lvlData = lvlData;
    }

    public int getSpriteIndex(int x, int y)
    {
        return lvlData[y][x];
    }

}
