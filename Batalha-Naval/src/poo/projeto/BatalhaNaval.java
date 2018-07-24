package poo.projeto;

public class BatalhaNaval {

    public static void main(String[] args) {
        
        Tabuleiro campoBatalha = new Tabuleiro(13, 13);
        campoBatalha.inicializarTabuleiro();
        campoBatalha.imprimirTabuleiro();
        Jogador player = new Jogador();
        if(player.getPlayer() == 3) {
            ((JogadorComputador)player).disporNavios();
            ((JogadorComputador)player).jogadas(campoBatalha);
        }
        else {
            player.disporNavios();
            player.jogadas(campoBatalha);
        }
    }
}
