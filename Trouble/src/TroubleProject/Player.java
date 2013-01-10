package TroubleProject;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {


	
	private Image[] playerImgs;
	private int[] pos;
	private boolean[] playerInStart, pieceScored;
	private boolean isError;
	private String errorMessage;
	
	
	public Player(String imgRef) throws SlickException{
		
		pos = new int[4];
		pieceScored = new boolean[4];
		playerInStart = new boolean[4];
		playerImgs = new Image[4];
		errorMessage = "currently no Input Errors";
		
		for(int i = 0; i < 4; i ++){
		playerImgs[i] = new Image(imgRef);
		playerInStart[i] = true;
		pieceScored[i] = false;
		}	
	}
	
public void addPos(int piece, int position){
	if(pos[piece] + position > 32){
		if(!pieceScored[piece]){
		if(pos[piece] + position == 31){
			pieceScored[piece] = true;
			isError = false;
		}
		else{
	pos[piece] += position;
	isError = false;
	
		}
	}
		else{ 
			isError = true;
			errorMessage = "Chose a new piece, this one is allready scored";
		}
	}
	else{
		isError = true;
		errorMessage  = "Chose a new piece, this one cannot go that far";
		
	}
}

public boolean getError(){
	return isError;
}

public int getPos(int piece){
	return pos[piece];
}

public void started(int piece){
	playerInStart[piece] = false;
}

public void scored(int piece){
	pieceScored[piece] = true;
}

public void drawPlayer(Rectangle[] rect, Graphics g, int playerPiece){

	g.drawImage(playerImgs[playerPiece], rect[playerPiece].getX(), rect[playerPiece].getY());
	if(isError){
	g.drawString(errorMessage, 200, 200);
	}
	
}
	
}
