package poo.projeto;
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
        
        if(gamer == 1 || gamer == 2) {
            System.out.print("Digite o nome do Jogador: ");
            nomeJogador = scan.next();
            System.out.println();
        }
        else {
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
    
    public char lerOrientacao() {
        char orientacao;
        orientacao = scan.next().charAt(0);
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            System.out.println("Orientação inválida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        return orientacao;
    }
    
    /*Pensei em uma melhoria que irá reduzir muito a quantidade de códigos, 
    basta passar como parametro o tamanho que deve ter cada tipo de navio,
    ai a função ler posições receberia como parâmetro a orientação e o tamanho
    Basta alterar um dos metodos para um formato mais generico e deletar os 
    demais, ai bastaria também alterar o nome do metodo na chamada que seria 
    mais generico, tipo lerPosicao.
    */
    public String[] lerPosicaoNavioTanque(char orientacao) {
        String [] posicoesNavioTanque = new String[5];
        String posicao;
        
        posicao = scan.next();
        
        NavioTanque navioTanque = new NavioTanque(orientacao);
        posicoesNavioTanque = navioTanque.posicoes(posicao);
        
        for(int i=0; i<posicoesNavioTanque.length; i++){
            arq.escrever(arq.getPath(), posicoesNavioTanque[i]);
        }
        
        System.out.println();
        
        return posicoesNavioTanque;
    }
    
    public String[] lerPosicaoPortaAvioes(char orientacao) {
        String [] posicoesPortaAvioes = new String[4];
        String posicao;
        
        posicao = scan.next();
        PortaAvioes portAvioes = new PortaAvioes(orientacao);
        posicoesPortaAvioes = portAvioes.posicoes(posicao);
        
        for(int i=0; i<posicoesPortaAvioes.length; i++){
            arq.escrever(arq.getPath(), posicoesPortaAvioes[i]);
        }
        
        System.out.println();
        
        return posicoesPortaAvioes;
    }
    
    public String[] lerPosicaoCruzador(char orientacao) {
        String [] posicoesCruzador = new String[3];
        String posicao;
        
        posicao = scan.next();
        Cruzador navioCruzador = new Cruzador(orientacao);
        posicoesCruzador = navioCruzador.posicoes(posicao);
        
        for(int i=0; i<posicoesCruzador.length; i++){
            arq.escrever(arq.getPath(), posicoesCruzador[i]);
        }
        
        System.out.println();
        
        return posicoesCruzador;
    }
    
    public String[] lerPosicaoSubmarino(char orientacao) {
        String[] posicoesSubmarino = new String[3];
        String posicao;
        
        posicao = scan.next();
        
        Submarino sub = new Submarino(orientacao);
        posicoesSubmarino = sub.posicoes(posicao);
        
        for(int i=0; i<posicoesSubmarino.length; i++){
            arq.escrever(arq.getPath(), posicoesSubmarino[i]);
        }
        
        System.out.println();
        
        return posicoesSubmarino;
    }
    
    public String[] lerPosicaoDestruidor(char orientacao) {
        String[] posicoesDestruidor = new String[2];
        String posicao;
        
        posicao = scan.next();
        
        Destruidor dest = new Destruidor(orientacao);
        posicoesDestruidor = dest.posicoes(posicao);
        
        for(int i=0; i<posicoesDestruidor.length; i++){
            arq.escrever(arq.getPath(), posicoesDestruidor[i]);
        }
        
        System.out.println();
        
        return posicoesDestruidor;
    }
    
    /*Observação: o controle para verificar se a posição é válida ou não 
    deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
    neste programa*/
    
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
        
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Porta-Aviões' : de '[0-9] + [0-9]': ");
        
        posicoesPortaAvioes = lerPosicaoPortaAvioes(orientacao);
        
        /*-------------------------Navio-Tanque-------------------------------*/
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Navio-Tanque' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Navio-Tanque' : de '[0-9] + [0-9]': ");
        
        posicoesNavioTanque = lerPosicaoNavioTanque(orientacao);
        
        /*-----------------------------Cruzador-------------------------------*/
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Cruzador' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Cruzador' : de '[0-9] + [0-9]': ");
        posicoesCruzador = lerPosicaoCruzador(orientacao);
        
        /*----------------------------Submarino-------------------------------*/
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Submarino' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Submarino' : de '[0-9] + [0-9]': ");
        posicoesSubmarino = lerPosicaoSubmarino(orientacao);
        /*-----------------------------Destruidor-----------------------------*/
        
        orientacao = ' ';
        
        System.out.print("Digite a orientação cujo deseja inserir "
                + "o 'Destruidor' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posição cujo deseja inserir "
                + "o 'Destruidor' : de '[0-9] + [0-9]': ");
        posicoesDestruidor = lerPosicaoDestruidor(orientacao);
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
        
        tab.imprimirTabuleiro();
        
        System.out.println();
        
        while(!fim) {
            perdeu = arq.verificarFim(arq.getPathAdversario());
            
            if(perdeu) {
                fim = true;
            }
            else if(alvosAtingidos == 17) {
                arq.escrever(arq.getPath(), "fim");
                fim = true;
            }
            else {
                System.out.print("Digite a posição cujo deseja atingir "
                +  ": de '[0-9] + [0-9]': ");
                posicao = scan.next();
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
            System.out.println(this.getNome() + ", você foi derrotado!");
        }
        else {
            System.out.println("Fim de jogo, parabéns " + this.getNome() + 
                    ", você venceu!");
        }
        
        arq.deletarArquivo();
        
        System.out.println();
    }
}