package com.bmsus.utils;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class screenshots {
	public void takeAScreenShotOfTheApp() {
	    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	    Rectangle screenBounds = new Rectangle(0, 0, screenDim.width, screenDim.height);

	    Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    BufferedImage image =  robot.createScreenCapture(screenBounds);
	    
	    String imagefolder = openfile.timestampfolder + File.separator+ "images";
	    
	    new File(imagefolder).mkdir();

	    File screenshotFile = new File(imagefolder + File.separator
	                                   + "image" + System.currentTimeMillis() + ".png");
	    try {
			ImageIO.write(image, "png", screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
