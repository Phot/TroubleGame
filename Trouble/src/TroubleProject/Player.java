package TroubleProject;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {


	
	private Image[] playerImgs;
	private int[] pos;
	private boolean[] playerInStart, pieceScored;
	
	public Player(String imgRef, int team) throws SlickException{
		
		pos = new int[4];
		pieceScored = new boolean[4];
		playerInStart = new boolean[4];
		playerImgs = new Image[4];
		
		for(int i = 0; i < 4; i ++){
		playerImgs[i] = new Image(imgRef);
		playerInStart[i] = true;
		pieceScored[i] = false;
		}	
	}
	
public void setPos(int piece, int position){
	pos[piece] = position;
}

public void started(int piece){
	playerInStart[piece] = false;
}

public void scored(int piece){
	pieceScored[piece] = true;
}

public void drawPlayer(Rectangle[] rect, Graphics g, int playerPiece){

	g.drawImage(playerImgs[playerPiece], rect[playerPiece].getX(), rect[playerPiece].getY());
	
}
	
}
