package ld.util;

import org.lwjgl.util.vector.Vector2f;

public class Rectangle {
	private Vector2f position;
	private Vector2f size;
	
	public Rectangle(Vector2f position, Vector2f size) {
		this.position = position;
		this.size = size;
	}
	
	public Rectangle(Vector2f position, float size) {
		this.position = position;
		this.size = new Vector2f(size, size);
	}
	
	public Rectangle(float x, float y, float w, float h) {
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
	}
	
	public Rectangle() {
		this.position = new Vector2f();
		this.size = new Vector2f();
	}
	
	public Vector2f getPosition() {
		return position;
	}
	
	public Vector2f getSize() {
		return size;
	}
	
	public void setSize(Vector2f size) {
		this.size = size;
	}
	
	public void setWidth(float w){
		this.size.x = w;
	}
	
	public void setHeight(float h){
		this.size.y = h;
	}
	
	public void increasePosition(Vector2f newPos){
		Vector2f.add(this.position, newPos, this.position);
	}
	
	public void increaseSize(Vector2f newSize) {
		Vector2f.add(this.size, newSize, this.size);
	}
}
