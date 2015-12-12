package ld.game;

import org.lwjgl.util.vector.Vector2f;

public class Universe {
	private boolean isUnlocked;
	private Vector2f locationOnMenu;
	
	public Universe(Vector2f location){
		locationOnMenu = location;
		isUnlocked = false;
	}
	
	public Vector2f getLocationOnMenu(){
		return locationOnMenu;
	}
	
	public void setLocationOnMenu(Vector2f vector){
		this.locationOnMenu = vector;
	}
	
	public boolean isUnlocked(){
		return isUnlocked;
	}
	public void setUnlocked(boolean unlocked){
		this.isUnlocked = unlocked;
	}
	
	
}
