package TroubleProject;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class BoardGame {
	//13 x 13 tile space
Image background;
Rectangle[] placeTiles;
int widthOfTile, howMany;
public BoardGame(int wAndH, int howManyGiven, String path) throws SlickException{
	widthOfTile = wAndH;
	howMany = howManyGiven;
	background = new Image(path);
	initTiles();
}

public void initTiles(){
	placeTiles = new Rectangle[howMany];
}

}
