package TroubleProject;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class TroubleBoard extends BoardGame{

	
	 Rectangle[] redArray, bluArray, yelArray, greArray;
	
	
	
	public TroubleBoard(int wAndH, int howManyGiven, String path) throws SlickException {
		super(wAndH, howManyGiven, path);
		initTiles();
		// TODO Auto-generated constructor stub
	}

	public void initTiles(){ 
		super.initTiles();
	redArray = new Rectangle[howMany];
	bluArray = new Rectangle[howMany];
	yelArray = new Rectangle[howMany];
	greArray = new Rectangle[howMany];
		
	//initializing the square sided tiles on the trouble board in the place tile array
	//copying over these tiles into the color arrays 
		for(int i = 0; i < 7; i ++){
			redArray[i] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			bluArray[i + 7] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			yelArray[i + 14] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
			greArray[i + 21] = new Rectangle(80 + (i * 64), 80, widthOfTile, widthOfTile);
		}
		for(int i = 0; i < 7; i ++){
			redArray[i + 7] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			bluArray[i + 14] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			yelArray[i + 21] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);
			greArray[i] = new Rectangle(528, 80 + (i * 64), widthOfTile, widthOfTile);

		}
		for(int i = 0; i < 7; i ++){
			redArray[i + 14] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			bluArray[i + 21] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			yelArray[i] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);
			greArray[i + 7] = new Rectangle(528 - (i * 64), 528, widthOfTile, widthOfTile);

		}
		for(int i = 0; i < 7; i ++){
			redArray[i + 21] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			bluArray[i] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			yelArray[i + 7] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);
			greArray[i + 14] = new Rectangle(80, 528 - (i * 64), widthOfTile, widthOfTile);

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
	
	public void drawTiles(Graphics g){
		 
		for(int i = 0; i < redArray.length; i ++){
			g.setColor(Color.red);
			
				g.draw(bluArray[i]);
				//System.out.println(i);
				g.drawString(""+i, bluArray[i].getX(), bluArray[i].getY());
			
			
			
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
