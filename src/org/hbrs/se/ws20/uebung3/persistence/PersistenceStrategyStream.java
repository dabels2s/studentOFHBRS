package org.hbrs.se.ws20.uebung3.persistence;


import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    public final static String LOCATION = "/Users//Dokumente Local/Software Projects/SE/userstories18.ser";
    @Override
    public void openConnection() throws PersistenceException {

    }

    @Override
    public void closeConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {
        List<Member> list = null;
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( PersistenceStrategyStream.LOCATION );
            oos = new ObjectOutputStream(fos);
            oos.writeObject( list );
            System.out.println(  list.size() + " Member wurden erfolgreich gespeichert!");
        }
        catch (IOException e) {
            // Koennte man ausgeben für interne Debugs: e.printStackTrace();
            // Chain of Responsibility: Hochtragen der Exception in Richtung Ausgabe (UI)
            // Uebergabe in ein lesbares Format fuer den Benutzer
            throw new PersistenceException();
        }
        finally {
            if (oos != null) try { oos.close(); } catch (IOException e) {}
            if (fos != null) try { fos.close(); } catch (IOException e) {}
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
        List<Member> list = null;
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( PersistenceStrategyStream.LOCATION );
            ois = new ObjectInputStream(fis);

            // Auslesen der Liste
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List) obj;

            }
            System.out.println("Es wurden " + list.size() + " User Stories erfolgreich reingeladen!");
            return list;
        }
        catch (IOException e) {
            // Sup-Optimal, da Exeception in Form eines unlesbaren Stake-Traces ausgegeben wird
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // Verbesserung, aber Chain of Responsbility nicht erfuellt, da UI nicht
            // benachrichtigt wird unter Umstaenden. Verbesserung: siehe Methoden store!
            System.out.println("FEHLER: Liste konnte nicht extrahiert werden (ClassNotFound)!");
        }
        finally {
            if (ois != null) try { ois.close(); } catch (IOException e) {}
            if (fis != null) try { fis.close(); } catch (IOException e) {}
        }
        return list;
    }
}
