package com.example.calc;

public class Multiplier implements IMultiplier {
    private final IAdder adder;
    private final IFlipper flipper;

    public Multiplier(IAdder adder, IFlipper flipper) {
        this.adder = adder;
        this.flipper = flipper;
    }

    @Override
    public int multiply(int a, int b) {
        int result = 0;
        int times = Math.abs(b);

        for (int i = 0; i < times; i++) {
            result = adder.add(result, a);
        }

        if (b < 0) {
            result = flipper.flip(result);
        }

        return result;
    }
}