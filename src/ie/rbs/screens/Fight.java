package ie.rbs.screens;

import ie.rbs.playZelda.PlayZelda;
import ie.rbs.objects.Object;
import ie.rbs.objects.Mage;
import processing.core.PApplet;
import processing.core.PVector;

public class Fight extends PlayZelda{
	PApplet p;
	Object background;
	static boolean transformed = false;
	
	public Fight(PApplet p){
		setP(p);
		setBackground(new Object(p, ganonCastleImg));
		defaultFight();
	}

	public void display(){
		background.display();
		updateGanon();
		updatePlayer();
	}
	
	//  ON   FLY  //
	
	public void updateGanon(){
		ganon.getStatus().setPos(new PVector((float)(p.width*0.59), (float)(p.height*0.005)));
		ganon.getStatus().display();
		ganon.move();
		ganon.display();
		ganon.attack();
		ganon.summomMagic();
		
		// ATTACK
		if(ganon.getMagic().overlaps(player)){player.loseLife(ganon.getPower());}
		// GANON IMG CONFIG
		if(ganon.getLife() > 0 && !transformed) {
			ganon.transform(ganon.getBody());
			ganon.setSize(new PVector((float)(p.width*0.1), (float)(p.height*0.3)));

		}
		//GANON IMG CONFIG AND ENDING SCREEN INI
		if(ganon.getLife() <= 0 && !transformed) {
			ganon.setPos(new PVector((float)(p.width*0.85), (float)(p.height*0.5)));
			ganon.setLife(300); 
			ganon.transform(ganon.getExtra()); 
			ganon.setSize(new PVector((float)(p.width*0.3), (float)(p.height*0.5)));
			transformed = true;
		}else if(ganon.getLife() <= 0 && transformed) {
			endingScreen = true;
			
		}
	}
	
	public void updatePlayer(){
		setFightStarted(true);
		player.setPos(new PVector(p.mouseX, p.mouseY));
		player.isOut();
		player.getStatus().display();
		player.display();
		
		if(player.getName() == "Zelda"){
		if(((Mage)player).getMagic().overlaps(ganon)){ganon.loseLife(player.getPower()/3);}
		}
		
		if(player.getLife() <= 0) {endingScreen = true;}
	}
	
	public void defaultFight(){
		
		background.setSize(new PVector(p.width, p.height));
		ganon.setImg(ganon.getBody());
		ganon.setPos(new PVector((float)(p.width*0.85), (float)(p.height*0.5)));
		ganon.setSize(new PVector((float)(p.width*0.1), (float)(p.height*0.3)));
		
	}

	// GETTERS AND SETTERS //
	
	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public Object getBackground() {return background;}

	public void setBackground(Object background) {this.background = background;}

	public boolean isTransformed() {return transformed;}

	public static void setTransformed(boolean transformed) {Fight.transformed = transformed;}
	
}
