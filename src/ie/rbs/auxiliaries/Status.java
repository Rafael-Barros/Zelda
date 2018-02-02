package ie.rbs.auxiliaries;

import ie.rbs.objects.Creature;
import processing.core.PApplet;
import processing.core.PVector;

public class Status {
	PApplet p;
	PVector pos, size;
	Creature c;
	
	public Status(Creature c){
		setP(c.getP());
		setC(c);
		defaultStatus();
	}
	
	public void display(){
		showFace();
		showName();
		showLife();
	}
	
	//   ON   FLY   //
	
	public void showLife(){
		p.rectMode(p.CORNER);
		p.fill(p.color(255, 50, 50, 200));
		p.rect(this.pos.x + (float)(this.size.x*0.25) , this.pos.y + (float)(this.size.y*0.2), 
				c.getBase(), (float)(p.height*0.1), 20);
		p.fill(p.color(50, 255, 50, 200));
		p.rect(this.pos.x + (float)(this.size.x*0.25) , this.pos.y + (float)(this.size.y*0.2), 
				c.getLife(), (float)(p.height*0.1), 20);
	}
	
	public void showFace(){
		p.imageMode(p.CORNER);
		p.image(c.getFace(), this.pos.x, this.pos.y, (float)(this.size.x*0.2), (float)(this.size.y));
	}
	
	public void showName(){
		p.fill(255);
		p.textSize(25);
		p.text(c.getName(),  this.pos.x + (float)(this.size.x*0.25), this.pos.y + (float)(this.size.y*0.925));
	}
	
	public void defaultStatus(){
		setPos(new PVector((float)(p.width*0.0001), (float)(p.height*-0.01)));
		setSize(new PVector((float)(p.width*0.4), (float)(p.height*0.22)));
	}
	
	//  GETTERS AND SETTERS  //

	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public PVector getPos() {return pos;}

	public void setPos(PVector pos) {this.pos = pos;}

	public PVector getSize() {return size;}

	public void setSize(PVector size) {this.size = size;}

	public Creature getC() {return c;}

	public void setC(Creature c) {this.c = c;}
}
