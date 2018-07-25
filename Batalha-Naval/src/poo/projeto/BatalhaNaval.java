package poo.projeto;

import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gamer;
        Tabuleiro campoBatalha = new Tabuleiro(13, 13);
        campoBatalha.inicializarTabuleiro();
        campoBatalha.imprimirTabuleiro();
                
        System.out.print("Digite 1 p/ 'Player 1', " + 
                "2 p/ 'Player 2' " +
                "ou 3 p/ 'Computador': ");
        
        
        gamer = scan.nextInt();
        
        while(gamer != 1 && gamer != 2 && gamer != 3)
        {
            System.out.println("Número inválido!");
            System.out.println("Digite 1 p/ 'Player 1', 2 p/ 'Player 2 ou "
                    + "3 p/ 'Computador': ");
            
            gamer = scan.nextInt();
        }  
        
        if(gamer == 3) {
            JogadorComputador pc = new JogadorComputador(3);
            pc.disporNavios();
            /*
            ((JogadorComputador)player).disporNavios();
            ((JogadorComputador)player).jogadas(campoBatalha);
            esse casting não funcionou.
            */
        }
        else {
            Jogador player = new Jogador(gamer);
            player.disporNavios();
            player.jogadas(campoBatalha);
        }
    }
}
