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
    
    public boolean validarPosicoes(String[] posicoes) {
        char primeira, segunda;
        int verificaPrimeira, verificaSegunda;
        
        for(int i=0; i<posicoes.length; i++) {
            //System.out.println("Antes.");
            primeira = posicoes[i].charAt(0);
            segunda = posicoes[i].charAt(1);
            //System.out.println("Depois.");
            //System.out.println(primeira);
            //System.out.println(segunda);
            verificaPrimeira = Integer.parseInt(String.valueOf(primeira));
            //System.out.println("VerificaPrimeira.");
            //System.out.println(verificaPrimeira);
            verificaSegunda = Integer.parseInt(String.valueOf(segunda));
            //System.out.println("verificaSegunda.");
            //System.out.println(verificaSegunda);
            if((verificaPrimeira == 9 && i<(posicoes.length-1)) || (verificaSegunda == 9 && i<(posicoes.length-1))) {
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
