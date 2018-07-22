package POO.Projeto.BatalhaNaval;

public class Tabuleiro {
    
    private Celula [][] campo;
    private char numLin, numCol;
    
    public Tabuleiro(int linhas, int colunas)
    {
        campo = new Celula[linhas][colunas];
        this.numLin = 'A';
        this.numCol = '1';
    }    
    public void inicializarTabuleiro() {
        for (int i=0; i<campo.length; i++) {
            for (int j=0; j<campo[0].length; j++) {
                
                if(i == 0 && j == 0) {
                    campo[i][j] = new Celula(' ');
                }
                else {
                    if(i == 0 && j>1 && j<campo[0].length-1) {
                        campo[i][j] = new Celula((char)(numCol+j-3));
                    }
                    else {
                        if(i>1 && j == 0 && i<campo.length-1) {
                            campo[i][j] = new Celula((char)(numCol + (i-3)));
                        }
                        else if (i == 1 || i == campo.length-1)
                            campo[i][j] = new Celula('=');
                        else if(j == 1 || j == campo[0].length-1)
                            campo[i][j] = new Celula('|');
                        else
                            campo[i][j] = new Celula('o');
                        }    
                    }
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

/* A seguir o tabuleiro com as linhas descritas por letras, fiz uma pequena alteração pra não ter que fazer DE-PARA de letra pra número no metodo buscarPos do jogador;
Mas é possivel implementar as condições se der tempo para utilizar o tabuleiro com letras e colunas com numeros


public void inicializarTabuleiro() {
        for (int i=0; i<campo.length; i++) {
            for (int j=0; j<campo[0].length; j++) {
                
                if(i == 0 && j == 0) {
                    campo[i][j] = new Celula(' ');
                }
                else {
                    if(i == 0 && j>1 && j<campo[0].length-1) {
                        campo[i][j] = new Celula((char)(numCol+j-3));
                    }
                    else {
                        if(i>1 && j == 0 && i<campo.length-1) {
                            campo[i][j] = new Celula((char)(numLin + (i-2)));
                        }
                        else if (i == 1 || i == campo.length-1)
                            campo[i][j] = new Celula('=');
                        else if(j == 1 || j == campo[0].length-1)
                            campo[i][j] = new Celula('|');
                        else
                            campo[i][j] = new Celula('o');
                        }    
                    }
            }
        }
    }
*/
