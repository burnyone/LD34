package ld;

import ld.game.GalaxySelectionMenu;
import ld.render.Render;
import ld.render.Texture;
import ld.util.Constants;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Game {
	
	private enum GameState {
		IN_GALAXY_MENU,
		IN_GALAXY,
		PAUSED,
	}
	
	@SuppressWarnings("unused")
	private Render render;
	private GalaxySelectionMenu uniMenu;
	
	private GameState state = GameState.IN_GALAXY_MENU;
	
	public Game(){
		render = new Render();
		uniMenu = new GalaxySelectionMenu();
	}
	
	public void begin() {
		System.out.println("[OpenGL] Version: " + GL11.glGetString(GL11.GL_VERSION));
		
	}

	public void tick() {
		uniMenu.tick();
	}
	
	public void draw() {
		GL11.glClearColor(50 / 255, 60 / 255, 70 / 255, 1f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		uniMenu.draw();
		new Texture("assets/star_main_sequence.png", new Vector2f(0, 0)).draw();
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
