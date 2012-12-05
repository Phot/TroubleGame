package TroubleProject;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class TroubleBoard extends BoardGame{

	
	Rectangle[] redArray;
	Rectangle[] bluArray;
	Rectangle[] yelArray;
	Rectangle[] greArray;
	
	
	public TroubleBoard(int wAndH, int howManyGiven, String path)
			throws SlickException {
		super(wAndH, howManyGiven, path);
		// TODO Auto-generated constructor stub
	}

	public void initTiles(){
		super.initTiles();
	redArray = new Rectangle[howMany];
	bluArray = new Rectangle[howMany];
	yelArray = new Rectangle[howMany];
	greArray = new Rectangle[howMany];
		
	//initializing the square sided tiles on the trouble board in the place tile array
		for(int i = 0; i < 7; i ++){
			placeTiles[i] = new Rectangle(30 + (i * 10), 20, widthOfTile, widthOfTile);
		}
		for(int i = 0; i < 7; i ++){
			placeTiles[i + 7] = new Rectangle(100, 30 + (i * 10), widthOfTile, widthOfTile);
		}
		for(int i = 0; i < 7; i ++){
			placeTiles[i + 14] = new Rectangle(100 - (i * 10), 100, widthOfTile, widthOfTile);
		}
		for(int i = 0; i < 7; i ++){
			placeTiles[i + 21] = new Rectangle(30, 100 - (i * 10), widthOfTile, widthOfTile);
		}
		
		//copying over these tiles into the color arrays
		for(int i = 0; i < placeTiles.length; i ++){
			redArray[i] = placeTiles[i];
			bluArray[i] = placeTiles[i];
			yelArray[i] = placeTiles[i];
			greArray[i] = placeTiles[i];
		}
		for(int i = 0; i < 4; i ++){
			redArray[i + 28] = new Rectangle(30 + (i * 10), 30 + (i * 10), widthOfTile, widthOfTile);
	}
		for(int i = 0; i < 4; i ++){
			bluArray[i + 28] = new Rectangle(90 - (i * 10), 30 + (i * 10), widthOfTile, widthOfTile);
	}
		for(int i = 0; i < 4; i ++){
			yelArray[i + 28] = new Rectangle(90 - (i * 10), 90 - (i * 10), widthOfTile, widthOfTile);
	}
		for(int i = 0; i < 4; i ++){
			greArray[i + 28] = new Rectangle(30 + (i * 10), 90 - (i * 10), widthOfTile, widthOfTile);
	}
	
}
}
