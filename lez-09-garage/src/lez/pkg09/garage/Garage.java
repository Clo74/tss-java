/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez.pkg09.garage;

/**
 *
 * @author tss
 */
public class Garage {

    private final Veicolo[] posti;

    public Garage() {
        posti = new Veicolo[15];
    }

    /**
     * Inserisce il veicolo al primo posto libero dell'array
     * Se non ci sono posti liberi, ritorna un errore
     * 
     * @param v 
     */
    public void posteggia(Veicolo v) {
        int libero = cercaPostoLibero();
        if (libero == -1) {
            throw new RuntimeException("Parcheggio pieno");
        }
        posti[libero] = v;
    }

    /**
     * Ritorna l'indice del primo posto libero, -1 in caso non ce ne siano
     * 
     * @return 
     */
    private int cercaPostoLibero() {
        for (int i = 0; i < posti.length; i++) {
            if (posti[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Libera la casella posto dell'array e ritorna il veicolo uscito
     * 
     * @param posto
     * @return 
     */
    public Veicolo esci(int posto) {
        Veicolo v = posti[posto];
        posti[posto] = null;
        return v;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("posti -> ").append("15");
        for (int i = 0; i < posti.length; i++) {
            sb.append("-------- ").append(i).append(" ------\n");
            if (posti[i] == null) {
                sb.append("vuoto");
            } else {
                sb.append(posti[i].toString()).append("\n");
            }
            sb.append("--------------------------------------\n");
        }
        return sb.toString();
    }

}
