package org.hbrs.se.ws20.uebung2;


public class ContainerTest {

    /**
     * @param args
     */
    public static void main (String[] args)  {
        ContainerTest test = new ContainerTest();
        try {
            test.start();
        } catch (ContainerException e) {
            e.printStackTrace();
        }

    }

    public void start() throws ContainerException {

        Member r1 = new Member(12) {
            @Override
            public Integer getID() {
                return null;
            }

            @Override
            public String toString() {
                return null;
            }
        };
        Member r2 = new Member(32);
        Member r3 = new Member(112);
        Member r4 = new Member(1211);
        Member r5 = new Member(934);

        // Den Container anlegen
        Container test = new Container();


        // Testfall 1 - Check auf leeren Store
        vergleich ( "Testfall 1 - Pruefung auf leeren Store" , 0 ,test.size()  );

        test.addMember( r1 );
        test.addMember( r2 );
        test.addMember( r3 );
        test.addMember( r4 );


        // Testfall 2 - Pruefen, ob vier Objekte eingefuegt wurden
        vergleich ( "Testfall 2 - Prüfen, ob vier Objekte eingefuegt wurden" , 4 , test.size()  );

        test.addMember(r5);

        // Testfall 3 - Pruefen, ob fuenftes Objekt eingefuegt wurde
        vergleich ( "Testfall 3 - Prüfen, ob fuenftes Objekt eingefuegt wurde" , 5 , test.size()  );

        String result = test.deleteMember(12);
        // System.out.println( result );

        // Testfall 4 - Pruefen, ob Objekt geloescht wurde
        vergleich ( "Testfall 4 - Prüfen, ob Objekt geloescht wurde" ,  4 , test.size()  );

        result = test.deleteMember(12222);
        System.out.println( result );

        // Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde
        vergleich ( "Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde" , 4 , test.size()  );

        try {
            test.addMember( r2 );
        } catch (ContainerException e) {

            e.printStackTrace();

        } finally {

            // Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde
            vergleich ( "Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde" , 4 , test.size()  );
        }

        // Test der Dump-Funktion (ohne Kontrolle)
        test.dump();


        ;

    }


    private void vergleich( String titel, int soll , int ist ){
        System.out.print( titel + ": \n");
        if (soll == ist ) {
            System.out.print("Soll (" + soll + ") = IST (" + soll + ") --> Test ERFOLGREICH");
        } else {
            System.out.print("Soll (" + soll + ") != IST (" + soll + ") --> Test NICHT ERFOLGREICH");
        }
        System.out.println("\n");
    }



}
