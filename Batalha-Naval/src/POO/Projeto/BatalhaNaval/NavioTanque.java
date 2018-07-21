package POO.Projeto.BatalhaNaval;


public class NavioTanque extends Navio{
    private String tipoNavio;

    public NavioTanque(int tamanho, char orientacao) {
        super(tamanho, orientacao);
    }

    public String getTipoNavio() {
        return tipoNavio;
    }

    public void setTipoNavio(String tipoNavio) {
        this.tipoNavio = tipoNavio;
    }
    
    
    
}
