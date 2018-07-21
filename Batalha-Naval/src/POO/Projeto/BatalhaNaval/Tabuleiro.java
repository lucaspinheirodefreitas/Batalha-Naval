package POO.Projeto.BatalhaNaval;

public class Tabuleiro {
    Celula [][] campo;
    
    public Tabuleiro(int linhas, int colunas)
    {
        campo = new Celula[linhas][colunas];
    }    
    public void inicializarTabuleiro()
    {
        for (int i=0; i<campo.length; i++)
        {
            for (int j=0; j<campo[0].length; j++)
            {
                if (i == 0 || i == campo.length-1)
                    campo[i][j] = new Celula('=');
                else if(j == 0 || j == campo[0].length-1)
                    campo[i][j] = new Celula('|');
                else
                    campo[i][j] = new Celula('*');
            }
        }
    }
    
    public void imprimirTabuleiro()
    {
        for(int i=0; i<campo.length; i++)
        {
            for(int j=0; j<campo[0].length; j++)
            {
                System.out.print
                (campo[i][j].getCaracter() + 
                        (j == campo[0].length-1 ? "\n" : ""));
            }
        }
    }

    public void setTabuleiro(char caracter, int linha, int coluna)
    {
        campo[linha][coluna].setCaracter(caracter);
    }

}
