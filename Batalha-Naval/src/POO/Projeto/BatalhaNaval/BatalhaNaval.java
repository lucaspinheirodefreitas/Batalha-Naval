package POO.Projeto.BatalhaNaval;


public class BatalhaNaval {

    public static void main(String[] args) {
        
        //instanciar tabuleiro
        Jogador player = new Jogador();
        disporNavios(player);
        //player.jogadas();
        
        
    }
    
    public static void disporNavios(Jogador jogador) {
        
        if(jogador.getPlayer() == 3) {
            jogador.disporNaviosRandom();
        }
        else {
            jogador.disporNavios();
        }
    }
}
