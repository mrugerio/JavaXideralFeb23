package com.curso.v4;

@FunctionalInterface
public interface Predicado<T> {
	
	boolean probar(T t);
	
}
