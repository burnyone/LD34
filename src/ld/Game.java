package ld;

import java.awt.Color;

import ld.render.Render;
import ld.util.Constants;
import ld.util.Rectangle;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Game {
	private Render render;
	
	public Game(){
		render = new Render();
	}
	
	public void begin() {
		System.out.println("[OpenGL] Version: " + GL11.glGetString(GL11.GL_VERSION));
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Constants.WIDTH, Constants.HEIGHT, 0f, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	private int x = 0;
	public void tick() {
		x++;
	}
	
	public void draw() {
		GL11.glClearColor(1f, 0f, 0f, 1f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(x, 0, 0);
		render.drawRectangle(new Rectangle(10, 10, 100, 100), new Color(1.0f, 0.0f, 1.0f));
		GL11.glPopMatrix();
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
