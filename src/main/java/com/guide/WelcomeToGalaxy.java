package com.guide;

import com.guide.process.Controller;
import com.guide.process.GuideController;

/**
 * @author Sanket Gupta
 * Starting point for the application.
 * 
 */
public class WelcomeToGalaxy {

	public static void main(String[] args) {
		String filePath ;

		if (args.length == 1){
			filePath=args[0];
		}else {
			filePath = "./Input";
		}		
		
		Controller guideController = new GuideController();
		String result = guideController.startGuide(filePath);
		System.out.println(result);
	}
}
