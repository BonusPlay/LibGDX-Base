package pl.bonusplay.libgdxbase.handlers;

import pl.bonusplay.libgdxbase.Reference;
import pl.bonusplay.libgdxbase.Game;
import pl.bonusplay.libgdxbase.states.GameState;
import pl.bonusplay.libgdxbase.states.Loading;
import pl.bonusplay.libgdxbase.states.Menu;

import java.util.Stack;

public class GameStateManager
{
	private Game game;

	private Stack<GameState> gameStates;

	public GameStateManager(Game game)
	{
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(Reference.GameStates.LOADING);
	}

	public void update(float dt)
	{
		gameStates.peek().update(dt);
	}

	public void render()
	{
		gameStates.peek().render();
	}

	public Game getGame()
	{
		return game;
	}

	public int getCurrentState()
	{
		String state = gameStates.peek().getClass().getSimpleName();
		// TODO: make this into a nice switch?
		if(state.equalsIgnoreCase("Loading"))
			return Reference.GameStates.LOADING;
		if(state.equalsIgnoreCase("Menu"))
			return Reference.GameStates.MENU;

		return 0;
	}

	public GameState getState(int state)
	{
		switch(state)
		{
			case Reference.GameStates.LOADING:
				return new Loading(this);
			case Reference.GameStates.MENU:
				return new Menu(this);
			default:
				return null;
		}
	}

	public void setGameState(int state)
	{
		popState();
		pushState(state);
	}

	private void pushState(int state)
	{
		gameStates.push(getState(state));
	}

	private void popState()
	{
		GameState g = gameStates.pop();
		g.dispose();
	}
}