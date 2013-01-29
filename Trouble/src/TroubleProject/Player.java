package TroubleProject;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player implements Constants {


	
	private Image[] playerImgs;
	private int[] pos;
	private boolean[] playerInStart, pieceScored;
	private boolean isError;
	private String errorMessage;
	private boolean won;
	private int rt = 700;
	
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
		rt = 700;
	}
public Player(Image imgRef){
		
		pos = new int[4];
		pieceScored = new boolean[4];
		playerInStart = new boolean[4];
		playerImgs = new Image[4];
		errorMessage = "currently no Input Errors";
		
		for(int i = 0; i < 4; i ++){
		playerImgs[i] = imgRef;
		playerInStart[i] = true;
		pieceScored[i] = false;
		
		}	
	}
	
	public boolean existPiecesThatCanMove(int position){
		int cantMove = 0;
		for(int i = 0; i < 4; i ++){
		if(pos[i] + position < 32){
			if(!pieceScored[i]){
				if(pos[i] + position != pos[0] && pos[i] + position != pos[1] 
				&& pos[i] + position != pos[2] && pos[i] + position != pos[3]){
			if(pos[i] + position == 31){
			}
			else{
				if(!playerInStart[i]){
					}
					else if(position == 6 && playerInStart[i]){
					}
					
					else{
						cantMove ++; 
					}
				}
			}
				else{
					cantMove ++; 
				}
		}
			else{ 
				cantMove ++; 
			}
		}
		else{
			if(pos[i] < 28){
				
			}
			else{
				cantMove++;
			} 
		}
	}
		if(pos[0] >= 28 && pos[1] >= 28 && pos[2] >= 28 && pos[3] >= 28){
			won = true;
		}
		else if(cantMove == 4){
			isError = true;
			errorMessage = "Player cannot move pieces since there are no pieces that can move";
			return false;
		}
		return true;
	}
public boolean addPos(int piece, int position){
	
	if(pos[piece] + position < 32){
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
					if(pos[piece] + position != pos[0] && pos[piece] + position != pos[1] 
							&& pos[piece] + position != pos[2] && pos[piece] + position != pos[3]){
					started(piece);
					}
					else{
						isError = true;
						errorMessage = "Choose a new piece, this one landed on another you own";
						rt = 700;
						return false;
					}
				}
				
				else{
					isError = true;
					errorMessage = "Choose a new piece, you didn't roll a 6 and you can't move it from start";
					rt = 800;
					return false;
				}
	
	
			}
		}
			else{
				isError = true;
				errorMessage = "Choose a new piece, this one landed on another you own";
				rt = 700;
				return false;
			}
			
	}
		else{ 
			isError = true;
			errorMessage = "Choose a new piece, this one is allready scored";
			rt = 700;
			return false;
		}
	}
	else{
		if(pos[piece] < 28){
			pos[piece] += ((pos[piece] + position) - 31); 
		}
		else{
		isError = true;
		errorMessage  = "Choose a new piece, this one cannot go that far";
		return false;
		}
		
	}
	return true;
}

public boolean isWon(){
	return won;
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
public void refreshError(){
	isError = false;
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

public void drawPlayer(Rectangle[] rect, int playersTurn, Graphics g, int playerNum, int team, boolean inDahMenu){
int drawPosX = 0, drawPosY = 0;
Color colorOfError = new Color(DEFAULT_COLOR);
	if(!playerInStart[playerNum]){
	g.drawImage(playerImgs[playerNum], rect[getPos(playerNum)].getX(), rect[getPos(playerNum)].getY() - 24);
	if(inDahMenu && playersTurn == team)
	g.drawString(""+ playerNum, rect[getPos(playerNum)].getX() + 16, rect[getPos(playerNum)].getY() - 24);
	//System.out.println(playerNum + " " + rect[getPos(playerNum)].getX() + " " + (rect[getPos(playerNum)].getY() - 24));
	}
	else{
		switch(team){
		case 0: /*top right*/  drawPosX = 64 + (playerNum * 32); drawPosY = 0; 
		break;
		case 1: /*top left*/ drawPosX = (512 + 64); drawPosY = (32 * playerNum) + 64; 
		break;
		case 2: /*bottom left*/ drawPosX = (512 + 32) - (32 * playerNum); drawPosY = (512 + 64); 
		break;
		case 3: /*bottom right*/ drawPosX = 32; drawPosY = (512 - 64) + (playerNum * 32) - 64; 
		break;
		}
		g.drawImage(playerImgs[playerNum], drawPosX, drawPosY);
		if(inDahMenu && playersTurn == team)
		g.drawString("" + playerNum, drawPosX + 16, drawPosY);
	}
	if(isError){
		switch(team){
		case 0: colorOfError = Color.red;
		break;
		case 1: colorOfError = Color.blue;
		break;
		case 2: colorOfError = Color.yellow;
		break;
		case 3: colorOfError = Color.green;
		break;
		}
	g.setColor(colorOfError);
	g.drawString(errorMessage, 200, (rt + (team * 20)));
	g.setColor(DEFAULT_COLOR);
	}
	
}

public void drawTest(Graphics g){
	g.drawImage(playerImgs[0], 600, 600);
}
	
}
