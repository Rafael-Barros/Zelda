package ie.rbs.screens;

import processing.core.PApplet;
import processing.core.PVector;
import ie.rbs.objects.Object;
import ie.rbs.playZelda.PlayZelda;

public class Menu extends PlayZelda{
	PApplet p;
	Object startButton;
	Object exitButton;
	Object shield;
	
	public Menu(PApplet p){
		setP(p);
		setStartButton(new Object(p, startButtonImg));
		setExitButton(new Object(p, exitButtonImg));
		setShield(new Object(p, shieldImg));
		defaultMenu();
	}
	
	public void display(){
		p.background(50);
	
		startButton.display();
		exitButton.display();
		shield.display();
	
		updateMenu();
	}
	
	//   ON   FLY   //
	
	public void updateMenu(){
		updateStartButton();
		updateExitButton();
	}
	
	public void updateExitButton(){
		if(exitButton.isHovered()) {exitButton.applyMask();}
	}
	
	public void mouseClicked(){
		if(!startClicked && startButton.isHovered()){
			setStartClicked(startClicked);
		}
	}
	
	public void updateStartButton(){
		if(startButton.isHovered()) {startButton.applyMask();}
		if(startButton.isClicked()) {setStartClicked(true);}
	}
	
	public void defaultMenu(){
		shield.setPos(new PVector((float)(p.width*0.2), (float)(p.height*0.5)));
		shield.setSize(new PVector((float)(p.width*0.3), (float)(p.height*0.65)));
		
		startButton.setPos(new PVector((float)(p.width*0.65), (float)(p.height*0.4)));
		startButton.setSize(new PVector((float)(p.width*0.18), (float)(p.height*0.1)));
		
		exitButton.setPos(new PVector((float)(p.width*0.65), (float)(p.height*0.6)));
		exitButton.setSize(new PVector((float)(p.width*0.18), (float)(p.height*0.1)));
	}
	
	//  GETTERS AND SETTERS  //

	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public Object getStartButton() {return startButton;}

	public void setStartButton(Object startButton) {this.startButton = startButton;}

	public Object getExitButton() {return exitButton;}

	public void setExitButton(Object exitButton) {this.exitButton = exitButton;}

	public Object getShield() {return shield;}

	public void setShield(Object shield) {this.shield = shield;}

}