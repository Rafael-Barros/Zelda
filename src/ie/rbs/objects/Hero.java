package ie.rbs.objects;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Hero extends Creature{
	
	public Hero(PApplet p){
		super(p);
	}
	
	public Hero(PApplet p, PImage i, PImage b, PImage a, PImage f, PImage e){
		super(p, i, b, a, f, e);
	}
	
	public abstract void attack();
		
}
