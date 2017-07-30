package com.fooock.core;

import com.fooock.core.exception.NotANumberException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

/**
 *
 */
public final class Number implements Comparable<Number> {

    private static final int PRECISION = 32;

    private static final MathContext MATH_CONTEXT = new MathContext(PRECISION, RoundingMode.HALF_UP);

    private final BigDecimal decimal;

    /**
     * Create a number given a string representation. Note that is the given string
     * is not a number, this throw a {@link NumberFormatException}
     *
     * @param number String number representation
     * @throws NumberFormatException If number string is not a valid number
     */
    public Number(String number) {
        this.decimal = new BigDecimal(number, MATH_CONTEXT);
    }

    private Number(BigDecimal number) {
        this.decimal = number;
    }

    /**
     * Returns a {@code Number} whose value is {@code (this + number)},
     * with rounding according to the context settings.
     *
     * @param number value to be added to this {@code Number}.
     * @return this + number
     */
    public Number sum(Number number) {
        if (number == null) {
            throw new NotANumberException();
        }
        return new Number(decimal.add(number.decimal, MATH_CONTEXT));
    }

    /**
     * Returns a {@code BigDecimal} whose value is {@code (this - number)},
     * with rounding according to the context settings.
     *
     * @param number value to be subtracted from this {@code Number}.
     * @return this - number
     */
    public Number minus(Number number) {
        if (number == null) {
            throw new NotANumberException();
        }
        return new Number(decimal.subtract(number.decimal, MATH_CONTEXT));
    }

    @Override
    public int compareTo(Number o) {
        if (o == null) {
            return 0;
        }
        return decimal.compareTo(o.decimal);
    }

    @Override
    public String toString() {
        return decimal.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(decimal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Number)) {
            return false;
        }
        final Number other = (Number) obj;
        if (!this.decimal.equals(other.decimal)
                && ((this.decimal.compareTo(other.decimal) != 0))) {
            return false;
        }
        return true;
    }
}
