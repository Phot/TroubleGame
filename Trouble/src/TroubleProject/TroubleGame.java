package TroubleProject;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class TroubleGame extends BasicGame implements Constants{

	Dice dice;
	TroubleBoard board;
	Player[] players;
	int playerTurn = 0;
	//Dice has rolled this turn
	boolean diceHasRolled = false, inPmenu = false;
	
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
		board.drawTiles(g);
		dice.drawFace(g);
		for(int i = 0; i < 4; i ++){
			for(int q = 0; q < 4; q ++){
				players[i].drawPlayer(board.getBoard(q), g, q, i);
			}
		}
		
		if(inPmenu){
			g.drawString("What piece do you want to move, left : 1, up : 2, right : 3, down : 4", 200, 200);
		}
						}	
				//readyForMove = true;
		

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// load all fonts, graphics sounds, etc into ram
		board = new TroubleBoard(10, 32);
		dice = new Dice();
		players = new Player[4];
		for(int i = 0; i < 4; i ++){
			players[i] = new Player("imgTEST" + i);
		}
	//delta = fps variable (apply to moving objects)
	}
	public void update(GameContainer gc, int delta) throws SlickException {
		// game logic (AI, user input)
		
		Input input = gc.getInput(); // asks Slick 2D what keys are being pressed
		//if(readyForMove){
		// if the arrow is being pressed
		if(!diceHasRolled){
		if(input.isKeyDown(Input.KEY_UP)){
			diceHasRolled = true;
			dice.setRoll();
		}
		}
		dice.testRoll();
		if(!dice.inRoll && diceHasRolled){
			inPmenu = true;
			int n = -1;
			while(!input.isKeyDown(Input.KEY_LEFT) && !input.isKeyDown(Input.KEY_UP) && !input.isKeyDown(Input.KEY_RIGHT) 
					&& !input.isKeyDown(Input.KEY_DOWN) || players[playerTurn].getError()){
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
		
		
		// adds a unit
		
		
		
}
}


