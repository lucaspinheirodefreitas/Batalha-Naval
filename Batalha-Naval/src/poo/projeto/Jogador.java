package poo.projeto;
import java.io.File;
import java.util.Scanner;

public class Jogador {
    
    Scanner scan = new Scanner(System.in);
    
    private String nome;
    private int player;
    private int playerAdvs;
    private Arquivo arq;
    
    public Jogador() {
        this.player = verificaGamer();
        this.nome = lerNome(player);
        this.playerAdvs = verificaGamerTipo(this.player);
        arq = gerArquivo(player, playerAdvs);
    }

    public int getPlayerAdvs() {
        return playerAdvs;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void setArq(Arquivo arq) {
        this.arq = arq;
    }

    
    public String getNome() {
        return nome;
    }

    public int getPlayer() {
        return player;
    }
    
    public Arquivo getArquivo(){
        return arq;
    }
    
    public int verificaGamer() {
        int gamer;
        
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
        return gamer;
    }
    
    public int verificaGamerTipo(int gamer) {
        int gamerTipo;
        
        if(gamer == 1) {
            System.out.println("-----------------------ESCOLHA DO ADVERSÁRIO!"
                    + "-----------------------");
            System.out.print("Digite 1 p/ o 'Computador'" +
                "ou 2 p/ outro 'Adversario': ");
            gamerTipo = scan.nextInt();
      
            while(gamerTipo != 1 && gamerTipo != 2) {
                System.out.println("Número inválido!");
                System.out.println("Digite 1 p/ 'Computador' ou 2 p/ 'Adversario': ");
                gamerTipo = scan.nextInt();
            }
            
            if(gamerTipo == 1) {
                gamerTipo = 3;
            }
            else {
                gamerTipo = 2;
            }
            System.out.println();
            return gamerTipo;
        }
        return 1;
    }
    
    public String lerNome(int gamer) {
        String nomeJogador;
        
        if(gamer == 1 || gamer == 2)
        {
            System.out.print("Digite o nome do Jogador: ");
            nomeJogador = scan.next();
            System.out.println();
        }
        else
        {
            nomeJogador = "Computador";
        }
        
        return nomeJogador;
    }
    
    public String geraPath(int gamer) {
        String path;
        
        path = ("[" + gamer + "].txt");
            
        return path;
    }
    
    public Arquivo gerArquivo(int gamer, int gamerAdvers){
        String path;
        String pathAdvers;
        Arquivo arquiv;
        
        path = geraPath(gamer);
        pathAdvers = geraPath(gamerAdvers);
        arquiv = new Arquivo(path, pathAdvers);
        
        return arquiv;
    }
    
    public void disporNavios() {
        boolean controle = true;
        char orientacao = ' ';
        String posicao;
        String[] posicoesPortaAvioes = new String[5];
        String[] posicoesNavioTanque = new String[4];
        String[] posicoesCruzador = new String[3];
        String[] posicoesSubmarino = new String[3];
        String[] posicoesDestruidor = new String[2];
        
        
        System.out.println("-------------------DEFINIÇÃO DA DISPOSIÇÃO DOS "
                + "NAVIOS!-------------------");
        /*-------------------------Porta-Aviões-------------------------------*/
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Porta-Aviões' [V - vertical] ou [H - horizontal]: ");
        orientacao = scan.next().charAt(0);
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Porta-Aviões' : de '[0-9] + [0-9]': ");
        posicao = scan.next();
        
        PortaAvioes portAvioes = new PortaAvioes(orientacao);
        posicoesPortaAvioes = portAvioes.posicoes(posicao);
        
        for(int i=0; i<posicoesPortaAvioes.length; i++){
            arq.escrever(arq.getPath(), posicoesPortaAvioes[i]);
        }
        
        System.out.println();
        
        /*-------------------------Navio-Tanque-------------------------------*/
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Navio-Tanque' [V - vertical] ou [H - horizontal]: ");
        orientacao = scan.next().charAt(0);
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Navio-Tanque' : de '[0-9] + [0-9]': ");
        posicao = scan.next();
        
        NavioTanque navioTanque = new NavioTanque(orientacao);
        posicoesNavioTanque = navioTanque.posicoes(posicao);
        
        for(int i=0; i<posicoesNavioTanque.length; i++){
            arq.escrever(arq.getPath(), posicoesNavioTanque[i]);
        }
        
        System.out.println();
        
        /*-----------------------------Cruzador-------------------------------*/
        
        orientacao = ' ';
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Cruzador' [V - vertical] ou [H - horizontal]: ");
        orientacao = scan.next().charAt(0);
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Cruzador' : de '[0-9] + [0-9]': ");
        posicao = scan.next();
        
        Cruzador navioCruzador = new Cruzador(orientacao);
        posicoesCruzador = navioCruzador.posicoes(posicao);
        
        for(int i=0; i<posicoesCruzador.length; i++){
            arq.escrever(arq.getPath(), posicoesCruzador[i]);
        }
        
        System.out.println();
        
        /*----------------------------Submarino-------------------------------*/
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Submarino' [V - vertical] ou [H - horizontal]: ");
        orientacao = scan.next().charAt(0);
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Submarino' : de '[0-9] + [0-9]': ");
        posicao = scan.next();
        
        Submarino sub = new Submarino(orientacao);
        posicoesSubmarino = sub.posicoes(posicao);
        
        for(int i=0; i<posicoesSubmarino.length; i++){
            arq.escrever(arq.getPath(), posicoesSubmarino[i]);
        }
        
        System.out.println();
        
        /*-----------------------------Destruidor-----------------------------*/
        
        orientacao = ' ';
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Destruidor' [V - vertical] ou [H - horizontal]: ");
        orientacao = scan.next().charAt(0);
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Destruidor' : de '[0-9] + [0-9]': ");
        posicao = scan.next();
        
        Destruidor dest = new Destruidor(orientacao);
        posicoesDestruidor = dest.posicoes(posicao);
        
        for(int i=0; i<posicoesDestruidor.length; i++){
            arq.escrever(arq.getPath(), posicoesDestruidor[i]);
        }
        
        System.out.println();
        
        /*
        int verifica = 0; 
        System.out.println("Digite 1 para fim do arquivo");
        verifica = scan.nextInt();
        
        if(verifica == 1)
            arq.acabou();
        
        
        
        if(verifica == 1)
            arq.deletarArquivo();
        */
    }
    
    public void disporNaviosRandom() {
        
    }
    
    public void buscarPos(Tabuleiro tab, String jogada, boolean achou) {
        int linha, coluna;
        char aux;
        aux = jogada.charAt(0);
        linha = Integer.parseInt(String.valueOf(aux)) + 2;
        aux = jogada.charAt(1);
        coluna = Integer.parseInt(String.valueOf(aux)) + 2;
        
        if(achou) {
            tab.setTabuleiro('x', linha, coluna);
        }
        else {
            tab.setTabuleiro('~', linha, coluna);
        }
    }
    
    public void jogadas(Tabuleiro tab) {
        boolean fim, achou, perdeu;
        String posicao;
        perdeu = false;
        fim = false;
        achou = false;
        int alvosAtingidos = 0;
        System.out.println("--------------------------------AGORA VOCÊ DEVE "
                + "DIGITAR AS POSIÇÕES CUJO DESEJA REALIZAR O ATAQUE!!!"
                + "--------------------------------");
        System.out.println();
        
        /*esse while é só pra teste, deve manter a condição de verificação de fim de jogo*/
        
        while(!fim) {
            System.out.print("Digite a posição cujo deseja atingir "
                +  ": de '[0-9] + [0-9]': ");
            posicao = scan.next();
            
            perdeu = arq.verificarFim(arq.getPathAdversario());
            
            if(perdeu || alvosAtingidos == 16) {
                arq.escrever(arq.getPath(), "fim");
                fim = true;
                //pensar melhor nessa implementação. Verificar a contagem de alvos atingidos.
            }
            else {
                achou = arq.buscar(arq.getPathAdversario(), posicao);
                if(achou) {
                    alvosAtingidos++;
                }
                buscarPos(tab, posicao, achou);
                System.out.println();
                tab.imprimirTabuleiro();
                System.out.println();
            
            }
        }
        System.out.println();
        if(perdeu) {
            System.out.println("Você foi derrotado!");
            //aqui talvez da pra colocar o nome
        }
        else {
            System.out.println("Fim de jogo, parabéns você venceu!");
            //aqui talvés da pra colocar o nome
        }
        System.out.println();
    }
   
}
