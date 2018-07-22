package POO.Projeto.BatalhaNaval;

public class PortaAvioes extends Navio{
    
    public PortaAvioes(char orientacao) {
        super(5, orientacao);
    }
    
    public String[] posicoes(String posicaoInicial)
    {
        String[] posicao = new String[super.getTamanho()];
        char primeira, segunda;
        
        primeira = posicaoInicial.charAt(0);
        segunda = posicaoInicial.charAt(1);
        posicao[0] = posicaoInicial;
        
        if(super.getOrientacao() == 'h' || super.getOrientacao() == 'H')
        {
            
            for(int i=1; i<super.getTamanho(); i++)
            {
                segunda = (char)(segunda + 1);
                posicao[i] = String.valueOf(primeira) + String.valueOf(segunda); 
            }
        }
        else
        {
            for(int i=1; i<super.getTamanho(); i++)
            {
                primeira = (char)(primeira + 1);
                posicao[i] = String.valueOf(primeira) + String.valueOf(segunda);
            }
        }
        return posicao;
    }
    
    
    
    
    
}
