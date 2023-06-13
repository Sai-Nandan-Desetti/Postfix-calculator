package main.exceptions;


public class InvalidTokenException extends RuntimeException{
    
      public InvalidTokenException(){
 
            super("Invalid Token");
      }

      public InvalidTokenException(String s){

            System.out.println(s);
      }

}
