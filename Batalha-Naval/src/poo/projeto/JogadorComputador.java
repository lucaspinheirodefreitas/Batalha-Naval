package poo.projeto;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

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
        
        
        System.out.println("--------------------DEFINIÃ‡ÃƒO DA DISPOSIÃ‡ÃƒO DOS "
                + "NAVIOS!-------------------");
        /*-------------------------Porta-AviÃµes-------------------------------*/
        
        orientacao = lerOrientacao();
        posicoesPortaAvioes = lerPosicao(5, orientacao);
        
        System.out.println("O computador definiu a posiÃ§Ã£o que serÃ¡ inserido "
                + "o Porta-AviÃµes!");
        
        /*-------------------------Navio-Tanque-------------------------------*/
        
        orientacao = lerOrientacao();
        posicoesNavioTanque = lerPosicao(4, orientacao);
        
        System.out.println("O computador definiu a posiÃ§Ã£o que serÃ¡ inserido "
                + "o Navio-Tanque!");
        
        /*-----------------------------Cruzador-------------------------------*/
        
        orientacao = lerOrientacao();
        posicoesCruzador = lerPosicao(3, orientacao);
        
        System.out.println("O computador definiu a posiÃ§Ã£o que serÃ¡ inserido "
                + "o Cruzador!");
        /*----------------------------Submarino-------------------------------*/
        
        orientacao = lerOrientacao();
        posicoesSubmarino = lerPosicao(3, orientacao);
        
        System.out.println("O computador definiu a posiÃ§Ã£o que serÃ¡ inserido "
                + "o Submarino!");
        
        /*-----------------------------Destruidor-----------------------------*/
        
        orientacao = lerOrientacao();
        posicoesDestruidor = lerPosicao(2, orientacao);
        
        System.out.println("O computador definiu a posiÃ§Ã£o que serÃ¡ inserido "
                + "o Destruidor!");
        
        System.out.println();
        
        System.out.println("O computador jÃ¡ definiu a disposiÃ§Ã£o de todos os "
                + "navios, quando concluir a inserÃ§Ã£o dos seus Navios, digite "
                + "'s' para que o computador dÃª o primeiro tiro!");
        
        /*----------------------------------------------------------------------*/
        
        while(!controle) {
            char fimDisposicao = scan.next().charAt(0);
            
            if(fimDisposicao == 's' || fimDisposicao == 'S') {
                controle = true;
            }
            else {
                while(fimDisposicao != 's' && fimDisposicao != 'S') {
                    System.out.println("Letra invÃ¡lida, digite 's' para "
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
        
        super.getArq().criarArquivo(super.getArq().getPath());
        auxPosicao = gerador.nextInt(10);
        posicao = Integer.toString(auxPosicao);
        auxPosicao = gerador.nextInt(10);
        posicao += Integer.toString(auxPosicao);

        Navio navio = new Navio(tamanho, orientacao);
        posicoes = navio.posicoes(posicao);
        validaPosicoes = navio.validarPosicoes(posicoes);
        verificaRepeticao = navio.verificaRepeticao(super.getArq(), posicoes);
        
        while(verificaRepeticao || !validaPosicoes) {
            auxPosicao = gerador.nextInt(10);
            posicao = Integer.toString(auxPosicao);
            auxPosicao = gerador.nextInt(10);
            posicao += Integer.toString(auxPosicao);
            posicoes = navio.posicoes(posicao);
            validaPosicoes = navio.validarPosicoes(posicoes);
            verificaRepeticao = navio.verificaRepeticao(super.getArq(), posicoes);
        }
        
        for(int i=0; i<posicoes.length; i++){
            super.getArq().escrever(super.getArq().getPath(), posicoes[i]);
        }
        System.out.println();
        return posicoes;
    }  
    
    @Override
    public void jogadas(Tabuleiro tab) {
        boolean fim, achou, perdeu, acertouH, acertouV, tenta, verifica;
        ArrayList<String> guardaPosicao = new ArrayList();
        String posicao;
        perdeu = false;
        fim = false;
        achou = false;
        acertouH = false;
        acertouV = false;
        tenta = false;
        int auxPosicao=0;
        int auxPosicao2=0;

        int alvosAtingidos = 0;
        
        System.out.println("--------------------------------AGORA O COMPUTADOR "
                + "IRÃ� DEFINIR AS JOGADAS QUE REALIZARÃ� PARA TE ATACAR!!!"
                + "--------------------------------");
        
        /* 
        NÃ£o fiz nada daqui para baixo
        */
        
        tab.imprimirTabuleiro();
        
        System.out.println();
        
        
        while(!fim) {
            Arquivo arq = new Arquivo();
            try {
                while(arq.verificarTurno().charAt(0) != Integer.toString(this.getPlayer()).charAt(0)) {
                
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
      
            perdeu = getArq().verificarFim(getArq().getPathAdversario());

            if(perdeu) {
                fim = true;
            }
            else if(alvosAtingidos == 17) {
                getArq().escrever(getArq().getPath(), "fim");
                fim = true;
            }
            else {
                System.out.print("Digite a posiÃ§Ã£o cujo deseja atingir "
                +  ": de '[0-9] + [0-9]': ");
              //AQUI COMEÇA A INTELIGÊNCIA DO PC 
            if (acertouH) {
                auxPosicao = auxPosicao;
                posicao = Integer.toString(auxPosicao);
                auxPosicao2 = auxPosicao2+1;
                posicao += Integer.toString(auxPosicao2);
                guardaPosicao.add(posicao);
                System.out.println("la");
                tenta = true;
            } else if(acertouV) {
                System.out.println("aqui");
                auxPosicao = auxPosicao+1;
                posicao = Integer.toString(auxPosicao);
                auxPosicao2 = auxPosicao2-1;
                posicao += Integer.toString(auxPosicao2);
                guardaPosicao.add(posicao);
            }
            else {
        /*auxPosicao = gerador.nextInt(10);
        posicao = Integer.toString(auxPosicao);
        auxPosicao2 = gerador.nextInt(10);
        posicao += Integer.toString(auxPosicao2);
                guardaPosicao.add(posicao);*/
            do {
                auxPosicao = gerador.nextInt(10);
                posicao = Integer.toString(auxPosicao);
                auxPosicao2 = gerador.nextInt(10);
                posicao += Integer.toString(auxPosicao2);
                System.out.println("normal");
                if (guardaPosicao.contains(posicao)){
                        verifica = true;
                        guardaPosicao.add(posicao);
                }

                else {
                        verifica=false;
                }
            } while (verifica);
        }
        guardaPosicao.add(posicao);
        //AQUI TERMINA A INTELIGÊNICA DO PC  

        achou = getArq().buscar(getArq().getPathAdversario(), posicao);
        
        if(achou) {
            alvosAtingidos++;
                                acertouH = true;
        }
        else if(tenta) {
            acertouH = false;
            acertouV=true;
            tenta = false;
        }  
        else {
            acertouH = false;
            acertouV = false;
        }
        buscarPos(tab, posicao, achou);
        System.out.println();
        tab.imprimirTabuleiro();
        System.out.println();
        arq.alterarTurno();
        System.out.println("Aguarde sua vez de jogar.");
        }
    }
    System.out.println();
    if(perdeu) {
        System.out.println(this.getNome() + ", vocÃª foi derrotado!");
    }
    else {
        System.out.println("Fim de jogo, parabÃ©ns " + this.getNome() + 
                ", vocÃª venceu!");
    }

    getArq().deletarArquivo();

    System.out.println();
    }
}
