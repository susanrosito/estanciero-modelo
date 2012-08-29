/**
 * 24/08/2012 11:39:21 Copyright (C) 2011 10Pines S.R.L.
 */
package tenpines.estanciero;

import java.util.ArrayList;

/**
 * 
 * @author Susana
 */
public class Game {

	private Board board;
	private ArrayList<Player> players;

	/**
	 * 
	 */
	public Game(Board board) {
		this.board = board;
		this.players = new ArrayList<Player>();
	}

	public void begin() {
		while (!(isGameOver())) {
			for (Player player : players) {
				whatOnPlay(player);
			}
		}
	}

	public boolean isGameOver() {
		return false;
	}

	public void whatOnPlay(Player player) {
		player.pullDice();
		Locker lockerInit = lockerOfIndex(player.getPosition());
		ArrayList<Locker> lockerOfWay = this.getBoard().casilleroDesdeHasta(lockerInit, player.getNumberOfDice());
		player.moveTo(lockerOfWay);
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public Locker lockerOfIndex(Integer index) {
		return board.getLockers().get(index);
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
