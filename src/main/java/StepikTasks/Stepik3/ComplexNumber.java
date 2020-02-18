package StepikTasks.Stepik3;

import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(1, 1);
        ComplexNumber number2 = new ComplexNumber(1, 1);
        System.out.println("number1.hashCode() = " + number1.hashCode());
        System.out.println("number2.hashCode() = " + number2.hashCode());
        System.out.println("number2.equals(number1) = " + number2.equals(number1));
        System.out.println("number1.equals(number1) = " + number1.equals(number2));
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        long longBits;

        longBits = Double.doubleToLongBits(re);
        hash = hash * 34 + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(im);
        hash = hash * 34 + (int) (longBits - (longBits >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ComplexNumber) {
            ComplexNumber complexNumber = (ComplexNumber) obj;
            return Objects.equals(complexNumber.re, this.re) &&
                    Objects.equals(complexNumber.im, this.im);
        }
        return false;
    }
}
