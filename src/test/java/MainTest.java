import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    @Test
    void check_inputTest_tosmall(){
        //given
        int totest = 0;
        //when
        boolean actual = Main.check_input(totest);
        //then
        assertFalse(actual);
    }
    @Test
    void check_inputTest_tobig(){
        //given
        int totest = 101;
        //when
        boolean actual = Main.check_input(totest);
        //then
        assertFalse(actual);
    }
    @Test
    void check_inputTest_valid1(){
        //given
        int totest = 1;
        //when
        boolean actual = Main.check_input(totest);
        //then
        assertTrue(actual);
    }
    @Test
    void check_inputTest_valid100(){
        //given
        int totest = 100;
        //when
        boolean actual = Main.check_input(totest);
        //then
        assertTrue(actual);
    }
    @Test
    void whichfirstnumberTest(){
        //given
        int[] totest = {39,40,49,50,89,90,99,100,75};
        int[] solution = {39,0,9,0,39,0,9,0,25};
        for (int i = 0; i < totest.length; i++) {
            //when
            int actual = Main.whichfirstnumber(totest[i]);
            //then
            assertEquals(solution[i],actual);
        }
    }
    @Test
    void addfirstnumbeRestTest() {
        //given
        int[] totest = {40, 49, 90, 99};
        int[] solution = {0, 9, 0, 9};
        Main.clearnumbarray();

        for (int i = 0; i < totest.length; i++) {
            //when
            int actual = Main.addFirstNumber(totest[i]);
            //then
            assertEquals(solution[i], actual);
        }
    }
        @Test
        void addfirstnumberStringTest(){
            //given
            //[, Ⅰ, Ⅱ, Ⅲ, Ⅳ, Ⅴ, Ⅵ, Ⅶ, Ⅷ, Ⅸ, Ⅹ, Ⅼ, Ⅽ]
            int[] totest = {40,49,90,99};
            int[] solution = {50,50,100,100};

            for (int i = 0; i < totest.length; i++) {
                //when
                Main.clearnumbarray();
                Main.addFirstNumber(totest[i]);
                //then
                assertEquals(10,Main.numbarray[0]);
                assertEquals(solution[i],Main.numbarray[1]);
            }
        }
        @Test
        void addtoarrayTest(){
            //given
            int totest = 6;
            int totest2 = 8;
            boolean actual = false;
            Main.clearnumbarray();
            //when
            Main.addtoarray(totest);
            Main.addtoarray(totest2);
            //then
            actual = ((Main.numbarray[0] == 6) && (Main.numbarray[1] == 8));
            assertTrue(actual);
        }
    @Test
    void clearnumberTest(){
        //given
        boolean actual = false;
        Main.clearnumbarray();
        //when
        Main.numbarray = new int[5];
        Main.clearnumbarray();
        actual = Main.numbarray.length == 0;
        //then
        assertTrue(actual);
    }
    @Test
    void teenthTest() {
        //given
        int[] totest = {39, 40, 49, 50, 81, 90};
        int[] solution = {9, 0, 9, 0, 1, 0};
        for (int i = 0; i < totest.length; i++) {
            //when
            int actual = Main.teenth(totest[i]);
            //then
            assertEquals(solution[i], actual);
        }
    }
    @Test
    void convertTest(){
        //given
        //[, Ⅰ, Ⅱ, Ⅲ, Ⅳ, Ⅴ, Ⅵ, Ⅶ, Ⅷ, Ⅸ, Ⅹ, Ⅼ, Ⅽ]
        int[] totest = {1,2,3,4,5,6,7,8,9,10,50,100,7};
        String[] solution = {"Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ", "Ⅹ", "Ⅼ", "Ⅽ", "Ⅶ"};

        for (int i = 0; i < totest.length; i++) {
            //when
            Main.clearnumbarray();
            Main.addtoarray(totest[i]);
            String actual = Main.convert();
            //then
            assertEquals(solution[i],actual);

        }
    }
}
