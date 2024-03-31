package com.badlogic.drop;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


import controller.Main;


import mainclasses.subclasses.baseclasses.BaseClass;

public class MyHeroChess extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture fon;
	private Texture crossbowman, monk, pikeman, peasant, sniper, witch, rogue, deadUnit;
	private Texture arrow;
	private Music combatMusic;
	private Music victory;
	private Texture gameover;
	private Main program;
	// private Vector2 vectorSelf;
	// private Vector2 vectorTarget;


	@Override
	public void create () {
		batch = new SpriteBatch();
		fon = new Texture("fields/desert_field.png");
		gameover = new Texture("fields/gameover.png");
		combatMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/fight.mp3"));
		victory = Gdx.audio.newMusic(Gdx.files.internal("sounds/victory.mp3"));
		combatMusic.setVolume(0.1f);
		combatMusic.play();
		victory.setVolume(0.1f);
		program = new Main();
		crossbowman = new Texture("units/crossbowman.png");
		monk = new Texture("units/monk.png");
		pikeman = new Texture("units/pikeman.png");
		peasant = new Texture("units/peasant.png");
		sniper = new Texture("units/sniper.png");
		witch = new Texture("units/witch.png");
		rogue = new Texture("units/rogue.png");
		deadUnit = new Texture("units/deadUnit.png");
		arrow = new Texture("shots/arrow.png");
		// vectorSelf = new Vector2();
		// vectorTarget = new Vector2();

	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		for (BaseClass unit : program.all.stream().sorted((o1, o2)-> o2.getUnitpoint().getCoordinateY()-o1.getUnitpoint().getCoordinateY()).toList()) {
			float x = unit.getUnitpoint().getCoordinateX() * (Gdx.graphics.getWidth() / 11.f);
			float y = unit.getUnitpoint().getCoordinateY() * (Gdx.graphics.getHeight() / 13.f);
			int k = 1;
			if(program.H.contains(unit)) k = - 1;
			if(!unit.getDie()){
				switch (unit.getClass().getSimpleName()) {
					case "Crossbowman":
						batch.draw(crossbowman, x, y, crossbowman.getWidth() * k, crossbowman.getHeight());
						break;
					case "Monk":
						batch.draw(monk, x, y, monk.getWidth() * k, monk.getHeight());
						break;
					case "Pikeman":
						batch.draw(pikeman, x, y, pikeman.getWidth() * k, pikeman.getHeight());
						break;
					case "Peasant":
						batch.draw(peasant, x, y, peasant.getWidth() * k, peasant.getHeight());
						break;
					case "Sniper":
						batch.draw(sniper, x, y, sniper.getWidth() * k, sniper.getHeight());
						break;
					case "Witch":
						batch.draw(witch, x, y, witch.getWidth() * k, witch.getHeight());
						break;
					case "Rogue":
						batch.draw(rogue, x, y, rogue.getWidth() * k, rogue.getHeight());
						break;
				}
			}
			else batch.draw(deadUnit, x, y, deadUnit.getWidth() * k, deadUnit.getHeight());
		}

		if(program.deadAlliance.size() == 10 || program.deadHorde.size() == 10){
			batch.draw(gameover, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
			combatMusic.stop();
		}
		else {
			if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
				String textWinner = program.fight();
				// shot(program.log);
				if(textWinner != null) {
					Gdx.graphics.setTitle(textWinner);
					victory.play();
				}
			}
		}
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
		crossbowman.dispose();
		monk.dispose();
		pikeman.dispose();
		peasant.dispose();
		sniper.dispose();
		witch.dispose();
		rogue.dispose();
		deadUnit.dispose();
		arrow.dispose();
		gameover.dispose();
	}

	// public void shot(ArrayList <String> all){
	// 	for (String unit : all) {
	// 		if(unit.charAt(unit.length()-1) != '!' && (unit.charAt(0) == 'А' || unit.charAt(0) == 'С')){
	// 			//взять координаты себя и цели
	// 		}
	// 	}
	// }

}
