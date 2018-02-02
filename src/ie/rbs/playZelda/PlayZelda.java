package ie.rbs.playZelda;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import ie.rbs.auxiliaries.Status;
import ie.rbs.objects.Hero;
import ie.rbs.objects.Mage;
import ie.rbs.objects.Villain;
import ie.rbs.objects.Warrior;
import ie.rbs.screens.Ending;
import ie.rbs.screens.Fight;
import ie.rbs.screens.Menu;
import ie.rbs.screens.Selection;

public class PlayZelda extends PApplet{
	public static void main(String[] args){
		PApplet.main("ie.rbs.playZelda.PlayZelda");
	}
	// CONDITIONALS
	// THERE SHOULD BE AN EXIT CLICKED AS WELL, BUT I DON'T KNOW HOW TO 
	// CLOSE THE SCREEN;
	public static boolean startClicked = false;
	public static boolean heroSelected = false;
	public static boolean linkSelected = false;
	public static boolean zeldaSelected = false;
	public static boolean fightStarted = false;
	public static boolean endingScreen = false;
	public static boolean tryAgain = false;
	// IMAGES
	protected static PImage attGanonImg, attLinkImg, attZeldaImg, beastGanonImg, 
	exitButtonImg, ganonImg, ganonCastleImg, ganonFaceImg, ganonMagicImg, invZeldaImg, 
	invZeldaFaceImg, linkImg, linkFaceImg, magicImg, titleImg, shieldImg, 
	skullImg, startButtonImg, zeldaImg, zeldaCastleImg, tryAgainImg;
	// SCREENS
	Menu menu;
	Selection selection;
	Fight fight;
	Ending ending;
	// OBJECTS
	protected static Warrior link;
	protected static Mage zelda;
	protected static Hero player;
	protected static Villain ganon;
	
	public void settings(){
		size(1000, 500);
	}
	
	public void setup(){
		frameRate(100);
		loadImages();
		setLink(new Warrior(this, linkImg, linkImg, attLinkImg, linkFaceImg, skullImg));
		setZelda(new Mage(this, zeldaImg, zeldaImg, attZeldaImg, invZeldaFaceImg, magicImg));
		setGanon(new Villain(this, ganonImg, ganonImg, ganonMagicImg, ganonFaceImg, beastGanonImg));
		setPlayer(null);
		setMenu(new Menu(this));
		setSelection(new Selection(this));
		setFight(new Fight(this));
		setEnding(new Ending(this));
		
		defaultLink();
		defaultZelda();
		defaultGanon();
	}
	
	public void draw(){
		imageMode(CENTER);
		rectMode(CENTER);
		
		timeLine();
	}
	
	//     ON    FLY    //
	
	// THIS FUNCTION RULES THE SCREENS' APPEARENCE ORDER.
	public void timeLine(){
		if(!startClicked && !heroSelected) {menu.display();}
		else if(startClicked && !heroSelected) {selection.display();selectHero();}
		else if(startClicked && heroSelected && (linkSelected || zeldaSelected)) {fight.display();}
		else if(startClicked && heroSelected && (zeldaSelected || linkSelected) && !endingScreen) {fight.display();}
		if (endingScreen) {ending.display();}
	}
	
	// RESTART THE GAME
	public void restart(){
		startClicked = false;
		heroSelected = false;
		linkSelected = false;
		zeldaSelected = false;
		fightStarted = false;
		endingScreen = false;
		tryAgain = false;
		Fight.setTransformed(false);
		setPlayer(null);
		defaultLink();
		defaultZelda();
		defaultGanon();
	}

	// I'VE TRYED TO CODE THIS FUNCTION ON THE SCREENS CODES, BUT DIDN'T WORK
	// I ALSO TRYED TO OVERRIDE IT ON THE SCREENS, NO SUCCESS TOO.
	// **** THIS FUNCTION IS USED ON THE FIGHT SCREEN ****
	public void mousePressed(){
		if(startClicked && heroSelected && (linkSelected || zeldaSelected) && fightStarted && ganon.isHovered()){
			ganon.loseLife(player.getPower());
			player.setImg(player.getAttBody());
			player.setSize(new PVector((float)(width*0.18), (float)(height*0.3)));
		}else if(startClicked && heroSelected && (linkSelected || zeldaSelected) && fightStarted){
			player.setImg(player.getAttBody());
			player.setSize(new PVector((float)(width*0.18), (float)(height*0.3)));
		}
	}
	
	// I'VE TRYED TO CODE THIS FUNCTION ON THE SCREENS CODES, BUT DIDN'T WORK
	// I ALSO TRYED TO OVERRIDE IT ON THE SCREENS, NO SUCCESS TOO.
	// **** THIS FUNCTION IS USED ON THE FIGHT SCREEN ****
	public void mouseReleased(){
		if(startClicked && heroSelected && (linkSelected || zeldaSelected) && fightStarted){
			player.attack();
			player.setSize(new PVector((float)(width*0.1), (float)(height*0.3)));
		}
	}
	
	// I TRYED TO USE: setPlayer(link); but on the next 
	// Fight screen my commands were not working.
	// I believe that it is because of the P, but i 
	// don't know how it works exactly.
	public void selectHero(){
		if(linkSelected){
			setPlayer(new Warrior(this, linkImg, linkImg, attLinkImg, linkFaceImg, skullImg));
			player.setName(link.getName());
			player.setPower(link.getPower());
			player.setType(link.getType());
			player.setLife(link.getLife());
			player.setBase(link.getBase());
			player.setStatus(new Status(player));
		}else if(zeldaSelected){
			setPlayer(new Mage(this, zeldaImg, zeldaImg, attZeldaImg, invZeldaFaceImg, magicImg));
			player.setName(zelda.getName());
			player.setPower(zelda.getPower());
			player.setType(zelda.getType());
			player.setLife(zelda.getLife());
			player.setBase(zelda.getBase());
			player.setStatus(new Status(player));
		}
	}

	// ZELDA INI VALUES
	public void defaultZelda(){
		zelda.setName("Zelda");
		zelda.setType("Mage");
		zelda.setLife(200);
		zelda.setPower(15);
		zelda.setBase(200);
	}
	
	// LINK INI VALUES
	public void defaultLink(){
		link.setName("Link");
		link.setType("Warrior");
		link.setLife(300);
		link.setPower(30);
		link.setBase(300);
	}
	
	// GANON INI VALUES
	public void defaultGanon(){
		ganon.setName("Ganon");
		ganon.setType("Mage");
		ganon.setLife(300);
		ganon.setPower(10);
		ganon.setBase(300);
	}
	
	// IMAGES INITIALISATION
	public void loadImages(){
		background(0);
		setAttGanonImg(loadImage("data/attGanon.png"));
		setAttLinkImg(loadImage("data/attLink.png"));
		setAttZeldaImg(loadImage("data/attZelda.png"));
		setBeastGanonImg(loadImage("data/beastGanon.png"));
		setExitButtonImg(loadImage("data/exitButton.png"));
		setGanonImg(loadImage("data/ganon.png"));
		setGanonCastleImg(loadImage("data/ganonCastle.png"));
		setGanonFaceImg(loadImage("data/ganonFace.png"));
		setGanonMagicImg(loadImage("data/ganonMagic.png"));
		setInvZeldaImg(loadImage("data/invZelda.png"));
		setInvZeldaFaceImg(loadImage("data/invZeldaFace.png"));
		setLinkImg(loadImage("data/link.png"));
		setLinkFaceImg(loadImage("data/linkFace.png"));
		setMagicImg(loadImage("data/magic.png"));
		setShieldImg(loadImage("data/shield.png"));
		setSkullImg(loadImage("data/skull.png"));
		setStartButtonImg(loadImage("data/startButton.png"));
		setTitleImg(loadImage("data/title.png"));
		setZeldaImg(loadImage("data/zelda.png"));
		setZeldaCastleImg(loadImage("data/zeldaCastle.png"));
		setTryAgainImg(loadImage("data/tryAgain.png"));
	}
	
	// GETTERS   AND   SETTERS //

	public static PImage getAttGanonImg() {return attGanonImg;}

	public static void setAttGanonImg(PImage attGanonImg) {PlayZelda.attGanonImg = attGanonImg;}

	public static  PImage getAttLinkImg() {return attLinkImg;}

	public static void setAttLinkImg(PImage attLinkImg) {PlayZelda.attLinkImg = attLinkImg;}

	public static PImage getAttZeldaImg() {return attZeldaImg;}

	public static void setAttZeldaImg(PImage attZeldaImg) {PlayZelda.attZeldaImg = attZeldaImg;}

	public static PImage getBeastGanonImg() {return beastGanonImg;}

	public static void setBeastGanonImg(PImage beastGanonImg) {PlayZelda.beastGanonImg = beastGanonImg;}

	public static PImage getExitButtonImg() {return exitButtonImg;}

	public static void setExitButtonImg(PImage exitButtonImg) {PlayZelda.exitButtonImg = exitButtonImg;}

	public static PImage getGanonImg() {return ganonImg;}

	public static void setGanonImg(PImage ganonImg) {PlayZelda.ganonImg = ganonImg;}

	public static PImage getGanonCastleImg() {return ganonCastleImg;}

	public static void setGanonCastleImg(PImage ganonCastleImg) {PlayZelda.ganonCastleImg = ganonCastleImg;}

	public static PImage getGanonFaceImg() {return ganonFaceImg;}

	public static void setGanonFaceImg(PImage ganonFaceImg) {PlayZelda.ganonFaceImg = ganonFaceImg;}

	public static PImage getGanonMagicImg() {return ganonMagicImg;}

	public static void setGanonMagicImg(PImage ganonMagicImg) {PlayZelda.ganonMagicImg = ganonMagicImg;}

	public static PImage getInvZeldaImg() {return invZeldaImg;}

	public static void setInvZeldaImg(PImage invZeldaImg) {PlayZelda.invZeldaImg = invZeldaImg;}

	public static PImage getInvZeldaFaceImg() {return invZeldaFaceImg;}

	public static void setInvZeldaFaceImg(PImage invZeldaFaceImg) {PlayZelda.invZeldaFaceImg = invZeldaFaceImg;}

	public static PImage getLinkImg() {return linkImg;}

	public static void setLinkImg(PImage linkImg) {PlayZelda.linkImg = linkImg;}

	public static PImage getLinkFaceImg() {return linkFaceImg;}

	public static void setLinkFaceImg(PImage linkFaceImg) {PlayZelda.linkFaceImg = linkFaceImg;}

	public static PImage getMagicImg() {return magicImg;}

	public static void setMagicImg(PImage magicImg) {PlayZelda.magicImg = magicImg;}

	public static PImage getTitleImg() {return titleImg;}

	public static void setTitleImg(PImage titleImg) {PlayZelda.titleImg = titleImg;}

	public static PImage getShieldImg() {return shieldImg;}

	public static void setShieldImg(PImage shieldImg) {PlayZelda.shieldImg = shieldImg;}

	public static PImage getSkullImg() {return skullImg;}

	public static void setSkullImg(PImage skullImg) {PlayZelda.skullImg = skullImg;}

	public static PImage getStartButtonImg() {return startButtonImg;}

	public static void setStartButtonImg(PImage startButtonImg) {PlayZelda.startButtonImg = startButtonImg;}

	public static PImage getZeldaImg() {return zeldaImg;}

	public static void setZeldaImg(PImage zeldaImg) {PlayZelda.zeldaImg = zeldaImg;}

	public static PImage getZeldaCastleImg() {return zeldaCastleImg;}

	public static void setZeldaCastleImg(PImage zeldaCastleImg) {PlayZelda.zeldaCastleImg = zeldaCastleImg;}

	public Menu getMenu() {return menu;}

	public void setMenu(Menu menu) {this.menu = menu;}
	
	public Selection getSelection() {return selection;}
	
	public void setSelection(Selection s) {this.selection = s;}

	public Warrior getLink() {return link;}

	public void setLink(Warrior link) {this.link = link;}

	public Mage getZelda() {return zelda;}

	public void setZelda(Mage zelda) {this.zelda = zelda;}

	public static boolean isStartClicked() {return startClicked;}

	public static void setStartClicked(boolean startClicked) {PlayZelda.startClicked = startClicked;}

	public static boolean isHeroSelected() {return heroSelected;}

	public static void setHeroSelected(boolean heroSelected) {PlayZelda.heroSelected = heroSelected;}

	public Fight getFight() {return fight;}

	public void setFight(Fight fight) {this.fight = fight;}

	public Hero getPlayer() {return player;}

	public void setPlayer(Hero player) {this.player = player;}

	public Villain getGanon() {return ganon;}

	public void setGanon(Villain ganon) {PlayZelda.ganon = ganon;}

	public static boolean isLinkSelected() {return linkSelected;}

	public static void setLinkSelected(boolean linkSelected) {PlayZelda.linkSelected = linkSelected;}

	public static boolean isZeldaSelected() {return zeldaSelected;}

	public static void setZeldaSelected(boolean zeldaSelected) {PlayZelda.zeldaSelected = zeldaSelected;}

	public static boolean isFightStarted() {return fightStarted;}

	public static void setFightStarted(boolean fightStarted) {PlayZelda.fightStarted = fightStarted;}

	public Ending getEnding() {return ending;}

	public void setEnding(Ending ending) {this.ending = ending;}

	public static PImage getTryAgainImg() {return tryAgainImg;}

	public static void setTryAgainImg(PImage tryAgainImg) {PlayZelda.tryAgainImg = tryAgainImg;}
	
}
