package ie.rbs.screens;

import ie.rbs.objects.Object;
import ie.rbs.playZelda.PlayZelda;
import processing.core.PApplet;
import processing.core.PVector;

public class Selection extends PlayZelda{
	PApplet p;
	Object background, title;
	
	public Selection(PApplet p){
		setP(p);
		setBackground(new Object(p, zeldaCastleImg));
		setTitle(new Object(p, titleImg));
		defaultSelection();
	}
	
	public void display(){
		background.display();
		title.display();
		link.display();
		zelda.display();
		
		updateSelection();
	}
	
	//   ON   FLY   //
	
	public void updateSelection(){
		updateH1();
		updateH2();
	}
	
	public void updateH1(){
		if(link.isHovered()) {link.getInfo().display();}
		if(link.isClicked()) {setHeroSelected(true); setLinkSelected(true);}
	}
	
	public void updateH2(){
		if(zelda.isHovered()) {zelda.getInfo().display();}
		if(zelda.isClicked()) {setHeroSelected(true); setZeldaSelected(true);}
	}
	
	public void defaultSelection(){
		background.setSize(new PVector(p.width, p.height));
		
		title.setPos(new PVector((float)(p.width*0.5), (float)(p.height*0.15)));
		title.setSize(new PVector((float)(p.width*0.5), (float)(p.height*0.1)));
		
		link.setPos(new PVector((float)(p.width*0.15), (float)(p.height*0.5)));
		link.setSize(new PVector((float)(p.width*0.2), (float)(p.height*0.6)));
		
		zelda.setPos(new PVector((float)(p.width*0.85), (float)(p.height*0.5)));
		zelda.setSize(new PVector((float)(p.width*0.18), (float)(p.height*0.6)));
	}
	
	//  GETTERS AND SETTERS  //

	public PApplet getP() {return p;}

	public void setP(PApplet p) {this.p = p;}

	public Object getBackground() {return background;}

	public void setBackground(Object background) {this.background = background;}

	public Object getTitle() {return title;}

	public void setTitle(Object title) {this.title = title;}

}
