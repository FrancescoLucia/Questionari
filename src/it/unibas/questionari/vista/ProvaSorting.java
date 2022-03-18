/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unibas.questionari.vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author francesco
 */
public class ProvaSorting implements Comparable<ProvaSorting> {

    private String nome;
    private int voto;

    public ProvaSorting(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public static void main(String[] args) {
        List<ProvaSorting> lista = new ArrayList<>();

        lista.add(new ProvaSorting("Prova 1", 7));
        lista.add(new ProvaSorting("Prova 3", 3));
        lista.add(new ProvaSorting("Prova 2", 10));
        
        ordinaPerVoto(lista);
        
        for (ProvaSorting provaSorting : lista) {
            System.out.println(provaSorting.getNome() + " | " + provaSorting.getVoto());
        }
    }
    
    private static class ComparatoreNome implements Comparator<ProvaSorting> {

        @Override
        public int compare(ProvaSorting t, ProvaSorting t1) {
            return t.getNome().compareTo(t1.getNome());
        }
        
    }
    
    private static class ComparatoreVoto implements Comparator<ProvaSorting> {

        @Override
        public int compare(ProvaSorting t, ProvaSorting t1) {
            return Integer.compare(t.getVoto(), t1.getVoto());
        }
        
    }
    
    public static void ordinaPerNome(List<ProvaSorting> lista) {
        Collections.sort(lista, new ComparatoreNome());
    }
    
     public static void ordinaPerVoto(List<ProvaSorting> lista) {
        Collections.sort(lista, new ComparatoreVoto());
    }
    
    

    @Override
    public int compareTo(ProvaSorting t) {
        return Double.compare(this.getVoto(), t.getVoto());

    }

}
