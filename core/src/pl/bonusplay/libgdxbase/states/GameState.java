package pl.bonusplay.libgdxbase.states;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.bonusplay.libgdxbase.Game;
import pl.bonusplay.libgdxbase.handlers.GameStateManager;

public abstract class GameState
{
	protected GameStateManager gsm;
	protected Game game;

	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	protected AssetManager res;

	protected GameState(GameStateManager gsm)
	{
		this.gsm = gsm;
		this.game = gsm.getGame();
		this.sb = game.getSpriteBatch();
		this.cam = game.getCamera();
		this.res = game.getAssetManager();
	}

	public abstract void handleInput();

	public abstract void update(float dt);

	public abstract void render();

	public abstract void dispose();
}
