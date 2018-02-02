package ie.rbs.objects;

import ie.rbs.auxiliaries.Magic;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Villain extends Creature{
	Magic magic;

	public Villain(PApplet p){
		super(p);
		setMagic(null);
	}
	
	public Villain(PApplet p, PImage i, PImage b, PImage a, PImage f, PImage e){
		super(p, i, b, a, f, e);
		setMagic(new Magic(p, a));
		magic.setSize(new PVector((float)(p.width*0.20), (float)(p.height*0.2)));
		magic.setPos(new PVector(getPos().x + magic.getSize().x, getPos().y));
		magic.setVel(new PVector(20, 20));
	}

	@Override
	public void attack() {
		magic.display();
		magic.moveLeft();
	}
	
	public void summomMagic(){
		if(getMagic().getPos().x < 0 - getMagic().getSize().x/2){
			getMagic().setPos(new PVector(getLeft(), getPos().y));
		}
	}
	
	public void move(){
		if(this.hitEdges()) {this.changeDirection();}
		moveUp();
	}
	
	public void transform(PImage i){
		this.setImg(i);
	}

	public Magic getMagic() {return magic;}

	public void setMagic(Magic magic) {this.magic = magic;}

}
