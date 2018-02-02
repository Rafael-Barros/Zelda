package ie.rbs.objects;

import ie.rbs.interfaces.Mover;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Object implements Mover{
	protected PApplet p;
	protected PVector pos, size, vel;
	protected PImage img;
	private float left, right, top, bottom;
	
	public Object(PApplet p){
		setP(p);
		defaultObject();
	}
	
	public Object(PApplet p, PImage i){
		setP(p);
		setImg(i);
		defaultObject();
	}
	
	public void display(){
		p.imageMode(p.CENTER);
		p.image(img, getPos().x, getPos().y,getSize().x, getSize().y);
	}
	
	// INHERITED METHODS //
	
	@Override
	public void moveUp() {
		getPos().y -= getVel().y;
	}

	@Override
	public void moveDown() {
		getPos().y += getVel().y;
	}

	@Override
	public void moveRight() {
		this.pos.x += this.vel.x;
	}

	@Override
	public void moveLeft() {
		getPos().x -= getVel().x;
	}
	
	//    ON  FLY    //
	
	public void isOut(){
		setSides();
		if(getLeft() < 0){getPos().x = getSize().x/2;}
		if(getPos().x >= (float)(p.width*0.74)){setPos(new PVector((float)(p.width*0.74), getPos().y));}
		if(getTop() < 0){getPos().y = getSize().y/2;}
		if(getBottom() > p.height){getPos().y = p.height - getSize().y/2;}
	}
	
	public void changeDirection(){
		getVel().y *= -1;
	}
	
	public boolean hitEdges(){
		setSides();
		if(left < 0 || right > p.width || top < 0 || bottom > p.height) {return true;}
		else {return false;}
	}
	
	public void setSides(){
		left = getPos().x - getSize().x/2;
		right = getPos().x + getSize().x/2;
		top = getPos().y - getSize().y/2;
		bottom = getPos().y + getSize().y/2;
	}
	
	public boolean isHovered(){
		setSides();
		if(p.mouseX >= left && p.mouseX <= right && p.mouseY <= bottom && p.mouseY >= top) {return true;}
		else {return false;}
	}
	
	public boolean isClicked(){
		if(this.isHovered() && p.mousePressed) {return true;}
		return false;
	}
	
	// MAKES A WHITE TRANSPARENT RECTANGLE OVER THE IMAGE
	public void applyMask(){
		setSides();
		p.noStroke();
		p.fill(255, 100);
		p.rect(getPos().x, getPos().y, getSize().x, getSize().y);
	}
	
	public void defaultObject(){
		setPos(new PVector(p.width/2, p.height/2));
		setSize(new PVector((float)(p.width*0.1), (float)(p.height*0.35)));
		setVel(new PVector(5,5));
		setSides();
	}

	//  GETTERS AND SETTERS  //

	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public PVector getPos() {return pos;}

	public void setPos(PVector pos) {this.pos = pos;}

	public PVector getSize() {return size;}

	public void setSize(PVector size) {this.size = size;}

	public PImage getImg() {return img;}

	public void setImg(PImage img) {this.img = img;}

	public float getLeft() {return left;}

	public void setLeft(float left) {this.left = left;}

	public float getRight() {return right;}

	public void setRight(float right) {this.right = right;}

	public float getTop() {return top;}

	public void setTop(float top) {this.top = top;}

	public float getBottom() {return bottom;}

	public void setBottom(float bottom) {this.bottom = bottom;}

	public PVector getVel() {return vel;}

	public void setVel(PVector vel) {this.vel = vel;}
}
