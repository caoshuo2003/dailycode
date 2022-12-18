package CalcTrapezoidalAeraMVC;

public class Trapezoidal {
    public double upperBottom, downBottom, height, area;
    public String getArea() {
        if (upperBottom > 0 && downBottom > 0 && height > 0) {
            area = (upperBottom+downBottom)*height/2;
            return String.valueOf(area);
        }
        else {
            return "无法计算面积";
        }
    }

    public void setUpperBottom(double upperBottom) {
        this.upperBottom = upperBottom;
    }

    public void setDownBottom(double downBottom) {
        this.downBottom = downBottom;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
