package imageutil;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Utils {


  private Utils() {
  }


  public static Picture createPicture(int width, int height) {
    BufferedImage img = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_ARGB);
    return new Picture(img);
  }


  public static Picture loadPicture(String locationString) {

    final BufferedImage img;
    final BufferedImage origImage;

    URL locationURL = null;
    File locationFile = null;
    try {
      locationURL = new URL(locationString);
    } catch (MalformedURLException e) {
      File tmpFile = new File(locationString);
      if (tmpFile.exists() && tmpFile.canRead()) {
        locationFile = tmpFile;
      }
    }

    try {
      if (locationURL != null) {
        origImage = ImageIO.read(locationURL);
      } else if (locationFile != null) {
        origImage = ImageIO.read(locationFile);
      } else {
        return null;
      }
      
      if (origImage == null) {
        return null;
      }
      
    } catch (IOException e) {
      return null;
    }

    // If image loaded, then create a BufferedImage which is modifiable
    int imageWidth = origImage.getWidth(null);
    int imageHeight = origImage.getHeight(null);
    img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.createGraphics();
    g.drawImage(origImage, 0, 0, null);
    return new Picture(img);
  }


  public static String toArray(Picture picture) {
    StringBuilder sb = new StringBuilder();

    for (int y = 0; y < picture.getHeight(); y++) {
      for (int x = 0; x < picture.getWidth(); x++) {
        Color rgb = picture.getPixel(x, y);
        sb.append("(");
        sb.append(rgb.getRed());
        sb.append(",");
        sb.append(rgb.getGreen());
        sb.append(",");
        sb.append(rgb.getBlue());
        sb.append(")");
      }
      sb.append("\n");
    }
    sb.append("\n");
    return sb.toString();
  }


  public static boolean savePicture(Picture picture, String destination) {
    try {
      return ImageIO.write(picture.getImage(), "png", new File(destination));
    } catch (IOException e) {
      return false;
    }
  }
}
