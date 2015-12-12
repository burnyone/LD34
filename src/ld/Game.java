package ld;

import ld.util.*;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

public class Game {
	public Game(){
	}
	
	public void begin() {
		System.out.println("[OpenGL] Version: " + GL11.glGetString(GL11.GL_VERSION));
	}
	
	public void tick() {
		
	}
	
	public void draw() {
		
	}
	
	public void terminate() {
		
	}
	
	public static void main(String args []){
		try {
			Display.setDisplayMode(new DisplayMode(Constants.WIDTH, Constants.HEIGHT));
			Display.setTitle(Constants.TITLE);
			Display.create();
		} catch(LWJGLException e){
			e.printStackTrace();
		}
		
		Game game = new Game();
		game.begin();
		while(!Display.isCloseRequested()){
			Display.sync(Constants.FPS);
			game.tick();
			game.draw();
			Display.update();
		}
		
		game.terminate();
		
	}
}
