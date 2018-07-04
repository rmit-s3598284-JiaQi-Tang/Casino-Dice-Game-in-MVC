package model;

import model.interfaces.DicePair;

public class DicePairImpl implements DicePair {
	private int dice1;
	private int dice2;
	private int numFaces;

	public DicePairImpl(int dice1, int dice2, int numFaces) {
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;

	}

	@Override
	public int getDice1() {
		return dice1;
	}

	@Override
	public int getDice2() {
		return dice2;
	}

	@Override
	public int getNumFaces() {
		return numFaces;
	}

	public String toString() {
		int total = dice1 + dice2;
		StringBuilder sb = new StringBuilder();
		sb.append(" dice1: " + dice1);
		sb.append(" dice2: " + dice2);
		sb.append(" .. Total: " + total);
		return sb.toString();
	}
}
