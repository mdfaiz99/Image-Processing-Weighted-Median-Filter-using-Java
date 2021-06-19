import java.util.*;
import java.awt.Color; 
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class WeightedMedianFilter{

	 public static void main(String[] a)throws Throwable{
	        File f = new File("test.jpg");
	        Color[] pixel = new Color[9];
	        int[] red = new int[12];
	        int[] blue = new int[12];
	        int[] green = new int[12];
	        int[] weight = {0,1,0,1,5,1,0,1,0};
	        	
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
	                   if(k == 4) {
	                	   red[k] = pixel[k].getRed();
	                	   red[k+1] = pixel[k+1].getRed();
	                	   red[k+2] = pixel[k+2].getRed();
	                	   red[k+3] = pixel[k+3].getRed();
	                	   red[k+4] = pixel[k+4].getRed();	                	   
	                	   green[k] = pixel[k].getGreen();
	                	   green[k+1] = pixel[k+1].getGreen();
	                	   green[k+2] = pixel[k+2].getGreen();
	                	   green[k+3] = pixel[k+3].getGreen();
	                	   green[k+4] = pixel[k+4].getGreen();
	                	   blue[k] = pixel[k].getBlue();
	                	   blue[k+1] = pixel[k+1].getBlue();
	                	   blue[k+2] = pixel[k+2].getBlue();
	                	   blue[k+3] = pixel[k+3].getBlue();
	                	   blue[k+4] = pixel[k+4].getBlue();
	                   }
	                   else {
	                	   red[k] = pixel[k].getRed() * weight[k];
	                	   green[k] = pixel[k].getGreen() * weight[k];
	                	   blue[k] = pixel[k].getBlue() * weight[k];
	                   }	                   
	               }
	               Arrays.sort(red);
	               Arrays.sort(green); 
	               Arrays.sort(blue);	              
	               img.setRGB(i, j, new Color((red[5] + red[6]) / 2, (blue[5] + blue[6]) / 2, (green[5] + green[6]) / 2).getRGB());
	            }
	        }
	        
	        ImageIO.write(img,"jpg",output);

	   }
}


