package com.ruinscraft.powder.models;

import java.util.ArrayList;
import java.util.List;

public class Layer {

	// list of rows containing PowderParticles; the matrix itself
	private List<List<PowderParticle>> rows;
	// the front-back position of the Layer
	private int position;

	public Layer() {
		this.rows = new ArrayList<List<PowderParticle>>();
		position = 0;
	}

	public Layer(List<List<PowderParticle>> rows, int position) {
		this.rows = rows;
		this.position = position;
	}

	public List<List<PowderParticle>> getRows() {
		return rows;
	}

	public void setRows(List<List<PowderParticle>> rows) {
		this.rows = rows;
	}

	public void addRows(List<List<PowderParticle>> rows) {
		this.rows.addAll(rows);
	}

	public void addRow(List<PowderParticle> row) {
		rows.add(row);
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
