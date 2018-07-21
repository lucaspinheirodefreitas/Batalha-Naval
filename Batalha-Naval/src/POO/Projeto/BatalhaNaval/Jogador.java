package POO.Projeto.BatalhaNaval;
import java.util.Scanner;

public class Jogador {
    
    Scanner scan = new Scanner(System.in);
    
    private String nome;
    private int player;
    private Arquivo arq;
    
    public Jogador()
    {
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
    
    public String lerNome(int gamer)
    {
        String nomeJogador;
        
        if(gamer == 1 || gamer == 2)
        {
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
        arquiv = new Arquivo(path, true);
        
        return arquiv;
    }
    
    public void disporNavios() {
        boolean controle = true;
        char orientacao = ' ';
        String posicao;
        String[] posicoesPortaAvioes = new String[5];
        String[] posicoesCruzador = new String[3];
        
        
        System.out.println("Digite a horientação cujo deseja inserir "
                + "o 'Porta-Aviões [V - vertical] ou [H - horizontal");
        while(orientacao != 'h' && orientacao != 'H' 
                && orientacao != 'v' && orientacao != 'E') {
            orientacao = scan.next().charAt(0);
        }
        
        /*Observação: o controle para verificar se a posição é válida ou não 
        deve ser realizado apenas pelo usuário, essa condiçãp não é válidada 
        neste programa*/
        
        System.out.println("Digite a posição cujo deseja inserir "
                + "o 'Porta-Aviões' : de '[A-J] + [0-9]'");
        posicao = scan.next();
        
        PortaAvioes portAvioes = new PortaAvioes(orientacao);
        
        posicoesPortaAvioes = portAvioes.posicoes(posicao);
        
        for(int i=0; i<posicoesPortaAvioes.length; i++)
        {
            arq.gravarPosicao(posicoesPortaAvioes[i]);
        }
        
    }
    
    public void disporNaviosRandom() {
        
    }
    
    public void jogadas() {
        
    }
   
}
