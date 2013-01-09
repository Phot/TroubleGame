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
	int playerTurn = 1;
	//Dice has rolled this turn
	boolean diceHasRolled = false;
	
	//my game images
	
	
	public TroubleGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	//penis
	
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
						}	
				//readyForMove = true;
		

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// load all fonts, graphics sounds, etc into ram
		board = new TroubleBoard(10, 32);
		dice = new Dice();
		
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
		if(!dice.inRoll){
			
		}
		
		
		// adds a unit
		
		
		
}
}
