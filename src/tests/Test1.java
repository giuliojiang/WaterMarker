package tests;

import imageutil.Color;
import imageutil.Picture;
import imageutil.Utils;

public class Test1
{

    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Args required");
            return;
        }
        
        // load image
        Picture img = Utils.loadPicture(args[0]);
        
        // transform image
        img = setAlpha(img,128);
        
        // save image
        Utils.savePicture(img, args[1]);
    }
    
    public static Picture setAlpha(Picture p, int a)
    {
        Picture out = Utils.createPicture(p.getWidth(), p.getHeight());
        for (int i = 0; i < p.getWidth(); i++)
        {
            for (int j = 0; j < p.getHeight(); j++)
            {
                Color c = p.getPixel(i, j);
                c.setAlpha(a);
                out.setPixel(i, j, c);
            }
        }
        return out;
    }
    
}
