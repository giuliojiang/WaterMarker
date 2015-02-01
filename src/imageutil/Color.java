package imageutil;

public class Color
{


    private int red;

    private int green;

    private int blue;
    
    private int alpha;


//    public Color(int red, int green, int blue)
//    {
//        this.red = red;
//        this.green = green;
//        this.blue = blue;
//        this.alpha = 255;
//    }
    
    public Color(int alpha, int red, int green, int blue)
    {
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }


    public int getRed()
    {
        return red;
    }


    public int getGreen()
    {
        return green;
    }


    public int getBlue()
    {
        return blue;
    }

    public int getAlpha()
    {
        return alpha;
    }

    public void setRed(int red)
    {
        this.red = red;
    }


    public void setGreen(int green)
    {
        this.green = green;
    }


    public void setBlue(int blue)
    {
        this.blue = blue;
    }
    
    public void setAlpha(int alpha)
    {
        this.alpha = alpha;
    }
}
