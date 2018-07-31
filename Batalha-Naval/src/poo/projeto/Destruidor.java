
package poo.projeto;

public class Destruidor extends Navio {
    
    public Destruidor(int tamanho) {
        super(tamanho);
    }  
    
    public char orientacao() {
        char orientacao;
        
        System.out.print("Digite a orientação cujo deseja inserir "
                        + "o 'Destruidor' [V - vertical] ou [H - horizontal]: ");
        orientacao = super.lerOrientacao();
        
        return orientacao;
    }
    
    public void posicaoIni() {
        System.out.print("Digite a posição cujo deseja inserir " + "o 'Destruidor' : de '[0-9] + [0-9]': ");
    }
}