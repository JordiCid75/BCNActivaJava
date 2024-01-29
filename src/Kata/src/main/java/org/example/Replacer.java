package org.example;

import java.util.Arrays;

public abstract class Replacer {
   /*
        In input char return a char "char getTheNearest(char c)":
        - replace the vowel with the nearest left consonant.
        - replace the consonant with the nearest right vowel.

        P.S. To complete this task imagine the alphabet is a circle (connect the first and last element of the array in the mind).
        For example, 'a' replace with 'z', 'y' with 'a', etc.

        For example:
        'c' => 'e'
        'a' => 'z'
        't' => 'u'
        '+' => ' '

        P.S. You work with lowercase letters only.

*/
   public static char getTheNearest(char c){
	   final String vocales = "aeiou";
	   final String abc = "abcdefghijklmnopqrstuvwyz";
	   char ch_abc[] = abc.toCharArray();
	   int indiceBuscado = abc.indexOf(c);
	   
	   
	   
	   
	   // ver si es vocal
	   // si es vocal devolver la consonante de la izquierda
	   // si no es vocal devolver la vocal mas a su derecha
	   
	   if (indiceBuscado >0) {
		if (
				ch_abc[indiceBuscado] == 'a' ||
				ch_abc[indiceBuscado] == 'e' ||
				ch_abc[indiceBuscado] == 'i' ||
				ch_abc[indiceBuscado] == 'o' ||
				ch_abc[indiceBuscado] == 'u'

				)   {
			// es vocal:
			if (indiceBuscado == ch_abc.length) {return ch_abc[0];}
			return ch_abc[indiceBuscado+1];
		}
		   
	   }
       return ' ';
   }

}
