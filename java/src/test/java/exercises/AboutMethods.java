package exercises;

import org.testng.annotations.Test;

public class AboutMethods {

    @Test
    public void printProduct(){
        System.out.println(multiply(4,5));
    }

    private int multiply(int numberA, int numberB){
        return numberA + numberB;
    }
}
