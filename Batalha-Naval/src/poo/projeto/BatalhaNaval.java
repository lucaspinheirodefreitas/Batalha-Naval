package poo.projeto;

public class BatalhaNaval {

    public static void main(String[] args) {
        
        Tabuleiro campoBatalha = new Tabuleiro(13, 13);
        campoBatalha.inicializarTabuleiro();
        campoBatalha.imprimirTabuleiro();
        Jogador player = new Jogador();
        disporNavios(player);
        player.jogadas(campoBatalha);
        
    }
    
    public static void disporNavios(Jogador jogador) {
        
        if(jogador.getPlayer() == 3) {
            //((JogadorComputador)jogador).escreverAquiNomeDoMetodo;
        }
        else {
            jogador.disporNavios();
        }
    }
}
