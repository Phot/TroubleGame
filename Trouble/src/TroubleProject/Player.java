package TroubleProject;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player {


	
	Image[] playerImgs = new Image[4];
	int[] playerX;
	int[] playerY;
	
	public Player(String imgRef) throws SlickException{
	
		for(int i = 0; i < playerImgs.length; i ++){
		playerImgs[i] = new Image(imgRef);
		}
		playerX = new int[4];
		playerY = new int[4];
	}

}
