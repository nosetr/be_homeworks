package com.nosetr._20231206.taski;

public class CircleQ {
    private double radius;
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

/**
 * My solution:
 */
class CircleQMy {
  private double radius;
  
  private double radiusCalc = Math.PI * radius;
  
  public double calculateArea() {
      return radiusCalc * radius;
  }
  
  public double calculateCircumference() {
      return 2 * radiusCalc;
  }
}