package com.singular.cover.zoo;

import com.singular.cover.zoo.ui.ZooUIConsole;

/**
 * Application's entry point.
 *
 * @author mauro-sanchez
 */
public final class ZooMain {
	
	public static void main(String[] args) {

		System.out.println("\n*****************************************");
        System.out.println("*********      .:  Zoo  :.      *********");
        System.out.println("*****************************************");
        
        ZooImpl.createZoo().initZoo(new ZooUIConsole());

    }
}
