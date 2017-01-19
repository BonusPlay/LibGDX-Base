package pl.bonusplay.libgdxbase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import pl.bonusplay.libgdxbase.Reference;
import pl.bonusplay.libgdxbase.handlers.GameStateManager;

public class Menu extends GameState
{
	private Texture tex;

	public Menu(GameStateManager gsm)
	{
		super(gsm);

		res.load("badlogic.jpg", Texture.class);
		res.finishLoading();	// forces assets to load sync

		tex = res.get("badlogic.jpg", Texture.class);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void handleInput()
	{}

	@Override
	public void update(float dt)
	{
		handleInput();
	}

	@Override
	public void render()
	{
		sb.setProjectionMatrix(cam.combined);

		sb.begin();
		sb.end();
	}

	@Override
	public void dispose()
	{
		tex.dispose();
	}
}
