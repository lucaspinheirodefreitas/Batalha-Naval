package poo.projeto;

public class Navio {
    private int tamanho;
    private char orientacao;
    
    public Navio(int tamanho, char orientacao)
    {
        this.tamanho = tamanho;
        this.orientacao = orientacao;
    }
    
    public String[] posicoes(String posicaoInicial) {
        String[] posicao = new String[getTamanho()];
        char primeira, segunda;

        primeira = posicaoInicial.charAt(0);
        segunda = posicaoInicial.charAt(1);
        posicao[0] = posicaoInicial;

        if(getOrientacao() == 'h' || getOrientacao() == 'H') {

            for(int i=1; i<getTamanho(); i++) {
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
