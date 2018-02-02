package ie.rbs.objects;

import ie.rbs.auxiliaries.Magic;
import ie.rbs.playZelda.PlayZelda;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Mage extends Hero{
	Magic magic;

	public Mage(PApplet p, PImage i, PImage b, PImage a, PImage f, PImage e){
		super(p, i, b, a, f, e);
		setMagic(new Magic(p, e));
		magic.setPos(new PVector(p.width*2, p.height/2));
		magic.setSize(new PVector((float)(p.width*0.15), (float)(p.height*0.1)));
	}
	
	@Override
	public void display(){
		p.imageMode(p.CENTER);
		p.image(getImg(), getPos().x, getPos().y,getSize().x, getSize().y);
		magic.display();
		magic.moveRight();
	}
	
	@Override
	public void isOut(){
		setSides();
		if(getLeft() < 0){getPos().x = getSize().x/2;}
		if(getPos().x >= (float)(p.width*0.2)){setPos(new PVector((float)(p.width*0.2), getPos().y));}
		if(getTop() < 0){getPos().y = getSize().y/2;}
		if(getBottom() > p.height){getPos().y = p.height - getSize().y/2;}
	}

	@Override
	public void attack() {
		setImg(getBody());
		setSize(new PVector((float)(p.width*0.18), (float)(p.height*0.3)));
		magic.setPos(new PVector(getRight(), getPos().y));
		magic.setVel(new PVector(12,12));
	}

	public Magic getMagic() {return magic;}

	public void setMagic(Magic magic) {this.magic = magic;}
}
