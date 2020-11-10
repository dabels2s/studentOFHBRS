package org.hbrs.se.ws20.uebung1.test;
import  org.hbrs.se.ws20.uebung1.control.*;
import  org.hbrs.se.ws20.uebung1.view.*;

public class Test {
    private Client Client = null;
    private Translator Translator = null;

    public Test() {
        Client = new Client();
        GermanTranslator translator = new GermanTranslator();
    }

    public void test(){
        //Positivtests
        Client.display(7);  // Äquivalenzklasse AK (1 <= x <=10)
        Client.display(1);  // Äquivalenzklasse AK (1 <= x <=10)
        Client.display(10);  // Äquivalenzklasse AK (1 <= x <=10)
       //Negativtests
        Client.display(12); // Äquivalenzklasse AK (x>10)
        Client.display(-2); // Äquivalenzklasse AK (x<0)
        Client.display(0); // Spezialtest
    }
    public static void main(String[] args) {
        Test z = new Test();
        z.test();
    }
}
