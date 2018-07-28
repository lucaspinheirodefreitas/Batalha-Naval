package poo.projeto;
import java.io.IOException;
import java.util.Scanner;

public class Jogador {
    
    Scanner scan = new Scanner(System.in);
    
    private String nome;
    private int player;
    private int playerAdvs;
    private Arquivo arq;
    private Arquivo turno;
    
    public Jogador(int player) {
        this.player = player;
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
    
    private int verificaGamerTipo(int gamer) {
        int gamerTipo;
        
        if(gamer == 1) {
            System.out.println("-----------------------ESCOLHA DO ADVERSÃ�RIO!"
                    + "-----------------------");
            System.out.print("Digite 1 p/ o 'Computador'" +
                "ou 2 p/ outro 'Adversario': ");
            gamerTipo = scan.nextInt();
      
            while(gamerTipo != 1 && gamerTipo != 2) {
                System.out.println("NÃºmero invÃ¡lido!");
                System.out.print("Digite 1 p/ 'Computador' ou 2 p/ 'Adversario': ");
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
    
    private String lerNome(int gamer) {
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
    
    private Arquivo gerArquivo(int gamer, int gamerAdvers){
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
            System.out.println("OrientaÃ§Ã£o invÃ¡lida!");
            System.out.print("Digite h p/ 'horizontal' ou v p/ 'vertical': ");
            orientacao = scan.next().charAt(0);
        }
        return orientacao;
    }
    
    public String[] lerPosicao(int tamanho, char orientacao) {
        String [] posicoes = new String[tamanho];
        String posicao;
        boolean validaPosicoes = false;
        
        posicao = scan.next();
        
        Navio navio = new Navio(tamanho, orientacao);
        posicoes = navio.posicoes(posicao);
        validaPosicoes = navio.validarPosicoes(posicoes);
        
        while(!validaPosicoes) {
            System.out.print("A posiÃ§Ã£o digitada Ã© invÃ¡lida, insira uma nova "
                    + "posiÃ§Ã£o: de '[0-9] + [0-9]': ");
            posicao = scan.next();
            posicoes = navio.posicoes(posicao);
            validaPosicoes = navio.validarPosicoes(posicoes);
        }
        for(int i=0; i<posicoes.length; i++){
            arq.escrever(arq.getPath(), posicoes[i]);
        }
        
        System.out.println();
        
        return posicoes;
    }
    
    public void disporNavios() {
        char orientacao = ' ';
        String posicao;
        String[] posicoesPortaAvioes = new String[5];
        String[] posicoesNavioTanque = new String[4];
        String[] posicoesCruzador = new String[3];
        String[] posicoesSubmarino = new String[3];
        String[] posicoesDestruidor = new String[2];
        
        System.out.println("-------------------DEFINIÃ‡ÃƒO DA DISPOSIÃ‡ÃƒO DOS "
                + "NAVIOS!-------------------");
        
        /*-------------------------Porta-AviÃµes-------------------------------*/
        
        System.out.print("Digite a orientaÃ§Ã£o cujo deseja inserir "
                + "o 'Porta-AviÃµes' [V - vertical] ou [H - horizontal]: ");
        
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posiÃ§Ã£o cujo deseja inserir "
                + "o 'Porta-AviÃµes' : de '[0-9] + [0-9]': ");
        
        posicoesPortaAvioes = lerPosicao(5, orientacao);
        
        /*-------------------------Navio-Tanque-------------------------------*/
        
        System.out.print("Digite a orientaÃ§Ã£o cujo deseja inserir "
                + "o 'Navio-Tanque' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posiÃ§Ã£o cujo deseja inserir "
                + "o 'Navio-Tanque' : de '[0-9] + [0-9]': ");
        
        posicoesNavioTanque = lerPosicao(4, orientacao);
        
        /*-----------------------------Cruzador-------------------------------*/
        
        System.out.print("Digite a orientaÃ§Ã£o cujo deseja inserir "
                + "o 'Cruzador' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posiÃ§Ã£o cujo deseja inserir "
                + "o 'Cruzador' : de '[0-9] + [0-9]': ");
        posicoesCruzador = lerPosicao(3, orientacao);
        
        /*----------------------------Submarino-------------------------------*/
        
        System.out.print("Digite a orientaÃ§Ã£o cujo deseja inserir "
                + "o 'Submarino' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posiÃ§Ã£o cujo deseja inserir "
                + "o 'Submarino' : de '[0-9] + [0-9]': ");
        posicoesSubmarino = lerPosicao(3, orientacao);
        
        /*-----------------------------Destruidor-----------------------------*/
        
        System.out.print("Digite a orientaÃ§Ã£o cujo deseja inserir "
                + "o 'Destruidor' [V - vertical] ou [H - horizontal]: ");
        orientacao = lerOrientacao();
        
        System.out.print("Digite a posiÃ§Ã£o cujo deseja inserir "
                + "o 'Destruidor' : de '[0-9] + [0-9]': ");
        posicoesDestruidor = lerPosicao(2, orientacao);
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
    
    public void jogadas(Tabuleiro tab) throws IOException {
        boolean fim, achou, perdeu;
        String posicao;
        perdeu = false;
        fim = false;
        achou = false;
        int alvosAtingidos = 0;
        
        System.out.println("--------------------------------AGORA VOCÃŠ DEVE "
                + "DIGITAR AS POSIÃ‡Ã•ES CUJO DESEJA REALIZAR O ATAQUE!!!"
                + "--------------------------------");
        System.out.println();
        
        tab.imprimirTabuleiro();
        
        System.out.println();
        
        
        
       	System.out.println(arq.verificarTurno());
        	 
        while(!fim) {
        	
        	while(arq.verificarTurno().charAt(0) != Integer.toString(this.player).charAt(0)) {
        		
        	}
        	
        	//while(arq.verificarTurno().charAt(0) == '1' || arq.verificarTurno().charAt(0) == '2') {
        	
	            perdeu = arq.verificarFim(arq.getPathAdversario());
	            if(perdeu) {
	                fim = true;
	            }
	            
	            else if(alvosAtingidos == 17) {
	                arq.escrever(arq.getPath(), "fim");
	                fim = true;
	                
	            } else {
	                System.out.print("Digite a posiÃ§Ã£o cujo deseja atingir "+": de '[0-9] + [0-9]': ");
	                posicao = scan.next();
	                achou = arq.buscar(arq.getPathAdversario(), posicao);
	                if(achou) {
	                    alvosAtingidos++;
	                }
		            buscarPos(tab, posicao, achou);
		            System.out.println();
		            tab.imprimirTabuleiro();
		            System.out.println();
		            arq.alterarTurno();
		            System.out.println("Aguarde sua vez de jogar!");
	            	}
        	}
        	System.out.println();
        //}  
        
        if(perdeu) {
            System.out.println(this.getNome() + ", vocÃª foi derrotado!");
        }
        else {
            System.out.println("Fim de jogo, parabÃ©ns " + this.getNome() + 
                    ", vocÃª venceu!");
        }
        
        arq.deletarArquivo();
        
        System.out.println();
    }
}