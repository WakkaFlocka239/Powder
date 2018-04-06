package com.ruinscraft.powder.models;

import org.bukkit.Location;

public interface PowderElement {

	void create(Location location); // create this element at this location
	
	Integer getStartTime(); // what tick to start at

	Integer getRepeatTime(); // iterate after how many ticks

	Integer getIterations(); // how many times to iterate; 0 if unlimited
	
	void setIterations(int iteration); // set how many times to iterate

}