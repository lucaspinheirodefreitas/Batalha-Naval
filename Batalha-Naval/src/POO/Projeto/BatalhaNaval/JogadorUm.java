package POO.Projeto.BatalhaNaval;

public class JogadorUm extends Jogador {
    
    private char horientacao;
    private String posicao;
    
    public JogadorUm()
    {
        super();
        this.horientacao = ' ';
        this.posicao = " ";        
    }
    
    @Override
    public void jogadas()
    {
        
    }
    
    /*Talvez não será necessário ter uma classe JogadorUm e JogadorDois, apenas
    pensei que seria melhor incrementar apenas a subclasse JogadorComputador
    e nele criar um metodo para inserir posições aleatorias no arquivo, já para
    JogadorUm e JogadorDois imagino que os metodos podem ser similares aos 
    implementados na classe Jogador. Para o JogadorComputador será necessário
    apenas sobrescrever o método desenvolvido para jogadas (@override) na classe
    Jogador.
    */
    
    
    
}
