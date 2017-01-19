package pl.bonusplay.libgdxbase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.bonusplay.libgdxbase.handlers.GameStateManager;

public class Game extends ApplicationAdapter
{
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private GameStateManager gsm;
	private AssetManager res;

	@Override
	public void create()
	{
		cam = new OrthographicCamera();
		sb = new SpriteBatch();
		res = new AssetManager();
		gsm = new GameStateManager(this);
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.setTitle(Reference.TITLE + " - FPS: " + Gdx.graphics.getFramesPerSecond() + " STATE: " + gsm.getCurrentState());

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render();
	}

	@Override
	public void dispose()
	{
		sb.dispose();
		res.dispose();
	}

	public SpriteBatch getSpriteBatch()
	{
		return sb;
	}

	public OrthographicCamera getCamera()
	{
		return cam;
	}

	public AssetManager getAssetManager()
	{
		return res;
	}
}