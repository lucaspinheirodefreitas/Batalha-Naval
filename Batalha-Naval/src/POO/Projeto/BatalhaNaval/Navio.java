package POO.Projeto.BatalhaNaval;

public class Navio {
    private int tamanho;
    private char orientacao;
    
    public Navio(int tamanho, char orientacao)
    {
        this.tamanho = tamanho;
        this.orientacao = orientacao;
    }
    
    /**
     *
     * @param posicao
     * @return
     */
    public String[] verificaPosicoes(String posicao){
        String[] posicoes = new String[this.tamanho];
        posicoes[0] = posicao;
        /*se posição horizontal o for deve ser implementado incrementando as colunas
          se posiçao for vertical o for deve ser implementado incrementando as linhas
          deve-se retornar um vetor com todas as posições a serem inseridas no arquivo ou deve-se a cada execução do for chamar o metodo que insere navios*/
        return posicoes;
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
