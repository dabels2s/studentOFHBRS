package org.hbrs.se.ws20.uebung2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container{
        public Container(){
        }

        private List<Member> liste = new ArrayList<Member>();


        /*
         * Methode zum Hinzufuegen einer Member.
         * @throws ContainerException
         */
        public void addMember ( Member r ) throws ContainerException {
                if ( contains( r ) == true ) {
                        ContainerException ex = new ContainerException();
                        ex.addID ( r.getID() );
                        throw ex;
                }
                liste.add( r );

        }

        /*
         * Methode zur Ueberpruefung, ob ein Member-Objekt in der Liste enthalten ist
         */
        private boolean contains(Member r) {
                Integer ID = r.getID();
                for ( Member rec : liste) {

                        if ( rec.getID().intValue() == ID.intValue() ) {
                                return true;
                        }
                }
                return false;


        }
        public String deleteMember( Integer id ) {
                Member rec = getMember( id );
                if (rec == null) return "Member nicht enthalten - ERROR"; else {
                        liste.remove(rec);
                        return "Member mit der ID " + id + " konnte geloescht werden";
                }
        }
        private Member getMember(Integer id) {
                for ( Member rec : liste) {
                        if (id == rec.getID().intValue() ){
                                return rec;
                        }
                }
                return null;
        }
        public void dump() {
                System.out.println("Ausgabe aller Member-Objekte: ");

                Iterator<Member> i = liste.iterator();
                while (i.hasNext()) {
                        Member p = i.next();
                        System.out.println("ID: " + p.getID());
                }
        }


}
