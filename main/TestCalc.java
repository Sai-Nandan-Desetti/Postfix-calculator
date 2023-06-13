package main;

import main.lib.*;
import main.utility.*;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

import java.lang.Double;


public class TestCalc{

       /** Submission date: 20.1.2020

           Description: implements a calculator using the methods as described in PfCalculator.class
        */


        public static void main(String args[]){


        //data structures and data types used...

              String		postFixExp;
              Queue<String>	inputExpression;
              StringTokenizer	op;
              PfCalculator	p;
              Double		result;

              
         //main loop that calls the appropriate methods to evaluate the post-fix expression...
             
              postFixExp=Validator_M.getString("\nEnter the post-fix expression: ");
     
              while(!postFixExp.equalsIgnoreCase("done")){
                      
                   inputExpression = new LinkedList<String>();

                   op = new StringTokenizer(postFixExp);
                   while(op.hasMoreTokens())
                        inputExpression.add(op.nextToken());

                   p = new PfCalculator();
                   result = p.evaluate(inputExpression);
                   if(result!=null)
                      System.out.println("\nThe result: "+result);
               
                   postFixExp=Validator_M.getString("\nEnter the (postfix expression): ");
              }
        }
}
