


	package TroubleProject;

	import java.util.Random;

	import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


	public class Dice {

			//rollnumb is the number of rolls the dice should do.
		//TODO add a thing that tell what the last face was so it doesn't choose it twice in a row. 
		//sleep
		int rollNum;
		int face = 0;
		long time = 0;
		long currTime;
		Image diceSheet; 
		
		boolean inRoll;
		boolean rollJustStarted;
		int diceBoardX = 256, diceBoardY = 256;
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
			return diceSpriteSheet.getSubImage(face, 0);
		}
		public int getFaceNum(){
			return face + 1;
		}
		
		public void setRoll(){
			inRoll = true;
			rollJustStarted = true;
		}
		
		public void goRoll(){
			if(inRoll){
				if(rollJustStarted){
					rollNum = (random.nextInt(20) + 6);
					rollJustStarted = false;
					time = System.currentTimeMillis();
				}
				
					currTime = System.currentTimeMillis();
					
				if(currTime - time > 100){
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


