package imageutil;

import java.awt.image.BufferedImage;

public class Picture
{

    private final BufferedImage image;

    protected Picture(BufferedImage image)
    {
        this.image = image;
    }

    protected BufferedImage getImage()
    {
        return image;
    }

    public int getWidth()
    {
        return image.getWidth();
    }

    public int getHeight()
    {
        return image.getHeight();
    }

    public Color getPixel(int x, int y)
    {
        int rgb = image.getRGB(x, y);
        return new Color(
            (rgb >> 24) & 0xff,
            (rgb >> 16) & 0xff,
            (rgb >> 8) & 0xff,
            (rgb >> 0) & 0xff);
    }

    public void setPixel(int x, int y, Color rgb)
    {

        image.setRGB(x, y,
            (
                ((0xff & rgb.getRed()) << 24)   |
                ((0xff & rgb.getGreen()) << 16) |
                ((0xff & rgb.getBlue())  << 8)  |
                ((0xff & rgb.getAlpha()) << 0)    
            )
            )
            ;

        // 0xff000000 | (((0xff & rgb.getRed()) << 16)
        // | ((0xff & rgb.getGreen()) << 8) | (0xff & rgb.getBlue())));
    }

    public boolean contains(int x, int y)
    {
        return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
    }

    // public boolean equals(Object otherO)
    // {
    // if (otherO == null)
    // {
    // return false;
    // }
    // if (!(otherO instanceof Picture))
    // {
    // return false;
    // }
    //
    // Picture other = (Picture) otherO;
    //
    // if (image == null || other.image == null)
    // {
    // return image == other.image;
    // }
    // if (image.getWidth() != other.image.getWidth()
    // || image.getHeight() != other.image.getHeight())
    // {
    // return false;
    // }
    //
    // for (int i = 0; i < image.getWidth(); i++)
    // {
    // for (int j = 0; j < image.getHeight(); j++)
    // {
    // if (image.getRGB(i, j) != other.image.getRGB(i, j))
    // {
    // return false;
    // }
    //
    // }
    // }
    // return true;
    // }

    // public int hashCode()
    // {
    // if (image == null)
    // {
    // return -1;
    // }
    // int hashCode = 0;
    // for (int i = 0; i < image.getWidth(); i++)
    // {
    // for (int j = 0; j < image.getHeight(); j++)
    // {
    // hashCode = 31 * hashCode + image.getRGB(i, j);
    // }
    // }
    // return hashCode;
    // }
}
