package ld.util;

import org.lwjgl.util.vector.Vector2f;


public class RenderUtil {
	public static float centerWindowWidth(float width, int scale) {
		return (Constants.WIDTH / scale) / 2 - (width / 2);
	}
	
	public static float centerWindowHeight(float height, int scale) {
		return (Constants.HEIGHT / scale) / 2 - (height / 2);
	}
	
	public static Vector2f centerOnWindow(Vector2f size, int scale) {
		return new Vector2f(centerWindowWidth(size.x, scale), centerWindowHeight(size.y, scale));
	}
}
