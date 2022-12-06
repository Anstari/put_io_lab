package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

public class FailureOrErrorTest {
    @Test
    void test1(){
        Assertions.assertEquals(2+1, 1);
    }
    @Test
    void test2(){

    }
    @Test
    void test3(){
        try{
            Assertions.assertEquals(2, 1);
        }
        catch (Exception e){
           e.getStackTrace();
        }

    }
}
