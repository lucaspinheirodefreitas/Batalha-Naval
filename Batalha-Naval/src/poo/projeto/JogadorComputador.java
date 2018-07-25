package poo.projeto;

import java.util.Random;

public class JogadorComputador extends Jogador {
    
    Random gerador = new Random();
    
    public JogadorComputador(int player) {
       super(player);
    }
    
    @Override
    public void disporNavios() {
        char orientacao;
        boolean controle = false;
        String posicao;
        String[] posicoesPortaAvioes = new String[5];
        String[] posicoesNavioTanque = new String[4];
        String[] posicoesCruzador = new String[3];
        String[] posicoesSubmarino = new String[3];
        String[] posicoesDestruidor = new String[2];
        
        System.out.println("--------------------DEFINIÇÃO DA DISPOSIÇÃO DOS "
                + "NAVIOS!-------------------");
        /*-------------------------Porta-Aviões-------------------------------*/
        
        orientacao = lerOrientacao();
        System.out.println(orientacao);
        posicoesPortaAvioes = lerPosicao(5, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Porta-Aviões!");
        
        /*-------------------------Navio-Tanque-------------------------------*/
        
        orientacao = lerOrientacao();
        System.out.println(orientacao);
        posicoesNavioTanque = lerPosicao(4, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Navio-Tanque!");
        
        /*-----------------------------Cruzador-------------------------------*/
        
        orientacao = lerOrientacao();
        System.out.println(orientacao);
        posicoesCruzador = lerPosicao(3, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Cruzador!");
        /*----------------------------Submarino-------------------------------*/
        
        orientacao = lerOrientacao();
        System.out.println(orientacao);
        posicoesSubmarino = lerPosicao(3, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Submarino!");
        
        /*-----------------------------Destruidor-----------------------------*/
        
        orientacao = lerOrientacao();
        System.out.println(orientacao);
        posicoesDestruidor = lerPosicao(2, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Destruidor!");
        
        System.out.println();
        
        System.out.println("O computador já definiu a disposição de todos os "
                + "navios, quando concluir a inserção dos seus Navios, digite "
                + "'s' para que o computador dê o primeiro tiro!");
        
        while(!controle) {
            char fimDisposicao = scan.next().charAt(0);
            
            if(fimDisposicao == 's' || fimDisposicao == 'S') {
                controle = true;
            }
            else {
                while(fimDisposicao != 's' && fimDisposicao != 'S') {
                    System.out.println("Letra inválida, digite 's' para "
                            + "prosseguir com o jogo!");
                    fimDisposicao = scan.next().charAt(0);
                }
                controle = true;
            }
        }
    }
    
    @Override
    public char lerOrientacao() {
        int orientacao;
        //gera numeros aleatorios entre 0 e (n-1), neste caso (n = 2)
        orientacao = gerador.nextInt(2);
        
        if(orientacao == 0) {
            return 'h';
        }
        else {
            return 'v';
        }
    }
    
    @Override
    public String[] lerPosicao(int tamanho, char orientacao) {
        boolean validaPosicoes, verificaRepeticao;
        int auxPosicao;
        String [] posicoes;
        String posicao;
        
        super.getArquivo().criarArquivo(super.getArquivo().getPath());
        auxPosicao = gerador.nextInt(10);
        posicao = Integer.toString(auxPosicao);
        auxPosicao = gerador.nextInt(10);
        posicao += Integer.toString(auxPosicao);

        Navio navio = new Navio(tamanho, orientacao);
        posicoes = navio.posicoes(posicao);
        validaPosicoes = navio.validarPosicoes(posicoes);
        verificaRepeticao = navio.verificaRepeticao(super.getArquivo(), posicoes);
        
        while(verificaRepeticao || !validaPosicoes) {
            auxPosicao = gerador.nextInt(10);
            posicao = Integer.toString(auxPosicao);
            auxPosicao = gerador.nextInt(10);
            posicao += Integer.toString(auxPosicao);
            posicoes = navio.posicoes(posicao);
            validaPosicoes = navio.validarPosicoes(posicoes);
            verificaRepeticao = navio.verificaRepeticao(super.getArquivo(), posicoes);
        }
        
        for(int i=0; i<posicoes.length; i++){
            super.getArquivo().escrever(super.getArquivo().getPath(), posicoes[i]);
        }
        System.out.println();
        return posicoes;
    }  
    
    @Override
    public void jogadas(Tabuleiro tab) {
        boolean fim, achou, perdeu;
        String posicao;
        perdeu = false;
        fim = false;
        achou = false;
        int alvosAtingidos = 0;
        
        System.out.println("--------------------------------AGORA O COMPUTADOR "
                + "IRÁ DEFINIR AS JOGADAS QUE REALIZARÁ PARA TE ATACAR!!!"
                + "--------------------------------");
        
        System.out.println("Note que será necessário digitar 's' "
                + "(no console referente as jogadas do computador) "
                + "após executar "
                + "sua jogada para que o computador possa realizar sua jogada!");
        
        /* 
        Não fiz nada daqui para baixo
        */
        
        tab.imprimirTabuleiro();
        
        System.out.println();
        
        while(!fim) {
            perdeu = getArquivo().verificarFim(getArquivo().getPathAdversario());
            
            if(perdeu) {
                fim = true;
            }
            else if(alvosAtingidos == 17) {
                getArquivo().escrever(getArquivo().getPath(), "fim");
                fim = true;
            }
            else {
                System.out.print("Digite a posição cujo deseja atingir "
                +  ": de '[0-9] + [0-9]': ");
                posicao = scan.next();
                achou = getArquivo().buscar(getArquivo().getPathAdversario(), posicao);
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
        
        getArquivo().deletarArquivo();
        
        System.out.println();
    }
}
