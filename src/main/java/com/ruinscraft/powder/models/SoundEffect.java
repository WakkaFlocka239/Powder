package com.ruinscraft.powder.models;

import org.bukkit.Location;
import org.bukkit.Sound;

import com.ruinscraft.powder.PowdersCreationTask;

public class SoundEffect implements PowderElement {

	// Sound enum associated with this SoundEffect
	private Sound sound;
	// volume for this SoundEffect
	private double volume;
	// pitch for this SoundEffect (noteblock values)
	private double pitch;
	// when to start displaying this SoundEffect
	private int startTime;
	// after how many ticks should it repeat?
	private int repeatTime;
	// set maximum iterations (0 if infinite)
	private int lockedIterations;
	// the next tick to iterate
	private int nextTick;

	// iterations so far
	private int iterations;

	public SoundEffect(SoundEffect soundEffect) {
		this.sound = soundEffect.getSound();
		this.volume = soundEffect.getVolume();
		this.pitch = soundEffect.getPitch();
		this.startTime = soundEffect.getStartTime();
		this.repeatTime = soundEffect.getRepeatTime();
		this.lockedIterations = soundEffect.getLockedIterations();
		this.nextTick = PowdersCreationTask.getCurrentTick() + startTime;
		this.iterations = 0;
	}

	public SoundEffect(Sound sound, double volume, double pitch, 
			int startTime, int repeatTime, int lockedIterations) {
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
		this.startTime = startTime;
		this.repeatTime = repeatTime;
		this.lockedIterations = lockedIterations;
		this.iterations = 0;
	}

	public Sound getSound() {
		return sound;
	}

	public double getVolume() {
		return volume;
	}

	public double getPitch() {
		return pitch;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getRepeatTime() {
		return repeatTime;
	}

	public int getLockedIterations() {
		return lockedIterations;
	}

	public void setLockedIterations(int lockedIterations) {
		this.lockedIterations = lockedIterations;
	}

	public int getIterations() {
		return iterations;
	}

	public void iterate() {
		iterations++;
		this.nextTick = PowdersCreationTask.getCurrentTick() + getRepeatTime();
	}

	public int getNextTick() {
		return nextTick;
	}

	public SoundEffect clone() {
		return new SoundEffect(this);
	}

	// creates this SoundEffect at the designated location
	public void create(Location location) {
		location.getWorld().playSound(location, sound, (float) volume, (float) pitch);
	}

}
