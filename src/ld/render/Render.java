package ld.render;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import ld.util.Constants;
import ld.util.Rectangle;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Render {
	public Render() {
		initalize();
	}
	
	public void initalize() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Constants.WIDTH, 0, Constants.HEIGHT, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_BLEND);
	}

	
	public void drawRectangle(Rectangle rect, Color color) {
		GL11.glColor3f(color.getRed(), color.getBlue(), color.getGreen());
		GL11.glBegin(GL11.GL_QUADS);
		{
			Vector2f position = rect.getPosition();
			Vector2f size = rect.getSize();
			GL11.glVertex2f(position.x, position.y);
			GL11.glVertex2f(position.x, position.y + size.y);
			GL11.glVertex2f(position.x + size.x, position.y + size.y);
			GL11.glVertex2f(position.x + size.x, position.y);	
		}
		GL11.glEnd();
	}
}
