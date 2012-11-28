


	package TroubleProject;

	import java.util.Random;

	import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


	public class Dice {

			//rollnumb is the number of rolls the dice should do.
		
		int rollNum;
		int face;
		long time = 0;
		long currTime;
		Image diceSheet; 
		
		boolean inRoll;
		boolean rollJustStarted;
		int diceBoardX = 500, diceBoardY = 500;
		Random random = new Random();
		SpriteSheet diceSpriteSheet; 
		
		public Dice() throws SlickException{
			diceSheet = new Image("/resources/DiceSprite.png");
			diceSpriteSheet = new SpriteSheet(diceSheet, 128, 128);
		}
		
		
		public void drawFace(Graphics g){
			g.drawImage(getFace(), diceBoardX, diceBoardY);
		}
		
		
		public Image getFace(){
			return diceSpriteSheet.getSubImage(0 + (128 * face), 0);
		}
		
		public void setRoll(){
			inRoll = true;
			rollJustStarted = true;
		}
		
		public void Roll(){
			if(inRoll){
				if(rollJustStarted){
					rollNum = (random.nextInt(20) + 6);
					rollJustStarted = false;
					time = 
				}
				if(currTime - time > 1000){
					rollNum --;
					face = random.nextInt(6);
					time = currTime;
					if(rollNum == 0){
						inRoll = false;
					}
				}
				
			}
		}
		
	}


