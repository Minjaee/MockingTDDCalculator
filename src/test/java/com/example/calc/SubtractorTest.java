package com.example.calc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SubtractorTest {

    private static Subtractor subtractor;

    @BeforeAll
    public static void setUp() {
        // Mock 객체 생성
        IAdder adder = mock(IAdder.class);
        IFlipper flipper = mock(IFlipper.class);

        // Mock 동작 정의
        when(flipper.flip(5)).thenReturn(-5);
        when(adder.add(3, -5)).thenReturn(-2);

        // Subtractor 생성
        subtractor = new Subtractor(adder, flipper);

        //....,,
    }

    @Test
    public void testSubtract() {
        assertEquals(-2, subtractor.subtract(3, 5));
    }
}