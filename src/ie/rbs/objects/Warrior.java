package ie.rbs.objects;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Warrior extends Hero{

	public Warrior(PApplet p) {
		super(p);
	}
	
	public Warrior(PApplet p, PImage i, PImage b, PImage a, PImage f, PImage e){
		super(p, i, b, a, f, e);
	}

	@Override
	public void attack() {
		setImg(getBody());
		setSize(new PVector((float)(p.width*0.18), (float)(p.height*0.3)));
	}
}
