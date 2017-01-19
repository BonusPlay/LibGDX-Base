package pl.bonusplay.libgdxbase.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.Input;
import pl.bonusplay.libgdxbase.Reference;
import pl.bonusplay.libgdxbase.handlers.GameStateManager;

public class Loading extends GameState
{
	public Loading(GameStateManager gsm)
	{
		super(gsm);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void handleInput()
	{
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
			gsm.setGameState(Reference.GameStates.MENU);
	}

	@Override
	public void update(float dt)
	{
		handleInput();

		tm.update(dt);
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
	{}
}