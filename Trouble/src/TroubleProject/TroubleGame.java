package TroubleProject;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class TroubleGame extends BasicGame implements Constants{

	Dice dice;
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
		
		dice.drawFace(g);
						}	
				//readyForMove = true;
		

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// load all fonts, graphics sounds, etc into ram
		dice = new Dice();
		
	//delta = fps variable (apply to moving objects)
	}
	public void update(GameContainer gc, int delta) throws SlickException {
		// game logic (AI, user input)
		
		Input input = gc.getInput(); // asks Slick 2D what keys are being pressed
		//if(readyForMove){
		// if the arrow is being pressed
		if(input.isKeyDown(Input.KEY_UP)){
			dice.setRoll();
		}
		dice.testRoll();
		
		// adds a unit
		
		
		
}
}
