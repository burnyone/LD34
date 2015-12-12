package ld.game;

import java.util.ArrayList;
import java.util.List;

import ld.render.Texture;
import ld.util.Constants;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

public class UniverseSelectionMenu {
	private Texture universe;
	private Texture space;
	private Texture notUnlocked;
	
	private List<Universe> universes = new ArrayList<Universe>();
	
	public UniverseSelectionMenu(){
		universe = new Texture("assets/universe1.png", new Vector2f());
		space = new Texture("assets/plain_space.png", new Vector2f());
		notUnlocked = new Texture("assets/not_unlocked_universe.png", new Vector2f());
	
		for(int x = 128 / 2 + (128 / 10); x < Constants.WIDTH - 128; x += 128 * 2) {
			for(int y = 128; y < Constants.HEIGHT - 128; y += 128 * 2) {
				universes.add(new Universe(new Vector2f(x, y)));
			}
		}
		
		universes.get(1).setUnlocked(true);
	}
	
	public void draw(){
		for(int x = 0; x < Constants.WIDTH; x += 128){
			for(int y = 0; y < Constants.HEIGHT; y += 128) {
				space.draw(x, y);
			}
		}
		
		for(Universe u : universes) {
			universe.draw(u.getLocationOnMenu());
			if(!u.isUnlocked())
				notUnlocked.draw(u.getLocationOnMenu().x, u.getLocationOnMenu().y);
		}
	}
	
	public void tick(){
		int mx = Mouse.getX();
		int my = Mouse.getY();
		
		for(Universe u : universes) {
			if(mx > u.getLocationOnMenu().x && mx < u.getLocationOnMenu().x + 128) {
				if(my > u.getLocationOnMenu().y && my < u.getLocationOnMenu().y + 128)
					if(Mouse.isButtonDown(0))
						u.setUnlocked(true);
				}
			}
		}
	}

