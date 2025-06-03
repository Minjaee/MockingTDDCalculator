package com.example.calc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

        return b < 0 ? flipper.flip(result) : result;
    }
}