package TroubleProject;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class TroubleGame extends BasicGame implements Constants{

	Dice dice;
	TroubleBoard board;
	Player[] players;
	int playerTurn;
	//Dice has rolled this turn
	boolean diceHasRolled, inPmenu, endGame;
	String winners;
	int nextRank; 
	boolean[] teamColor;
	
	//my game images
	
	
	public TroubleGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	// is executed
	public static void main(String args[]) throws SlickException {
		
		AppGameContainer app = new AppGameContainer(new TroubleGame ("Wep Slick2D"));
		// /w /h /boolean fullscreen
		
		//app.setDisplayMode(750, 250, false);
		
		app.setDisplayMode(SCREEN_X, SCREEN_Y, false);
		app.start();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// draw all graphics (EVERY SINGLE ONE
		
		//g.drawImage(back, 0, 0);
		board.drawBackground(g);
		if(!endGame){
			 //players[playerTurn].drawTest(g);
			switch(playerTurn){
			case 0: g.drawString("Turn: Red", 256,0);
			break;
			case 1: g.drawString("Turn: Blue", 256,0);
			break;
			case 2: g.drawString("Turn: Yellow", 256,0);
			break;
			case 3: g.drawString("Turn: Green", 256,0);
			break;
			}
		
		dice.drawFace(g);
		for(int i = 0; i < 4; i ++){
			for(int q = 0; q < 4; q ++){
				//System.out.println("drawingShit");
				players[i].drawPlayer(board.getBoard(i), g, q, i);
			}
		}
		
		if(inPmenu){
			g.drawString("What piece do you want to move, left : 1, up : 2, right : 3, down : 4", 200, 200);
		}
	}	
		else{
			g.drawString(winners, 200, 200);
			g.drawString("start new game? (y/n)", 200, 300);
		}
		
	}
				//readyForMove = true;
		

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// load all fonts, graphics sounds, etc into ram
		Image piecesImg = new Image("/resources/Pieces.png");
		SpriteSheet piecesSheet = new SpriteSheet(piecesImg, 32, 56);
		playerTurn = 0;
		diceHasRolled = false; inPmenu = false; endGame = false;
		winners = "The rankings are: ";
		nextRank = 1;
		board = new TroubleBoard(10, 32, "/resources/board.png");
		dice = new Dice();
		players = new Player[4];
		for(int i = 0; i < 4; i ++){
			players[i] = new Player(piecesSheet.getSubImage((i), 0));
		}
		teamColor = new boolean[4];
		for(int i = 0; i < 4; i ++){
			teamColor[i] = false;
		}
	//delta = fps variable (apply to moving objects)
	}
	public void update(GameContainer gc, int delta) throws SlickException {
		// game logic (AI, user input)
		
		Input input = gc.getInput(); // asks Slick 2D what keys are being pressed
		//if(readyForMove){
		// if the arrow is being pressed
		System.out.println(playerTurn);
		if(endGame){
			if(input.isKeyDown(Input.KEY_Y)){
				//WARNING MAY GET ERRORS
				
				init(gc);
				
			}
			if(input.isKeyDown(Input.KEY_N)){
				System.exit(0);
			}
			
		}
		if(!diceHasRolled){
		if(input.isKeyDown(Input.KEY_UP)){
			diceHasRolled = true;
			dice.setRoll();
		}
		}
		dice.testRoll();
		if(!dice.inRoll && diceHasRolled){
			boolean rolledSix = false;
			inPmenu = true;
			int n = -1;
			
			if(players[playerTurn].existPiecesThatCanMove(dice.getFaceNum())){
			while(!input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_RIGHT) 
					&& !input.isKeyDown(Input.KEY_DOWN) || players[playerTurn].getError() || rolledSix){
			
			if(input.isKeyDown(Input.KEY_LEFT)){
				n = 0;
			}
			if(input.isKeyDown(Input.KEY_UP)){
				n = 1;
			}
			if(input.isKeyDown(Input.KEY_RIGHT)){
				n = 2;
			}
			if(input.isKeyDown(Input.KEY_DOWN)){
				n = 3;
			}
			players[playerTurn].addPos(n, dice.getFaceNum());
				if(dice.getFaceNum() == 6){
					rolledSix = true;
				}
				else{
					rolledSix = false;
				}
			for(int i = 0; i < 4; i ++){
				for(int q = 0; q < 4; q++){
					if(i == playerTurn && i < 4){
						i ++;
					}
					else if (i == playerTurn && i >= 4){
						break; 
					}
					if(players[playerTurn].getPos(n) == players[i].getPos(q)){
						players[i].setStart(n); 
					}
					
				}
			}
			
			
		}
			
		}
			else if(players[playerTurn].isWon()){
				switch(playerTurn){
				
				case 0: winners.concat(nextRank  + " red ");
				teamColor[0] = true;
				break;
				case 1: winners.concat(nextRank  + " blue ");
				teamColor[1] = true;
				break;
				case 2: winners.concat(nextRank  + " yellow ");
				teamColor[2] = true;
				break;
				case 3: winners.concat(nextRank  + " green ");
				teamColor[3] = true;
				break;
				}
				nextRank ++;
				if(nextRank == 4){
					for(int i = 0; i < 4; i++){
						if(teamColor[i] != false)
							switch(i){
							case 0: winners.concat(nextRank  + " red ");
							teamColor[0] = true;
							break;
							case 1: winners.concat(nextRank  + " blue ");
							teamColor[1] = true;
							break;
							case 2: winners.concat(nextRank  + " yellow ");
							teamColor[2] = true;
							break;
							case 3: winners.concat(nextRank  + " green ");
							teamColor[3] = true;
							break;
							}
					}
					endGame = true;
				}
			}
			inPmenu = false;
			if(playerTurn < 3){
				playerTurn ++;
			}
			else{
				playerTurn = 0;
			}
		}
		
			
		
		
		// adds a unit
		
		
		
}
}


