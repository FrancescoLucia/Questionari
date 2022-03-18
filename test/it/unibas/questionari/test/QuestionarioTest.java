/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unibas.questionari.test;

import it.unibas.questionari.Costanti;
import it.unibas.questionari.modello.Compilazione;
import it.unibas.questionari.modello.Questionario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author francesco
 */
public class QuestionarioTest {
    
    public QuestionarioTest() {
    }
    
    private Questionario questionario;
    
    @Before
    public void setUp() {
        questionario = new Questionario("codice1", "Questionario di test", 3, Costanti.GEOGRAFIA);
    }
    
    @Test
    public void testOrdineCompilazioniFalso() {
        questionario.addCompilazione(new Compilazione(1, true, 255));
        questionario.addCompilazione(new Compilazione(3, false, 100));
        questionario.addCompilazione(new Compilazione(1, true, 500));
        Assert.assertFalse(questionario.verificaOrdineCompilazioni());
    }
    
    @Test
    public void testOrdineCompilazioniVero() {
        questionario.addCompilazione(new Compilazione(1, true, 100));
        questionario.addCompilazione(new Compilazione(3, false, 255));
        questionario.addCompilazione(new Compilazione(1, true, 500));
        Assert.assertTrue(questionario.verificaOrdineCompilazioni());
    }
    
    @Test
    public void testOrdineCompilazioni() {
        try {
            questionario.verificaOrdineCompilazioni();
            Assert.fail("Compilazione vuota non ha sollevato eccezione");
        } catch(IllegalArgumentException e) {
            
        }
    }
    
    
    
}
