package ld.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Text {
	private Texture texture;
	
	public Text(String path, Vector2f position){
		texture = new Texture("assets/text/" + path + ".png", position);
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
	
	}
	
	public void draw(){
		texture.draw();
	}
	
	public Texture getTexture(){
		return texture;
	}
}
