/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class ContoCorrente {

    private final int numero;
    private final String intestatario;
    private double saldo;
    private List<Double> movimenti = new ArrayList<>();
    
    public ContoCorrente(int numero, String intestatario) {
        this.numero = numero;
        this.intestatario = intestatario;
        this.saldo = 0;
    }

    public void prelievo(double somma) {
        if (saldo < somma || somma <= 0) {
            throw new IllegalArgumentException("La somma non è disponibile"); //genera una eccezione
        }
        movimenti.add(0,-somma);
        saldo -= somma;
    }

    public void deposito(double somma) {
        if (somma <= 0) {
            throw new IllegalArgumentException("deposito errato");
        }
        movimenti.add(0,somma);
        saldo += somma;
    }

    public int getNumero() {
        return numero;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Double> estrattoConto(int num){
        return movimenti.stream().limit(num).collect(Collectors.toList());
    }
    
    public List<Double> estrattoDepositi(int num){
        return movimenti.stream()
                .filter(movimento -> movimento>0)
                .limit(num)
                .collect(Collectors.toList());
    }
}
