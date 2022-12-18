package CalcArea;

import jdk.jshell.spi.ExecutionControl.*;

public abstract class Shape {
    private static double number;

    public Shape() {
    }

    public Shape(double number) {
        this.number = number;
    }

    // 若子类未重写父类方法则抛出异常
    public double CalcArea() throws NotImplementedException{
        throw new NotImplementedException("未重写父类方法");
    };

    public static class Circle extends Shape {

        public Circle() {
        }

        public Circle(double number) {
            super(number);
        }

        @Override
        public double CalcArea() throws NotImplementedException {
            double areaCircle = Math.PI * number * number;
            return areaCircle;
        }
    }

    public static class Rectangle extends Shape {
        private double width;
        public Rectangle() {
        }

        public Rectangle(double number, double width) {
            super(number);
            this.width = width;
        }

//        @Override
//        public double CalcArea() throws NotImplementedException {
//            double area = number * width;
//            return area;
//        }
    }

    public static void main(String[] args) {
        try {

            Shape.Circle circle = new Shape.Circle(4);
            System.out.println(String.format("圆的面积%.2f", circle.CalcArea()));

            Shape.Rectangle rectangle = new Shape.Rectangle(10, 5);
            System.out.println(String.format("长方形的面积为%.2f", rectangle.CalcArea()));
        }catch (NotImplementedException e) {
            System.out.println("Exception thrown:" + e.getMessage());
        }

    }

}
