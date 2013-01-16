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
			if(pos[piece] + position != pos[0] && pos[piece] + position != pos[1] 
			&& pos[piece] + position != pos[2] && pos[piece] + position != pos[3]){
		if(pos[piece] + position == 31){
			
			pos[piece] += position;
			pieceScored[piece] = true;
			isError = false;
			
		}
		else{
			if(!playerInStart[piece]){
				pos[piece] += position;
				isError = false;
				}
				else if(position == 6 && playerInStart[piece]){
					setStart(piece);
				}
				
				else{
					isError = true;
					errorMessage = "Choose a new piece, you didn't roll a 6 and you can't move it from start";
				}
	
	
			}
		}
			else{
				isError = true;
				errorMessage = "Choose a new piece, this one landed on another you own";
			}
			
	}
		else{ 
			isError = true;
			errorMessage = "Choose a new piece, this one is allready scored";
		}
	}
	else{
		isError = true;
		errorMessage  = "Choose a new piece, this one cannot go that far";
		
	}
}

public void setPos(int piece, int position){
	pos[piece] = position;
}
public boolean getError(){
	return isError;
}

public void setError(String inputMessage){
	errorMessage = inputMessage;
	isError = true;
}
public int getPos(int piece){
	return pos[piece];
}

public void started(int piece){
	setPos(piece, 0);
	playerInStart[piece] = false;
}
public void setStart(int piece){
	playerInStart[piece] = true;
}

public void scored(int piece){
	pieceScored[piece] = true;
}

public void drawPlayer(Rectangle[] rect, Graphics g, int playerNum, int team){

	if(playerInStart[playerNum]){
	g.drawImage(playerImgs[playerNum], rect[getPos(playerNum)].getX(), rect[getPos(playerNum)].getY());
	}
	else{
		switch(team){
		case 0: g.drawImage(playerImgs[playerNum], /*top right*/  playerNum * 20, 200 - (playerNum * 20));
		case 1: g.drawImage(playerImgs[playerNum], /*top left*/ 400 + (playerNum * 20), 20 * playerNum);
		case 2: g.drawImage(playerImgs[playerNum], /*bottom left*/ 400 - (playerNum * 20), 400 + (playerNum * 20));
		case 3: g.drawImage(playerImgs[playerNum], /*bottom right*/ 20 - (playerNum * 20), 400 - (playerNum * 20));
		}
	}
	if(isError){
	g.drawString(errorMessage, 200, 200);
	}
	
}
	
}
