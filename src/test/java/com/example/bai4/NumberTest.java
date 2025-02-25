package com.example.bai4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    //phân tích giá trị biên: số n-integer -2,1 ty ->2,1 ty
    Number number= new Number();

    @Test
    public void isdiv_Bien_0(){
        Assertions.assertTrue(number.isDivibleBy6(0));
        // dk ben trong assertTrue la dung-> chi het cho 6
    }
    @Test
    public void isdiv_MinValue(){
        Assertions.assertFalse(number.isDivibleBy6(Integer.MIN_VALUE));
        // dk ben trong assertFalse la dung-> chi het cho 6
    }
    @Test
    public void isdiv_MaxValue(){
        Assertions.assertFalse(number.isDivibleBy6(Integer.MAX_VALUE));
        // dk ben trong assertFalse la dung-> chi het cho 6
    }
    @Test
    public void isdiv_ChiaHet(){
        Assertions.assertTrue(number.isDivibleBy6(36));
        // dk ben trong assertFalse la dung-> chi het cho 6
    }
    @Test
    public void isdiv_koChiaHet(){
        Assertions.assertFalse(number.isDivibleBy6(-16));
        // dk ben trong assertFalse la dung-> chi het cho 6
    }

}