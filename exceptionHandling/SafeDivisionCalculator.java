package exceptionHandling;

import collections.MergeTwoSortedList;

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message){
        super(message);
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message){
        super(message);
    }
}

public class SafeDivisionCalculator {

    public static double safeDivide(double numerator, double denominator) throws DivisionByZeroException, InvalidInputException {

       if(Double.isNaN(numerator) || Double.isNaN(denominator) || Double.isInfinite(numerator) || Double.isInfinite(denominator)){
           throw new InvalidInputException("Invalid Number");
       }
      if(denominator==0){
          throw new DivisionByZeroException("Cannot divide by 0");
      }
        return (numerator/denominator);
    }

    public static void main(String[] args) {
        double result = 0;
        try{
            result = safeDivide(2.45, 0.0);

        } catch(InvalidInputException e){
            System.out.println("InvalidInputException : " + e.getMessage());
        } catch(DivisionByZeroException e){
            System.out.println("DivisionByZeroException : " + e.getMessage());
        } finally {
            System.out.println("End of Operation");
        }
    }
}
