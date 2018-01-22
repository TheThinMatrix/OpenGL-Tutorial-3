package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * Handles the rendering of a model to the screen.
 * 
 * @author Karl
 *
 */
public class Renderer {

	/**
	 * This method must be called each frame, before any rendering is carried
	 * out. It basically clears the screen of everything that was rendered last
	 * frame (using the glClear() method). The glClearColor() method determines
	 * the colour that it uses to clear the screen. In this example it makes the
	 * entire screen red at the start of each frame.
	 */
	public void prepare() {
		GL11.glClearColor(1, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}

	/**
	 * Renders a model to the screen.
	 * 
	 * Before we can render a VAO it needs to be made active, and we can do this
	 * by binding it. We also need to enable the relevant attributes of the VAO,
	 * which in this case is just attribute 0 where we stored the position data.
	 * 
	 * The VAO can then be rendered to the screen using glDrawElements(). Using
	 * this draw method tells OpenGL that we want to use the index buffer to
	 * determine how the vertices should be connected instead of just connecting
	 * the vertices together in the order that they are stored in the VAO.
	 * 
	 * We tell it what type of shapes to render and the number of vertices that
	 * it needs to render. We also tell it was format the index data is in (we
	 * used ints) and finally we indicate where in the index buffer it should
	 * start rendering. We want it to start right at the beginning and render
	 * everything, so we put 0.
	 * 
	 * After rendering we unbind the VAO and disable the attribute.
	 * 
	 * @param model
	 *            - The model to be rendered.
	 */
	public void render(RawModel model) {
		GL30.glBindVertexArray(model.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}

}
