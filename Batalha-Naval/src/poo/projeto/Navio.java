package poo.projeto;

import static java.lang.Character.toLowerCase;
import java.util.Scanner;

public class Navio {
    Scanner scan = new Scanner(System.in);
    private int tamanho;
    private char orientacao;
    
    public Navio(int tamanho, char orientacao)
    {
        this.tamanho = tamanho;
        this.orientacao = orientacao;
    }
    
    public Navio(int tamanho)
    {
        this.tamanho = tamanho;
    }
    
    public String[] posicoes(String posicaoInicial) {
        String[] posicao = new String[tamanho];
        char primeira, segunda;

        primeira = posicaoInicial.charAt(0);
        segunda = posicaoInicial.charAt(1);
        posicao[0] = posicaoInicial;

        if(getOrientacao() == 'h' || getOrientacao() == 'H') {

            for(int i=1; i<tamanho; i++) {
                segunda = (char)(segunda + 1);
                posicao[i] = String.valueOf(primeira) + String.valueOf(segunda); 
            }
        }
        else {
            for(int i=1; i<getTamanho(); i++) {
                primeira = (char)(primeira + 1);
                posicao[i] = String.valueOf(primeira) + String.valueOf(segunda);
            }
        }
        return posicao;
    }
    
    public char lerOrientacao() {
        char orientacao;
        
        orientacao = scan.next().charAt(0);
        
        while (orientacao != 'h' && orientacao != 'H' && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite [h] para 'horizontal' ou "
                    + "[v] para 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        return orientacao;
    }
    
    public boolean verificaRepeticao(Arquivo arq, String[] posicoes) throws InterruptedException {
        boolean buscaRepeticao;
        
        for(int i=0; i<posicoes.length; i++) {
            buscaRepeticao = arq.buscar(arq.getPath(), posicoes[i]);
            if(buscaRepeticao) {
                return true;
            }
        }
        return false;
    }
    
    public boolean validarPosicoes(String[] posicoes) {
        char linha, coluna;
        int verificaLinha, verificaColuna;
        
        for(int i=0; i<posicoes.length; i++) {
            char orient;
            orient = toLowerCase(this.orientacao);
            linha = posicoes[i].charAt(0);
            coluna = posicoes[i].charAt(1);
            verificaLinha = Integer.parseInt(String.valueOf(linha));
            verificaColuna = Integer.parseInt(String.valueOf(coluna));
            
            if((verificaLinha == 9 && i<(posicoes.length-1) && orient == 'v') || (verificaColuna == 9 && i<(posicoes.length-1)) && orient == 'h') {
                return false;
            }
        }
        return true;
    }  

    public int getTamanho() {
        return tamanho;
    }

    public char getOrientacao() {
        return orientacao;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setOrientacao(char orientacao) {
        this.orientacao = orientacao;
    }
}
