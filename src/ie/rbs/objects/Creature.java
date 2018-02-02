package ie.rbs.objects;

import processing.core.PApplet;
import processing.core.PImage;
import ie.rbs.auxiliaries.ShowInfo;
import ie.rbs.auxiliaries.Status;
import ie.rbs.objects.Object;

public abstract class Creature extends Object{
	String name, type;
	int life, power, base;
	PImage body, attBody, face, extra;
	Status status;
	ShowInfo info;

	public Creature(PApplet p) {
		super(p);
		setBody(null);
		setAttBody(null);
		setFace(null);
		setExtra(null);
		defaultCreature();
	}
	
	public Creature(PApplet p, PImage i, PImage b, PImage a, PImage f, PImage e){
		super(p, i);
		setBody(b);
		setAttBody(a);
		setFace(f);
		setExtra(e);
		defaultCreature();
		setStatus(new Status(this));
		setInfo(new ShowInfo(this));
		
	}
	
	//   ON   FLY   //
	
	public abstract void attack();
	
	public boolean isDead(){
		if(this.life <= 0) {return true;}
		else {return false;}
	}
	
	public void loseLife(int damage){
		this.life -= damage;
		if(this.isDead()) {setLife(0);}
	}
	
	public void defaultCreature(){
		setName("My Name");
		setType("My Type");
		setBase(100);
		setLife(100);
		setPower(5);
	}
	
	//  GETTERS AND SETTERS  //

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getType() {return type;}

	public void setType(String type) {this.type = type;}

	public int getLife() {return life;}

	public void setLife(int life) {this.life = life;}

	public int getPower() {return power;}

	public void setPower(int power) {this.power = power;}

	public PImage getBody() {return body;}

	public void setBody(PImage body) {this.body = body;}

	public PImage getAttBody() {return attBody;}

	public void setAttBody(PImage attBody) {this.attBody = attBody;}

	public PImage getFace() {return face;}

	public void setFace(PImage face) {this.face = face;}

	public PImage getExtra() {return extra;}

	public void setExtra(PImage extra) {this.extra = extra;}

	public Status getStatus() {return status;}

	public void setStatus(Status status) {this.status = status;}

	public int getBase() {return base;}

	public void setBase(int base) {this.base = base;}

	public ShowInfo getInfo() {return info;}

	public void setInfo(ShowInfo info) {this.info = info;}

}
