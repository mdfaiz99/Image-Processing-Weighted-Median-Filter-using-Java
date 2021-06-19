import java.util.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class MedianFilter {

	 public static void main(String[] a)throws Throwable{
	        File f=new File("test.jpg"); 
	        Color[] pixel = new Color[9];
	        int[] red = new int[9];
	        int[] blue = new int[9];
	        int[] green = new int[9];
	        
	        File output = new File("output.jpg");
	        BufferedImage img = ImageIO.read(f);
	        
	        for(int i = 1; i < img.getWidth()-1; i++) {
	            for(int j = 1; j < img.getHeight()-1; j++) {
	               pixel[0] = new Color(img.getRGB(i-1, j-1));
	               pixel[1] = new Color(img.getRGB(i-1, j));
	               pixel[2] = new Color(img.getRGB(i-1, j+1));
	               pixel[3] = new Color(img.getRGB(i, j+1));
	               pixel[4] = new Color(img.getRGB(i+1, j+1));
	               pixel[5] = new Color(img.getRGB(i+1, j));
	               pixel[6] = new Color(img.getRGB(i+1, j-1));
	               pixel[7] = new Color(img.getRGB(i, j-1));
	               pixel[8] = new Color(img.getRGB(i, j));
	               
	               for(int k = 0; k < 9; k++){
	                   red[k] = pixel[k].getRed();
	                   blue[k] = pixel[k].getBlue();
	                   green[k] = pixel[k].getGreen();	                   
	               }
	               
	               Arrays.sort(red);
	               Arrays.sort(green);
	               Arrays.sort(blue);
	               img.setRGB(i, j, new Color(red[4], blue[4], green[4]).getRGB());
	            }
	        }
	        
	        ImageIO.write(img,"jpg",output);

	   }
}


