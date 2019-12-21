//solution to Think Java Exercise 11.3
//Created by Tianhui Deng on 08/18/2019
public class Rational{
  public int numerator;
  public int denominator;
  //constructor
  public Rational(){
    numerator=0;
    denominator=1;
  }
  public Rational(int numerator,int denominator){
    this.numerator=numerator;
    this.denominator=denominator;
  }
   //override toString method
  public String toString(){
    return numerator+"/"+denominator;
  }

  public void printRational(){
   System.out.println(numerator+"/"+denominator);
  }
  
  //modifier method
  public void negate(){
    numerator=-numerator;
    System.out.println(numerator/denominator);
  }
  public void invert(){
    int i=numerator;
    numerator=denominator;
    denominator=i; 
    System.out.println("the invert num is "+numerator+"/"+denominator);
  }
  
  // converts the rational number to a double
  //pure function
  public double toDouble(){
    return (double)numerator/denominator;
  }
  
  //To reduce the rational） (pure function:no change to the original objects)
 public Rational reduce(){
      int gcd = gcd(numerator,denominator);
   
      return new Rational(this.numerator / gcd, this.denominator / gcd); 
   
   }
   //method to find the greatest common divisor
    public int gcd(int a,int b){
    if(Math.abs(a)>Math.abs(b)){
    if(a%b==0){
      return b;
    }
    else{
    return  gcd(b,a%b);
    }
  }
    else if(a==b){
      return a;
    }
    else{
      int t=a;
      a=b;
      b=t;
      return gcd(a,b);
    }
}
    //method to add two Rationals
    public Rational add(Rational r1, Rational r2){
      Rational r3=new Rational();
      int lcm=lcm(r1.denominator,r2.denominator);
      r3.denominator=lcm;
      r1.numerator=r1.numerator*(lcm/r1.denominator);
      r2.numerator=r2.numerator*(lcm/r2.denominator);
      r3.numerator=r1.numerator+r2.numerator;
  
      return r3.reduce();
    }
    //method to return the least common multiple
    public int lcm(int m,int n){
     return m*n/gcd(m,n);
    }
  
  public static void main(String[]args){
    Rational num=new Rational(3,15);
    num.negate();
    num.printRational();
    System.out.println(num.toDouble());  
    System.out.println("num is "+num);  
    num.invert();
    System.out.println(num.reduce()); 
   Rational num2=new Rational(1,2);
   System.out.println("num2 is "+num2);
   Rational num3=new Rational();
   System.out.println(num3.add(num,num2));
  }
}
