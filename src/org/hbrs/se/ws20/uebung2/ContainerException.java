package org.hbrs.se.ws20.uebung2;

public class ContainerException extends Exception {
    private Integer id;

    @Override
    public void printStackTrace() {
        System.out.println("Das Member-Objekt mit der ID " + this.id + " ist bereits vorhanden!");
    }

    public void addID(Integer id) {
        this.id = id;
    }
}
