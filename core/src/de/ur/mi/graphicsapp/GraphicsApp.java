package de.ur.mi.graphicsapp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import de.ur.mi.graphics.GraphicsObject;

import java.io.File;
import java.net.URL;
import java.util.WeakHashMap;

public class GraphicsApp extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture img;

    private WeakHashMap<GraphicsObject, GraphicsObject> graphicsObjects;

    public int canvasWidth;
    public int canvasHeight;

	///////////////////////////////////////////////////////////////////////////

	// Lifecycle methods inherited from ApplicationAdapter

	///////////////////////////////////////////////////////////////////////////

	@Override
	public void create () {
        graphicsObjects = new WeakHashMap<GraphicsObject, GraphicsObject>();

        batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

        setup();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

        draw();
	}

	@Override
    public void resize(int width, int height) {
        this.canvasWidth = width;
        this.canvasHeight = height;
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

    ///////////////////////////////////////////////////////////////////////////

    // Interface for GraphicsObject management

    ///////////////////////////////////////////////////////////////////////////

    public void addObject(GraphicsObject object) {
        graphicsObjects.put(object, object);
    }

    public void removeObject(GraphicsObject object) {
        graphicsObjects.remove(object);
    }

    public void removeAllObjects() {
        graphicsObjects.clear();
    }

	///////////////////////////////////////////////////////////////////////////

	// Interface for Exercises

	///////////////////////////////////////////////////////////////////////////

	/**
	 * Contains the code to be executed, ONCE, on start of the program. If you
	 * are defining your own GraphicsApp class, you need to override the
	 * definition of setup so that it contains the code for your application.
	 */
	public void setup() {

	}

    /**
     * Contains the code to be executed, REPEATEDLY, during execution of the
     * program. Override this method to animate graphical graphicsObjects.
     */
	public void draw() {

	}

    /**
     * Loads a file from source directory.
     *
     * @param path Path to file, relative to 'src' directory
     * @return A File object
     */
    public File loadFile(String path) {
        URL base = GraphicsApp.class.getResource(path);
        return new File(base.getFile());
    }

    public int getWidth(){
        return canvasWidth;
    }

    public int getHeight(){
        return canvasHeight;
    }
}
