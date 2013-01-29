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
	private boolean selected;
	
	public Button (String text, int xpos, int ypos, int sizeX, int sizeY){
		textDisplayedOnButton = text;
		width = sizeX;
		hieght = sizeY;
		x = xpos;
		y = ypos;
		buttonRect = new Rectangle(x, y, width, hieght);
		stateClickable = false;
		selected = false;
	}
	
	public void drawButton (Graphics g){
		if(clickable()){
		g.setColor(Color.red);
		g.draw(buttonRect);
		g.setColor(Color.gray);
		g.drawString(textDisplayedOnButton, x, y);
		if(selected){
			g.drawRect(x, y, width, hieght);
		}
		
		}
		
	}
	
	public boolean clickable(){
		return stateClickable;
	}
	
	public void setClickable(boolean clickBool){
		stateClickable = clickBool;
	}
	
	public boolean clicked(Input mouseInput){
		if(clickable()){
		if(mouseInput.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
		if(mouseInput.getMouseX() < x + width && mouseInput.getMouseX() > x && mouseInput.getMouseY() < y + hieght && mouseInput.getMouseY() > y){
			return true;
		}
	}
		else if(mouseInput.getMouseX() < x + width && mouseInput.getMouseX() > x && mouseInput.getMouseY() < y + hieght && mouseInput.getMouseY() > y){
			selected = true;
			return false;
		}
			
			
		}
		selected = false;
		return false;
	}

}
