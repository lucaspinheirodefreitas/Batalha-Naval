package poo.projeto;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class JogadorComputador extends Jogador {
    
    Random gerador = new Random();
    
    public JogadorComputador(int player, Arquivo turno) {
       super(player, turno);
       
    }
    
    @Override
    public void disporNavios() throws InterruptedException {
        char orientacao;
        boolean controle = false;
        
        System.out.println("--------------------DEFINIÇÃO DA DISPOSIÇÃOO DOS "
                + "NAVIOS!-------------------");
        /*-------------------------Porta-AviÃµes-------------------------------*/
        
        orientacao = lerOrientacao();
        lerPosicao(5, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Porta-Aviões!");
        
        /*-------------------------Navio-Tanque-------------------------------*/
        
        orientacao = lerOrientacao();
        lerPosicao(4, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Navio-Tanque!");
        
        /*-----------------------------Cruzador-------------------------------*/
        
        orientacao = lerOrientacao();
        lerPosicao(3, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Cruzador!");
        /*----------------------------Submarino-------------------------------*/
        
        orientacao = lerOrientacao();
        lerPosicao(3, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Submarino!");
        
        /*-----------------------------Destruidor-----------------------------*/
        
        orientacao = lerOrientacao();
        lerPosicao(2, orientacao);
        
        System.out.println("O computador definiu a posição que será inserido "
                + "o Destruidor!");
        
        System.out.println();
        
        System.out.println("O computador já definiu a disposição de todos os "
                + "navios!");
    }
    
    public char lerOrientacao() {
        int orientacao;
        orientacao = gerador.nextInt(2);
        
        if(orientacao == 0) {
            return 'h';
        }
        else {
            return 'v';
        }
    }
    
    @Override
    public void lerPosicao(int tamanho, char orientacao) throws InterruptedException {
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
    }  
    @SuppressWarnings("unchecked")
    @Override
    public void jogadas(Tabuleiro tab) throws InterruptedException, IOException {
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
                + "IRÁ DEFINIR AS JOGADAS QUE REALIZARÁ PARA TE ATACAR!!!"
                + "--------------------------------");
        
        tab.imprimirTabuleiro();
        
        System.out.println();
        
        getArq().aguardaInsercao();
        
        while(!fim) {
            
            while(getTurno().verificarTurno().charAt(0) != Integer.toString(this.getPlayer()).charAt(0)) {
                Thread.sleep(1000);
            }
            perdeu = getArq().verificarFim(getArq().getPathAdversario());
            if(perdeu) {
                fim = true;
            }
            else if(alvosAtingidos == 17) {
                getArq().escrever(getArq().getPath(), "fim");
                fim = true;
                getTurno().alterarTurno();
            }
            else {
                System.out.print("Digite a posição cujo deseja atingir " 
                        + ": de '[0-9] + [0-9]': ");
                //AQUI COMEÇA A INTELIGÊNCIA DO PC 
                if (acertouH) {
                    auxPosicao = auxPosicao;
                    posicao = Integer.toString(auxPosicao);
                    auxPosicao2 = auxPosicao2+1;
                    posicao += Integer.toString(auxPosicao2);
                    guardaPosicao.add(posicao);
                    tenta = true;
                } 
                else if(acertouV) {
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
                        System.out.println(posicao);
                        if (guardaPosicao.contains(posicao)){
                                verifica = true;
                                guardaPosicao.add(posicao);
                        }

                        else {
                                verifica = false;
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
            getTurno().alterarTurno();
            //System.out.println("Aguarde sua vez de jogar.");
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

    getArq().deletarArquivo();

    System.out.println();
    }
}
