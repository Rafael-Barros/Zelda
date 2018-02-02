package ie.rbs.auxiliaries;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import ie.rbs.objects.Object;

public class Magic extends Object{

	public Magic(PApplet p) {
		super(p);
	}
	
	public Magic(PApplet p, PImage i){
		super(p,i);
	}

	@Override
	public void display(){
		p.imageMode(p.CENTER);
		p.image(img, getPos().x, getPos().y,getSize().x, getSize().y);
	}
	
	public boolean overlaps(Object o){
		setSides();
		if(this.getLeft() <= o.getRight() && this.getRight() >= o.getLeft() && this.getTop() <= o.getBottom() && this.getBottom() >= o.getTop()){
			return true;
		}else{return false;}
	
	}
}
