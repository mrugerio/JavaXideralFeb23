package com.curso.v1;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {

		Animal animal = new Animal();
		//animal.getSound();
		
		animal = new Gato();
		//animal.getSound();
		
		animal = new Perro();
		//animal.getSound();
		
		animal = new Pato();
		//animal.getSound();
		
		Animal desconocido = getAnimal();
		System.out.println(desconocido.getClass().getSimpleName());
		desconocido.getSound();
	
	}

	private static Animal getAnimal() {
		Animal[] animals = {new Gato(),new Perro(),new Pato(), new Oso()};
		int entero = new Random().nextInt(animals.length);
		System.out.println(entero);
		return animals[entero];
	}

}
