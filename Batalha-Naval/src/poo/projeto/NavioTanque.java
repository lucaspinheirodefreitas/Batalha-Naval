
package poo.projeto;

public class NavioTanque extends Navio {
    
    public NavioTanque(int tamanho) {
        super(tamanho);
    }
    
    public char orientacao() {
        char orientacao;
        
        System.out.print("Digite a orientação cujo deseja inserir "
                        + "o 'Navio-Tanque' [V - vertical] ou [H - horizontal]: ");
        orientacao = super.lerOrientacao();
        
        return orientacao;
    }
    
    public void posicaoIni() {
        System.out.print("Digite a posição cujo deseja inserir " + "o 'Navio-Tanque' : de '[0-9] + [0-9]': ");
    }
}
