package TroubleProject;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class Button {
	
	private boolean stateClickable; 
	private String textDisplayedOnButton;
	private Rectangle buttonRect;
	private int width, hieght, x, y;
	
	public Button (String text, int sizeX, int sizeY, int xpos, int ypos){
		textDisplayedOnButton = text;
		width = sizeX;
		hieght = sizeY;
		x = xpos;
		y = ypos;
		buttonRect = new Rectangle(x, y, width, hieght);
	}
	
	public void drawButton (Graphics g){
		g.setColor(Color.red);
		g.draw(buttonRect);
		g.setColor(Color.white);
		g.drawString(textDisplayedOnButton, x, y); 
		
	}
	
	public boolean isClickable(){
		return stateClickable;
	}
	
	public void setClickable(boolean clickBool){
		stateClickable = clickBool;
	}
	
	public boolean clicked(Input mouseInput){
		if(mouseInput.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
		if(mouseInput.getMouseX() < x + width && mouseInput.getMouseX() > x && mouseInput.getMouseY() < y + hieght && mouseInput.getMouseY() > y){
			return true;
		}
	}
		return false;
	}

}
