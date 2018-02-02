package ie.rbs.screens;

import ie.rbs.playZelda.PlayZelda;
import ie.rbs.objects.Object;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Ending extends PlayZelda{
	PApplet p;
	PImage background, hero;
	String message;
	Object button;
	
	public Ending(PApplet p){
		setP(p);
		setBackground(zeldaCastleImg);
		setHero(null);
		message = " ";
		setButton(new Object(p, tryAgainImg));
		button.setPos(new PVector((float)(p.width*0.7), (float)(p.height*0.6)));
		button.setSize(new PVector((float)(p.width*0.4), (float)(p.height*0.15)));
		Fight.setTransformed(false);
	}
	
	public void display(){
		p.imageMode(p.CENTER);
		
		updateBackground();
		updateFace();
		updateButton();
		updateMessage();
		tryAgain();
	}
	
	//  ON   FLY  //
	
	public void updateButton(){
		p.fill(255);
		p.textSize(100);
		p.text(message, (float)(p.width*0.5), (float)(p.height*0.45));
		button.display();
	}
	
	public void updateBackground(){
		p.image(background, (float)(p.width*0.5), p.height/2, p.width, p.height);
	}
	
	public void updateFace(){
		if(player.getLife() == 0) {setHero(skullImg);}
		if(player.getLife() > 0) {setHero(player.getFace());}
		p.image(hero, (float)(p.width*0.2), p.height/2, 200, 300);
	}
	
	public void tryAgain(){
		button.setSides();
		p.imageMode(p.CENTER);
		if(button.isHovered()) {button.applyMask();}
		if(button.isClicked()) {restart();}
	}
	
	public void updateMessage(){
		button.setSides();
		p.imageMode(p.CENTER);
		if(player.getLife() <= 0) {message = "You Lost";}
		else if(player.getLife() > 0) {message = "You Won";}
	}
	
	// GETTERS AND SETTERS //

	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public PImage getHero() {return hero;}

	public void setHero(PImage hero) {this.hero = hero;}

	public String getMessage() {return message;}

	public void setMessage(String message) {this.message = message;}

	public PImage getBackground() {return background;}

	public void setBackground(PImage background) {this.background = background;}

	public Object getButton() {return button;}

	public void setButton(Object button) {this.button = button;}
	
}
