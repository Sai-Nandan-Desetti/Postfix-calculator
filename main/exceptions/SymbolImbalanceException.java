package main.exceptions;


public class SymbolImbalanceException extends RuntimeException{

       public SymbolImbalanceException(){

             System.out.println("Incorrect expression: Missing operand(s) or operator(s).\n");
       }
}
