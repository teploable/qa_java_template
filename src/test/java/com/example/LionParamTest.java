package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    private Feline feline;
    private Lion lion;
    private final String sex;
    private final boolean expectedMane;

    public LionParamTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters (name = "Пол животного: {0}")
    public static Object[][] getParams() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }
    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(sex, feline);
    }
    @Test
    public void testHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}