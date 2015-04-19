/*
 * Copyright (c) 2015 Chris Newland.
 * Licensed under https://github.com/chriswhocodes/demofx/blob/master/LICENSE-BSD
 */

package com.chrisnewland.demofx.effect;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

import com.chrisnewland.demofx.DemoConfig;
import com.chrisnewland.demofx.effect.fake3d.Sprite3D;
import com.chrisnewland.demofx.effect.fake3d.Starfield;
import com.chrisnewland.demofx.effect.fractal.Mandelbrot;
import com.chrisnewland.demofx.effect.fractal.Sierpinski;
import com.chrisnewland.demofx.effect.pixel.Pixels;
import com.chrisnewland.demofx.effect.shape.Burst;
import com.chrisnewland.demofx.effect.shape.Checkerboard;
import com.chrisnewland.demofx.effect.shape.Concentric;
import com.chrisnewland.demofx.effect.shape.Grid;
import com.chrisnewland.demofx.effect.shape.Rings;
import com.chrisnewland.demofx.effect.sprite.Bounce;
import com.chrisnewland.demofx.effect.sprite.Spin;
import com.chrisnewland.demofx.effect.sprite.Tiles;
import com.chrisnewland.demofx.effect.text.Credits;
import com.chrisnewland.demofx.effect.text.SpriteWave;
import com.chrisnewland.demofx.effect.text.TextWave;
import com.chrisnewland.demofx.util.ShapeEffect;

public class EffectFactory
{
	public static List<IEffect> getEffects(GraphicsContext gc, DemoConfig config)
	{
		List<IEffect> result = new ArrayList<>();

		String effectParam = config.getEffect();

		String[] parts = effectParam.split(",");

		for (String part : parts)
		{
			result.add(getEffect(part, gc, config));
		}

		return result;
	}

	private static IEffect getEffect(String name, GraphicsContext gc, DemoConfig config)
	{
		switch (name)
		{
		case "triangles":
			return new ShapeEffect(gc, config, 3);

		case "squares":
			return new ShapeEffect(gc, config, 4);

		case "pentagons":
			return new ShapeEffect(gc, config, 5);

		case "hexagons":
			return new ShapeEffect(gc, config, 6);

		case "stars":
			ShapeEffect stars = new ShapeEffect(gc, config, 5);
			stars.setDoubleAngle(true);
			return stars;

		case "rings":
			return new Rings(gc, config);

		case "tiles":
			return new Tiles(gc, config);

		case "spin":
			return new Spin(gc, config);

		case "bounce":
			return new Bounce(gc, config);

		case "burst":
			return new Burst(gc, config);

		case "concentric":
			return new Concentric(gc, config);

		case "sierpinski":
			return new Sierpinski(gc, config);

		case "pixels":
			return new Pixels(gc, config);

		case "textwave":
			return new TextWave(gc, config);

		case "spritewave":
			return new SpriteWave(gc, config);

		case "grid":
			return new Grid(gc, config);

		case "checkerboard":
			return new Checkerboard(gc, config);

		case "mandelbrot":
			return new Mandelbrot(gc, config);

		case "starfield":
			return new Starfield(gc, config);

		case "sprite3d":
			return new Sprite3D(gc, config);
			
		case "credits":
			return new Credits(gc, config);

		default:
			throw new RuntimeException("No such effect: " + config.getEffect());
		}
	}
}
