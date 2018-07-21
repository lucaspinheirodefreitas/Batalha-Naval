/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Projeto.BatalhaNaval;

/**
 *
 * @author mohammed
 */
public class Celula {
    private char caracter;
	
    public Celula(char caracter)
    {
            this.caracter = caracter;
    }

    public void setCaracter(char caracter)
    {
            this.caracter = caracter;
    }

    public char getCaracter()
    {
            return caracter;
    }
}
