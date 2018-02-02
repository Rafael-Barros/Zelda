package ie.rbs.auxiliaries;

import ie.rbs.objects.Creature;
import processing.core.PApplet;
import processing.core.PVector;

public class ShowInfo {
	PApplet p;
	private PVector pos, size;
	private Creature creature;
	
	public ShowInfo(Creature c){
		setP(c.getP());
		setCreature(c);
		defaultShowInfo();
	}
	
	public void display(){
		rectangle();
		showName();
		showType();
		showLife();
		showAttPower();
	}
	
	public void showAttPower(){
		p.fill(0);
		p.textSize(30);
		p.text("Power: ", getPos().x - getSize().x/2, getPos().y + (float)(getSize().y*0.35));
		p.text(creature.getPower(), getPos().x - (float)(getSize().x*0.1), getPos().y + (float)(getSize().y*0.35));
	}
	
	public void showLife(){
		p.fill(0);
		p.textSize(30);
		p.text("Life: ", getPos().x - getSize().x/2, getPos().y + (float)(getSize().y*0.1));
		p.text(creature.getLife(), getPos().x - (float)(getSize().x*0.1), getPos().y + (float)(getSize().y*0.1));
	}
	
	public void showType(){
		p.fill(0);
		p.textSize(30);
		p.text("Type: ", getPos().x - getSize().x/2, getPos().y - (float)(getSize().y*0.15));
		p.text(creature.getType(), getPos().x - (float)(getSize().x*0.1), getPos().y - (float)(getSize().y*0.15));
	}
	
	public void showName(){
		p.fill(0);
		p.textSize(40);
		p.text(creature.getName(), getPos().x - getSize().x/2, getPos().y - (float)(getSize().y*0.35));
	}
	
	public void rectangle(){
		p.rectMode(p.CENTER);
		p.fill(255, 100);
		p.noStroke();
		p.rect(getPos().x, getPos().y, getSize().x, getSize().y);
	}
	
	public void defaultShowInfo(){
		setPos(new PVector((float)(p.width*0.5), (float)(p.height*0.6)));
		setSize(new PVector((float)(p.width*0.3), (float)(p.height*0.5)));
	}
	
	// GETTERS AN SETTERS //

	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public PVector getPos() {return pos;}

	public void setPos(PVector pos) {this.pos = pos;}

	public PVector getSize() {return size;}

	public void setSize(PVector size) {this.size = size;}

	public Creature getCreature() {return creature;}

	public void setCreature(Creature creature) {this.creature = creature;}

}
