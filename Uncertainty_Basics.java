import java.util.*;
import java.lang.Math;

public class Uncertainty_Basics
{

  public static void spacing( String printed ) // Custom method written in order to center - align output)
  {

    if(printed.length() > 78) // 78 is the length of my dividers, so I'm using that as my maximum value
    {

      System.out.println(printed); // print it directly if it's any larger


    }

    else // provided that it fits
    {

      for(int i = 0; i < (78 - printed.length())/2; i++) // the amount of spaces is simply 78 - length of my output, then divided by 2 to center it with equal spaces on either side
      {

        System.out.print(" "); // outputs the spaces

      }

      System.out.println(printed); // outputs my text; center - aligned

    }

  }

  public static void spacing( String printed, int length ) // overloaded version that is used when I want in-line user input; int length is simply how long I believe the input will be (usually easily estimated)
  {

    if((printed.length() + length) > 78) // as above
    {

      System.out.println(printed);


    }

    else
    {

      for(int i = 0; i < (78 - printed.length() - length)/2; i++) // key thing here is that it also subtracts out a bit more to accomodate for user input
      {

        System.out.print(" ");

      }

      System.out.print(printed); // using .print() instead of .println() here because I want the input in-line

    }

  }

  public static double[] add(double[] mantissa, double[] uncertainty)
  {

    double[] res = new double[2];
    double mtemp = 0;
    double utemp = 0;

    for(int i = 0; i < mantissa.length; i++)
    {

      mtemp += mantissa[i];
      utemp += (uncertainty[i] * uncertainty[i]);

    }

    res[0] = mtemp;
    res[1] = Math.sqrt(utemp);

    return res;

  }

  public static double[] mult(double[] mantissa, double[] uncertainty)
  {

    double[] res = new double[2];
    double mtemp = 1;
    double utemp = 0;

    for(int i = 0; i < mantissa.length; i++)
    {

      mtemp *= mantissa[i];
      utemp += (uncertainty[i] * uncertainty[i]) / (mantissa[i] * mantissa[i]);

    }

    res[0] = mtemp;
    res[1] = Math.sqrt(utemp) * mtemp;

    return res;

  }



  public static void main (String [] args)
  {

    Scanner sc = new Scanner (System.in);

    int numterms, op;
    double t1, t2;
    double[] mantissa, uncertainty, res;


    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to my Uncertainty Calculator!");
    spacing("Disclaimer: I am in no way responsible for what you do with this.");
    spacing("It is still your responsibility to follow Mr. van Bemmel's rules.");
    System.out.println();


    do {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("There are two operations that can be performed.");
      System.out.println();
      spacing("1. Add / Subtract");
      spacing("2. Multiply / Divide");
      System.out.println();
      spacing("0. Exit Program");
      System.out.println();
      spacing("Which operation would you like? : ", 1);

      op = sc.nextInt();

      System.out.println();

      if(op == 1)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("How many terms are you entering? : ", 2);

        numterms = sc.nextInt();

        System.out.println();

        mantissa = new double[numterms];
        uncertainty = new double[numterms];

        for(int i = 0; i < numterms; i++)
        {

          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println();
          spacing("Please enter Mantissa #" + (i+1) + ": ", 5);

          mantissa[i] = sc.nextDouble();

          System.out.println();
          spacing("Please enter Uncertainty #" + (i+1) + ": ", 3);

          uncertainty[i] = sc.nextDouble();
          System.out.println();

        }

        System.out.println();

        res = add(mantissa, uncertainty);

        t1 = res[0];
        t2 = res[1];

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("The result is ( " + t1 + " +/- " + t2 + " ).");
        System.out.println();
        
      }

      else if(op == 2)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("How many terms are you entering? : ", 2);

        numterms = sc.nextInt();

        System.out.println();

        mantissa = new double[numterms];
        uncertainty = new double[numterms];

        for(int i = 0; i < numterms; i++)
        {

          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println();
          spacing("Please enter Mantissa #" + (i+1) + ": ", 5);

          mantissa[i] = sc.nextDouble();

          System.out.println();
          spacing("Please enter Uncertainty #" + (i+1) + ": ", 3);

          uncertainty[i] = sc.nextDouble();
          System.out.println();

        }

        System.out.println();

        res = mult(mantissa, uncertainty);

        t1 = res[0];
        t2 = res[1];

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("The result is ( " + t1 + " +/- " + t2 + " ).");
        System.out.println();

      }

      else if(op != 0)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("You have entered an invalid command. Please try again.");
        System.out.println();

      }

    } while (op != 0);

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Fare thee well, my friend.");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

  }

}
