package poo.projeto;

import java.io.IOException;
import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) throws IOException, InterruptedException {
        int gamer;
        Tabuleiro campoBatalha = new Tabuleiro(13, 13);
        campoBatalha.inicializarTabuleiro();
        campoBatalha.imprimirTabuleiro();

        Arquivo turno = new Arquivo();
        turno.criarControladorTurno();
        gamer = definirJogador();
        
        definirJogadas(gamer, campoBatalha, turno);
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
    
    public static void definirJogadas(int gamer, Tabuleiro campoBatalha, Arquivo turno) throws IOException, InterruptedException {
        if(gamer == 3) {
            turno.setPathAdversario("[1].txt");
            JogadorComputador pc = new JogadorComputador(3, turno);
            pc.disporNavios();
            pc.jogadas(campoBatalha);
        } 
        else {
            Jogador player = new Jogador(gamer, turno);
            if(gamer == 1) {
                turno.escrever(turno.getPathControladorDeTurno(), "1");
                turno.setPathAdversario("[" + player.getPlayerAdvs() + "]");
            }
            else {
                turno.setPathAdversario("[1].txt");
            }
            player.disporNavios();
            player.jogadas(campoBatalha);
        }
    }
}
