package poo.projeto;

import java.io.IOException;
import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) throws IOException {
        int gamer;
        Tabuleiro campoBatalha = new Tabuleiro(13, 13);
        campoBatalha.inicializarTabuleiro();
        campoBatalha.imprimirTabuleiro();

        Arquivo arq = new Arquivo();
        arq.criarControladorTurno();
        
        gamer = definirJogador();
        
        definirJogadas(gamer, campoBatalha);
    }

    public static int definirJogador() {
        Scanner scan = new Scanner(System.in);
        int gamer;
        System.out.print("Digite 1 p/ 'Player 1', " + 
                "2 p/ 'Player 2' " +
                "ou 3 p/ 'Computador': ");
        
        gamer = scan.nextInt();
        
        while(gamer != 1 && gamer != 2 && gamer != 3) {
            System.out.println("Número inválido!");
            System.out.println("Digite 1 p/ 'Player 1', 2 p/ 'Player 2 ou "
                    + "3 p/ 'Computador': ");
            gamer = scan.nextInt();
        }
        
        return gamer;
    }
    
    public static void definirJogadas(int gamer, Tabuleiro campoBatalha) throws IOException {
        if(gamer == 3) {
            JogadorComputador pc = new JogadorComputador(3);
            pc.disporNavios();
            pc.jogadas(campoBatalha);
        } 
        else {
            Jogador player = new Jogador(gamer);
            player.disporNavios();
            player.jogadas(campoBatalha);
        }
    }
}
