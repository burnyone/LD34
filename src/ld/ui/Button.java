package ld.ui;

import java.util.ArrayList;
import java.util.List;

import ld.render.Text;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

public class Button {
	private Text text;
	private boolean hovering = false;
	
	public static List<Button> buttons = new ArrayList<Button>();
	
	public Button(String path, Vector2f position){
		this.text = new Text(path, position);
		buttons.add(this);
	}
	
	public Button(Text text){
		this.text = text;
		buttons.add(this);
	}
	
	public void update(){
		float mouseX = Mouse.getX();
		float mouseY = Mouse.getY();
		if(mouseX / 2 > text.getTexture().getX() && 
		   mouseX / 2 < text.getTexture().getX() + text.getTexture().getWidth()){
			if(mouseY  > text.getTexture().getY() && 
			   mouseY  < text.getTexture().getY() + text.getTexture().getHeight()){
				hovering = true;
			} else {
				hovering = false;
			}
		} else {
			hovering = false;
		}
	}
	
	public void draw(){
		text.draw();
	}
	
	public boolean isHovering(){
		return hovering;
	}
	
	
}
