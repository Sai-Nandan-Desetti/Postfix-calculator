package main.lib;

import main.exceptions.*;

import java.util.Queue;
import java.util.Stack;
import java.util.EmptyStackException;

import java.lang.Double;
import java.lang.Math;


public class PfCalculator{

      /**
          Description: contains methods and members to implement a POST-FIX CALCULATOR
       */



//Methods...

        
        /* Pre:	      A string 'token'

           Function:  Checks if 'token' is an operator (among a list ('operator[]') of operators) 	

           Post:      If 'token' is an operator the function
                         returns the position of the operator in 'operator[]' 
                      else
                         it throws an OperatorNotFoundException
        */
        private int getOperator(String token){
 
               String operator[] = {"+","-","*","/","^","%"};

               for(int i=0;i<6;i++)
                   if(token.equals(operator[i]))
                      return i;
 
               throw new OperatorNotFoundException();
        }


        
        /* Pre:       two double variables (the two operands) and a string (the operator) 

           Function:  Performs the appropriate operation by calling the getOperator() method

           Post:      If the operator is a valid one (i.e., if getOperator() methos does not throw OperatorNotFoundException) 
                         the function returns the result of the operation
                      else
                         it throws an InvalidTokenException
        */
        private double getResult(double op2, double op1, String tok_op){

               try{
                     switch(getOperator(tok_op)){

                         case 0:  return op1+op2;
 
                         case 1:  return op1-op2;

                         case 2:  return op1*op2;

                         case 3:  return op1/op2;

                         case 4:  return Math.pow(op1,op2);

                         case 5:  return op1%op2;

                         default: return Double.NaN;
                     }
               }

               catch(OperatorNotFoundException i){

                    throw new InvalidTokenException();
               }
        }

                
        
        /* Pre:      A queue of strings (the post-fix expression with each symbol being a string)
           
           Function: Evaluates the expression

           Post:     If the expresssion is indeed a post-fix expression
                        the function returns the result of the expression 
                     else 
                        it returns null
        */
        public Double evaluate(Queue<String> input){

              Stack<Double> output = new Stack<Double>();

              String token;
              double result;
              int    check;

              try{
                    while(input.peek()!=null){

                           token = input.remove();
                          
                           try{
                                 output.push(Double.parseDouble(token));
                           }

                           catch(NumberFormatException n){
                                    
                                try{
                                      check = getOperator(token);
                                      output.push(getResult(output.pop(),output.pop(),token));
                                }

                                catch(OperatorNotFoundException o){
                                     InvalidTokenException i = new InvalidTokenException("The expression contains invalid token(s)");
                                     return null;
                                }

                                catch(EmptyStackException e){
                                     SymbolImbalanceException s = new SymbolImbalanceException();
                                     return null;
                                }     
                           }
                    }

                    result=output.pop();               

                    try{
                          output.peek();
                    }
                    catch(EmptyStackException e){
                         return result;
                    }
                    
                    SymbolImbalanceException s = new SymbolImbalanceException();
                    return null; 
              }
       
              catch(EmptyStackException e){
                   SymbolImbalanceException s = new SymbolImbalanceException();
                   return null;
              }
        }
}
