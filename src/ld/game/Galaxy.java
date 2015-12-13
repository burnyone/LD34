package ld.game;

import org.lwjgl.util.vector.Vector2f;

public class Galaxy {
	private boolean isUnlocked;
	private Vector2f locationOnMenu;
	private int id;
	
	public Galaxy(Vector2f location, int id){
		locationOnMenu = location;
		isUnlocked = false;
		this.id = id;
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
	public int getID(){
		return id;
	}
	
	
}
