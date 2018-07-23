package poo.projeto;

import java.util.Random;

public class JogadorComputador extends Jogador {
      private Arquivo arq;
    @Override
    public char lerOrientacao() {
        Random jogada = new Random();
        int orientacao=jogada.nextInt(2);
        return (char) orientacao;
    }
     @Override
     public int[] lerPosicaoNavioTanque(char orientacao) {
        int [] posicoesNavioTanque = new String[5];
        Random marca=new Random();
        int posicao=marca.nextInt(9);
        
      
        
        NavioTanque navioTanque = new NavioTanque(orientacao);
        posicoesNavioTanque = navioTanque.posicoes(posicao);
        
        for(int i=0; i<posicoesNavioTanque.length; i++){
            arq.escrever(arq.getPath(), posicoesNavioTanque[i]);
        }
        
        System.out.println();
        
        return  posicoesNavioTanque;
    }
     @Override
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
     @Override
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
     @Override
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
     @Override
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
    
    
    
    @Override
    public void disporNavios() {
        
        /*Aqui desenvolver o metodo de disposição dos navios imprimindo frases 
        após cada inserção de um novo navio, mantendo a ordem de inserção, sendo
        o primeiro de 5 posições, depois de 4, depois de 3, depois de 3, depois 
        de 2. Vale lembrar que é interessante usar os metodos existentes na
        superclasse pois há um DE-PARA de posições incrmenetando 2 no valor
        digitado pelo usuário. Uma forma como pensei em implementar foi utilizar
        um laço while que espera o usuário digitar algum caracter ou enter, algo
        do tipo para que o metodo gere uma nova posicao a ser inserida, fazendo
        com que assim o arquivo receba uma posição por vez. Fazer algo similar
        com a implementacao do metodo que irá gerar uma posicao a ser dado
        tiro, pois se não houver uma trava do tipo esperar um comando, o 
        computador irá realizar diversas jogadas enquanto o jogador ainda
        estiver pensando em realizar algum tiro.
        */
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
    
    @Override
    public void jogadas(Tabuleiro tab) {
    }
}
    