package ld.render;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.util.ResourceLoader;


public class Texture {
	private int id;
	private int w, h;
	
	private int vertexList;
	org.newdawn.slick.opengl.Texture texture;
	private Vector2f position;
	
	public Texture(String path, Vector2f pos){
		load(path, pos);
	}
	public void load(String path, Vector2f position){
		org.newdawn.slick.opengl.Texture internalTexture = null;
		try {
			internalTexture = org.newdawn.slick.opengl.TextureLoader.getTexture("PNG", 
					ResourceLoader.getResourceAsStream(path));	
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.w = internalTexture.getImageWidth();
		this.h = internalTexture.getImageHeight();
		
		this.id = internalTexture.getTextureID();
		
		this.vertexList = GL11.glGenLists(1);
		this.position = position;

		GL11.glNewList(this.vertexList, GL11.GL_COMPILE);
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(position.x,position.y);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(position.x+w,position.y);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(position.x+w,position.y+h);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(position.x,position.y+h);
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glEndList();
	}
	
	public void bind(){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, id);
	}
	
	public void unbind(){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}
	
	public void draw(){
		bind();
		GL11.glCallList(this.vertexList);
		unbind();
	}
	
	public void draw(Vector2f position){
		bind();
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(position.x,position.y);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(position.x+w,position.y);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(position.x+w,position.y+h);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(position.x,position.y+h);
		GL11.glEnd();
		GL11.glPopMatrix();
		unbind();
	}
	
	public void draw(float x, float y){
		bind();
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(x,y);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(x+w,y);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(x+w,y+h);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(x,y+h);
		GL11.glEnd();
		GL11.glPopMatrix();
		unbind();
	}
	
	public float getX(){
		return position.x;
	}
	
	public float getY(){
		return position.y;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight(){
		return h;
	}
	
	public int getID(){
		return id;
	}
}
