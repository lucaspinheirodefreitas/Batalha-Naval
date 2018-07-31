package poo.projeto;

import java.io.IOException;
import java.util.Scanner;

public class Jogador {

    Scanner scan = new Scanner(System.in);

    private String nome;
    private int player;
    private final int playerAdvs;
    private Arquivo arq;
    private final Arquivo turno;

    public Jogador(int player, Arquivo turno) {
        this.player = player;
        this.nome = lerNome(player);
        this.playerAdvs = verificaGamerTipo(this.player);
        arq = gerArquivo(player, playerAdvs);
        this.turno = turno;
    }

    public Arquivo getTurno() {
        return turno;
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

    public Arquivo getArq() {
        return arq;
    }

    private int verificaGamerTipo(int gamer) {
        int gamerTipo;

        if (gamer == 1) {
            System.out.println("-----------------------ESCOLHA DO ADVERSÁRIO!" 
                    + "-----------------------");
            System.out.print("Digite 1 para jogar contra o 'Computador' "
                        + "ou 2 para jogar contra outro 'Adversario': ");
            gamerTipo = scan.nextInt();

            while (gamerTipo != 1 && gamerTipo != 2) {
                System.out.println("Número inválido!");
                System.out.print("Digite 1 para jogar contra o 'Computador' "
                        + "ou 2 para jogar contra outro 'Adversario': ");
                gamerTipo = scan.nextInt();
            }

            if (gamerTipo == 1) {
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

    private String lerNome(int gamer) {
        String nomeJogador;

        if (gamer == 1 || gamer == 2) {
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

    private Arquivo gerArquivo(int gamer, int gamerAdvers) {
        String path;
        String pathAdvers;
        Arquivo arquiv;

        path = geraPath(gamer);
        pathAdvers = geraPath(gamerAdvers);
        arquiv = new Arquivo(path, pathAdvers);

        return arquiv;
    }
    
    public void lerPosicao(int tamanho, char orientacao) throws InterruptedException {
        String[] posicoes;
        String posicao;
        boolean validaPosicoes, verificaRepeticao;

        posicao = scan.next();
        
        arq.criarArquivo(arq.getPath());
        Navio navio = new Navio(tamanho, orientacao);
        posicoes = navio.posicoes(posicao);
        validaPosicoes = navio.validarPosicoes(posicoes);
        verificaRepeticao = navio.verificaRepeticao(arq, posicoes);

        while (verificaRepeticao || !validaPosicoes) {
            if (verificaRepeticao) {
                System.out.println("A posição já está sendo usada por outro Navio.");
            } 
            else {
                System.out.println("A posição extrapola os limites do tabuleiro!");
            }
            System.out.print("Insira uma nova " + "posição: de '[0-9] + [0-9]': ");

            posicao = scan.next();
            posicoes = navio.posicoes(posicao);
            validaPosicoes = navio.validarPosicoes(posicoes);
            verificaRepeticao = navio.verificaRepeticao(arq, posicoes);
        }
        
        for (int i=0; i < posicoes.length; i++) {
            arq.escrever(arq.getPath(), posicoes[i]);
        }
        System.out.println();
    }

    public void disporNavios() throws InterruptedException {
        char orientacao = ' ';
        System.out.println("-------------------DEFINIÇÃO DA DISPOSIÇÃO DOS " 
                + "NAVIOS!-------------------");

        /*-------------------------Porta-AviÃµes-------------------------------*/

        PortaAvioes portAvioes = new PortaAvioes(5);
        orientacao = portAvioes.orientacao();
        portAvioes.setOrientacao(orientacao);
        portAvioes.posicaoIni();
        lerPosicao(portAvioes.getTamanho(), orientacao);

        /*-------------------------Navio-Tanque-------------------------------*/

        NavioTanque navioTanque = new NavioTanque(4);
        orientacao = navioTanque.orientacao();
        navioTanque.setOrientacao(orientacao);
        navioTanque.posicaoIni();
        lerPosicao(navioTanque.getTamanho(), orientacao);

        /*-----------------------------Cruzador-------------------------------*/
        Cruzador cruzador = new Cruzador(3);
        orientacao = cruzador.orientacao();
        cruzador.setOrientacao(orientacao);
        cruzador.posicaoIni();
        lerPosicao(cruzador.getTamanho(), orientacao);

        /*----------------------------Submarino-------------------------------*/

        Submarino submarino = new Submarino(3);
        orientacao = submarino.orientacao();
        submarino.setOrientacao(orientacao);
        submarino.posicaoIni();
        lerPosicao(submarino.getTamanho(), orientacao);

        /*-----------------------------Destruidor-----------------------------*/

        Destruidor destruidor = new Destruidor(2);
        orientacao = destruidor.orientacao();
        destruidor.setOrientacao(orientacao);
        destruidor.posicaoIni();
        lerPosicao(destruidor.getTamanho(), orientacao);
    }

    public void buscarPos(Tabuleiro tab, String jogada, boolean achou) {
        int linha, coluna;
        char aux;
        aux = jogada.charAt(0);
        linha = Integer.parseInt(String.valueOf(aux)) + 2;
        aux = jogada.charAt(1);
        coluna = Integer.parseInt(String.valueOf(aux)) + 2;

        if (achou) {
            tab.setTabuleiro('x', linha, coluna);
        } 
        else {
            tab.setTabuleiro('~', linha, coluna);
        }
    }

    public void jogadas(Tabuleiro tab) throws IOException, InterruptedException {
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
        
        arq.aguardaInsercao();
        
        while (!fim) {

            while (turno.verificarTurno().charAt(0) != Integer.toString(this.player).charAt(0)) {
                Thread.sleep(700);
            }

            perdeu = arq.verificarFim(arq.getPathAdversario());
            if (perdeu) {
                System.out.println(this.getNome() + ", você foi derrotado!");
                fim = true;
            }
            else if (alvosAtingidos == 17) {
                System.out.println("Fim de jogo, parabéns " + this.getNome() + ", você venceu!");
                arq.escrever(arq.getPath(), "fim");
                fim = true;
                turno.alterarTurno();
            } 
            else {
                System.out.print("Digite a posição cujo deseja atingir " 
                        + ": de '[0-9] + [0-9]': ");
                posicao = scan.next();
                achou = arq.buscar(arq.getPathAdversario(), posicao);
                if (achou) {
                        alvosAtingidos++;
                }
                buscarPos(tab, posicao, achou);
                System.out.println();
                tab.imprimirTabuleiro();
                System.out.println();
                turno.alterarTurno();
                //System.out.println("Aguarde sua vez de jogar!");
            }
        }
        System.out.println();
        arq.deletarArquivo();
        System.out.println();
    }
}
