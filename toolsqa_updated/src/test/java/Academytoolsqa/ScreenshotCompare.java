package Academytoolsqa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenshotCompare  {
	
	
	// TODO Auto-generated method stub
	@Test
	public void imageCompare() throws IOException {
			
	
		BufferedImage expectedImage= ImageIO.read(new File("./screenshots/toolqa.com 2020_10_14__10_13_03.png"));
		BufferedImage actualImage= ImageIO.read(new File("./screenshotsfirst/toolqa.com 2020_10_14__10_14_21.png"));
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff= imgDiff.makeDiff(expectedImage, actualImage);
		
		if(diff.hasDiff()==true) {
			System.out.println("Images are not same");
		}
		else {
			System.out.println("Images are same");

		}
		
	
		}	
		
	}
	


