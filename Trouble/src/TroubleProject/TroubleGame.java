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
	Button[] buttons;
	int playerTurn;
	//Dice has rolled this turn
	boolean diceHasRolled, inPmenu, endGame;
	String winners;
	int nextRank; 
	boolean[] teamColor;
	boolean lastTurnEnded;
	boolean rolledSix;
	boolean setChoosable;
	int n;
	
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
			
			case 0: g.drawString("Turn: Red (press SPACE to roll Dice)", 256,0);
			break;
			case 1: g.drawString("Turn: Blue (press SPACE to roll Dice)", 256,0);
			break;
			case 2: g.drawString("Turn: Yellow (press SPACE to roll Dice)", 256,0);
			break;
			case 3: g.drawString("Turn: Green (press SPACE to roll Dice)", 256,0);
			break;
			}
		
		dice.drawFace(g);
		for(int i = 0; i < 4; i ++){
			for(int q = 0; q < 4; q ++){
				//System.out.println("drawingShit");
				players[i].drawPlayer(board.getBoard(i), playerTurn, g, q, i, inPmenu);
				buttons[i].drawButton(g);
			}
		}
		
		if(inPmenu){
			g.drawString("What piece do you want to move," + "\n" + "left : piece 1, up : piece 2, right : piece 3, down : piece 4", 600, 0);
		}
	}	
		else{
			g.drawString(winners, 200, 200);
			g.drawString("start new game? (y/n)", 200, 300);
		}
		board.drawTiles(g);
		g.flush();
		
	}
				//readyForMove = true;
		

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// load all fonts, graphics sounds, etc into ram
		Image piecesImg = new Image("/resources/Pieces.png");
		SpriteSheet piecesSheet = new SpriteSheet(piecesImg, 32, 56);
		playerTurn = 0;  n = -1;
		diceHasRolled = false; inPmenu = false; endGame = false; lastTurnEnded = true; rolledSix = false; setChoosable = false;
		winners = "The rankings are: ";
		nextRank = 1;
		board = new TroubleBoard(10, 32, "/resources/board.png");
		dice = new Dice();
		players = new Player[4];
		buttons = new Button[4];
		for(int i = 0; i < 4; i ++){
			players[i] = new Player(piecesSheet.getSubImage((i), 0));
		}
		teamColor = new boolean[4];
		for(int i = 0; i < 4; i ++){
			teamColor[i] = false;
		}
		for(int i = 0; i < 4; i ++){
			buttons[i] = new Button("" + i, 600 + (i * 32), 300, 32, 32);
		}
	//delta = fps variable (apply to moving objects)
	}
	public void update(GameContainer gc, int delta) throws SlickException {
		// game logic (AI, user input)
		
		Input input = gc.getInput(); // asks Slick 2D what keys are being pressed
		//if(readyForMove){
		// if the arrow is being pressed
		
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
		if(input.isKeyDown(Input.KEY_SPACE)){
			diceHasRolled = true;
			dice.setRoll();
			lastTurnEnded = false;
			
		}
		}
		
		 dice.goRoll();
		
/*
		if(input.isKeyDown(Input.KEY_LEFT) && setChoosable){
			System.out.println("sadf");
			n = 0;
			setChoosable = false;
		}
		if(input.isKeyDown(Input.KEY_UP)  && setChoosable){
			n = 1;
			setChoosable = false;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)  && setChoosable){
			n = 2;
			setChoosable = false;
		}
		if(input.isKeyDown(Input.KEY_DOWN)  && setChoosable){
			n = 3;
			setChoosable = false;
		}
		*/
		
		if(!dice.inRoll && diceHasRolled){
			
			inPmenu = true;
			
			
			
			
			
			if(players[playerTurn].existPiecesThatCanMove(dice.getFaceNum())){
			if(!buttons[0].clicked(input) || !buttons[1].clicked(input) && !buttons[2].clicked(input) &&
					!buttons[3].clicked(input) || players[playerTurn].getError() || !buttons[0].clicked(input) || !buttons[1].clicked(input) && !buttons[2].clicked(input) &&
					!buttons[3].clicked(input) && rolledSix){
				setChoosable = true;
				for(int i = 0; i < 4; i ++){
					buttons[i].setClickable(true);
				}
				
				if(buttons[0].clicked(input)){
					n = 0;
				}if(buttons[1].clicked(input)){
					n = 1;
				}if(buttons[2].clicked(input)){
					n = 2;
				}if(buttons[3].clicked(input)){
					n = 3;
				}
				
			
			
				System.out.println(n);

			
			if(n != -1){
				if(players[playerTurn].addPos(n, dice.getFaceNum())){
				for(int i = 0; i < 4; i ++){
					for(int q = 0; q < 4; q++){
						if(i == playerTurn && i < 3){
							i ++;
						}
						else if (i == playerTurn && i >= 3){
							break; 
						}
						if(players[playerTurn].getPos(n) == (players[i].getPos(q) + (i * 7))){
							players[i].setStart(n); 
							System.out.println("WFDKLSHG:ALHGFh");
						}
						
						}
				
				}
				if(dice.getFaceNum() == 6){
					rolledSix = true;
					diceHasRolled = false;
					n = -1;
					System.out.println("pirra");
				}
				
				else{
					rolledSix = false;
					lastTurnEnded = true;
					setChoosable = false;
					n = -1;
					
					
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
			else{
				lastTurnEnded = true;
			}
			if(lastTurnEnded){
				for(int i = 0; i < 4; i ++){
					buttons[i].setClickable(false);
				}
			lastTurnEnded = false;
			diceHasRolled = false;
			inPmenu = false;
			//players[playerTurn].refreshError();
			n = -1;
			if(playerTurn < 3){
				playerTurn ++;
			}
			else{
				playerTurn = 0;
			}
			}
		}
		
			
		
		
		// adds a unit
		
		
		
}
}


