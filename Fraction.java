public class Fraction {
    private int numerator;
    private int denominator;

    //constructors
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator has to be different than zero!");
        }

        if (denominator < 0) {
            denominator = denominator * (-1);
            numerator = numerator * (-1);
        }
        else if (numerator * denominator > 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    //methods
    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        if (this.denominator == 1) {
            return this.numerator + "";
        } else {
            return this.numerator + "/" + this.denominator;
        }
    }

    public double toDouble() {
        return ((double) this.numerator / (double) this.denominator);
    }

    public Fraction add(Fraction other) {
        return new Fraction((this.numerator * other.denominator) + (other.numerator * this.denominator), this.denominator * other.denominator);
    }

    public Fraction subtract(Fraction other) {
        return new Fraction((this.numerator * other.denominator) - (other.numerator * this.denominator), this.denominator * other.denominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Can not divide by zero!");
        }
        return new Fraction(this.numerator * other.denominator, other.numerator * this.denominator);
    }

    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            if (this.toDouble() == ((Fraction) other).toDouble()) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator /gcd;
    }

    public static int gcd(int numerator, int denominator) {
        while (numerator != 0 && denominator != 0) {
            int remainder = numerator % denominator;
            numerator = denominator;
            denominator = remainder;
        }
        return numerator;
    }
}
