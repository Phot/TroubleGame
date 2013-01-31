package TroubleProject;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class TroubleBoard extends BoardGame{

	
	 Rectangle[] redArray, bluArray, yelArray, greArray, realArray;
	 int[] redCompare, bluCompare, yelCompare, greCompare;
	
	
	public TroubleBoard(int wAndH, int howManyGiven, String path) throws SlickException {
		super(wAndH, howManyGiven, path);
		initTiles();
		// TODO Auto-generated constructor stub
	}

	public void initTiles(){ 
		super.initTiles();
	redArray = new Rectangle[howMany];
	redCompare = new int[32];
	bluArray = new Rectangle[howMany];
	bluCompare = new int[32];
	yelArray = new Rectangle[howMany];
	yelCompare = new int[32];
	greArray = new Rectangle[howMany];
	greCompare = new int[32];
	//what we base who moves on what, IE if blu moves to space 3, it will be translated to a global 3. 
	realArray = new Rectangle[28];
		
	//initializing the square sided tiles on the trouble board in the place tile array
	//copying over these tiles into the color arrays 
		for(int i = 0; i < 7; i ++){
			redArray[i] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			redCompare[i] = i;
			bluArray[i + 21] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			bluCompare[i + 21] = i;
			yelArray[i + 14] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			yelCompare[i + 14] = i;
			greArray[i + 7] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			yelCompare[i + 7] = i;
		}
		for(int i = 0; i < 7; i ++){
			redArray[i + 7] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			redCompare[i + 7] = i;
			bluArray[i] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			bluCompare[i] = i;
			yelArray[i + 21] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			yelCompare[i + 21] = i;
			greArray[i + 14] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			greCompare[i + 14] = i;

		}
		for(int i = 0; i < 7; i ++){
			redArray[i + 14] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			redCompare[i + 14] = i;
			bluArray[i + 7] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			bluCompare[i + 7] = i;
			yelArray[i] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			yelCompare[i] = i;
			greArray[i + 21] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			greCompare[i + 21] = i;

		}
		for(int i = 0; i < 7; i ++){
			redArray[i + 21] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			redCompare[i + 21] = i;
			bluArray[i + 14] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			bluCompare[i + 14] = i;
			yelArray[i + 7] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			yelCompare[i + 7] = i;
			greArray[i] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			greCompare[i] = i;

		}
		
		//copying over these tiles into the color arrays (NOTE THIS DIDN'T SEEM TO WORK, INSTEAD CHANGED PLACE TILE
		//INITIALIZATION ABOVE TO COLOR ARRAY INIT
		/*
		for(int i = 0; i < placeTiles.length; i ++){
			redArray[i] = placeTiles[i];
			
			if((i) < 7)
			bluArray[i + 21] = placeTiles[i];
			else{
				bluArray[i - 7] = placeTiles[i];
			}
			if((i) < 14)
			yelArray[i + 14] = placeTiles[i];
			else{
				yelArray[i - 14] = placeTiles[i];
			}
			if((i) < 21)
			greArray[i + 7] = placeTiles[i];
			else{
				greArray[i - 21] = placeTiles[i];
			}
		}
		*/
		for(int i = 0; i < 4; i ++){
			redArray[i + 28] = new Rectangle(128 + (i * 32), 128 + (i * 32), widthOfTile, widthOfTile);
	}
		for(int i = 0; i < 4; i ++){
			bluArray[i + 28] = new Rectangle(480 - (i * 32), 128 + (i * 32), widthOfTile, widthOfTile);
	}
		for(int i = 0; i < 4; i ++){
			yelArray[i + 28] = new Rectangle(480 - (i * 32), 480 - (i * 32), widthOfTile, widthOfTile);
	}
		for(int i = 0; i < 4; i ++){
			greArray[i + 28] = new Rectangle(128 + (i * 32), 480 - (i * 32), widthOfTile, widthOfTile);
	}
	
		
}
	
	public int getRelPos(int n, int team){
		int returnedInt = 0;
		switch(team){
		case 0: returnedInt = redCompare[n];
			break;
		case 1: returnedInt = bluCompare[n];
		break;
		case 2: returnedInt = greCompare[n];
		break;
		case 3: returnedInt = redCompare[n];
		break;
		}
		return returnedInt;
	}
	public void drawTiles(Graphics g){
		 
		for(int i = 0; i < redArray.length; i ++){
			g.setColor(Color.gray);
			
				g.draw(redArray[i]);
				//System.out.println(i);
				g.drawString(""+i, redArray[i].getX(), redArray[i].getY());
			
			
			
		}
		
	}
	public void drawBackground(Graphics g){
		g.drawImage(background, 64, 64);
	}
	
public Rectangle[] getBoard(int i){
	Rectangle[] tempRect = new Rectangle[32];
	switch(i){
	case 0: tempRect = redArray;
	break;
	case 1: tempRect = bluArray;
	break;
	case 2: tempRect = yelArray;
	break;
	case 3: tempRect = greArray;
	break;
	}
	return tempRect;
}
	
}
