package POO.Projeto.BatalhaNaval;
import java.util.Scanner;

public class Jogador {
    
    Scanner scan = new Scanner(System.in);
    
    private String nome;
    private int player;
    private Arquivo arq;
    
    public Jogador() {
        this.player = verificaGamer();
        this.nome = lerNome(player);
        arq = gerArquivo(player);
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
        System.out.println("Digite 1 p/ 'Player 1', " + 
                "2 p/ 'Player 2' " +
                "ou 3 p/ 'Computador'");
        gamer = scan.nextInt();
        
        while(gamer != 1 && gamer != 2 && gamer != 3)
        {
            System.out.println("Número inválido!");
            System.out.println("Digite 1 p/ 'Player 1' ou 3 p/ 'Computador'");
            gamer = scan.nextInt();
        }
        return gamer;
    }
    
    public String lerNome(int gamer) {
        String nomeJogador;
        
        if(gamer == 1 || gamer == 2)
        {
            System.out.print("Digite o nome do Jogador: ");
            nomeJogador = scan.next();
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
    
    public Arquivo gerArquivo(int gamer){
        String path;
        Arquivo arquiv;
        
        path = geraPath(gamer);
        arquiv = new Arquivo(path);
        
        return arquiv;
    }
    
    public void disporNavios() {
        boolean controle = true;
        char orientacao = ' ';
        String posicao;
        String[] posicoesPortaAvioes = new String[5];
        String[] posicoesCruzador = new String[4];
        String[] posicoesNavioTanque = new String[3];
        String[] posicoesSubmarino = new String[2];
        String[] posicoesDestruidor = new String[1];
        
        /*-------------------------Porta-Aviões-------------------------------*/
        
        System.out.println("Digite a orientação cujo deseja inserir "
                + "o 'Porta-Aviões' [V - vertical] ou [H - horizontal");
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'E') {
            System.out.println("Orientação inválida!");
            System.out.println("Digite h p/ 'horizontal' ou v p/ 'vertical'");
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.println("Digite a posição cujo deseja inserir "
                + "o 'Porta-Aviões' : de '[A-J] + [0-9]'");
        posicao = scan.next();
        
        PortaAvioes portAvioes = new PortaAvioes(orientacao);
        posicoesPortaAvioes[0] = posicao;
        posicoesPortaAvioes = portAvioes.posicoes(posicao);
        
        for(int i=0; i<posicoesPortaAvioes.length; i++){
            arq.escrever(arq.getPath(), posicoesPortaAvioes[i]);
        }
        
        /*-----------------------------Cruzador-------------------------------*/
        
        orientacao = ' ';
        
        System.out.println("Digite a orientação cujo deseja inserir "
                + "o 'Cruzador' [V - vertical] ou [H - horizontal");
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'V') {
            
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.println("Digite a posição cujo deseja inserir "
                + "o 'Cruzador' : de '[A-J] + [0-9]'");
        posicao = scan.next();
        
        Cruzador navioCruzador = new Cruzador(orientacao);
        posicoesCruzador[0] = posicao;
        posicoesCruzador = navioCruzador.posicoes(posicao);
        
        for(int i=0; i<posicoesCruzador.length; i++){
            arq.escrever(arq.getPath(), posicoesCruzador[i]);
        }
        
    }
    
    public void disporNaviosRandom() {
        
    }
    
    public void jogadas() {
        
    }
   
}
