package POO.Projeto.BatalhaNaval;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Arquivo {

    Arquivo(String path, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*public GeraArquivo()
	{
		ACHO QUE NÃO PRECISA DE CONSTRUTOR NESSA PARTE.
	}*/

	public void criArquivo(String path, String jogador, int num)              
     ///////////////////////PRECISO PENSAR MELHOR NESSA IMPLEMENTAÇÃO\\\\\\\\\\\\\\\\\\\\\\\\\\\
    {
        /*File arquivo = new File(path);
        System.out.println("Chegou aqui");
        if(arquivo.exists()) 
        {
        	System.out.println("Arquivo: " + jogador + num + "].\nCriado com sucesso!");
        }
        Não esta fazedo nada essa função, não sei como resolver.*/
    }

    public void escrever(String path, char orientacao, String texto)
    {
        try 
        {
        	FileWriter fw = new FileWriter(path, true);
            BufferedWriter conexao = new BufferedWriter(fw);
			conexao.write(texto);
			conexao.newLine();
			conexao.close();  
        } 
        catch(Exception e) 
        {
            System.out.println("deu merda");
        }
    }

    public String geraPath(char argumentos)
    {
    	boolean singlePlayer = true;
    	String jogadores = "PlayerUmVsComputador[", path = " ";

    	if(argumentos == 'B' || argumentos == 'b')
	    {
	        singlePlayer = false;
	        jogadores = "PlayerUmVsPlayerDois[";
            //74
	    }

	    for(int i=1; (singlePlayer ? i<=2 : i<=3); )
	    {
	        path = "/home/mohammed/Área de Trabalho/ProjetoPOO_v2/Arquivo/" + jogadores + i + "].txt";
            //54
            if(singlePlayer)
                i++; 
            else
                i+=2;   
	    }
        return path;
    }
    
    //--------------------------Ideias de alguns possíveis métodos---------------------------//
    
    public void inserirAcabou()
    {
        
    }
    
    public void apagarLinha()
    {
        
    }
    
    public void apagarTudo()
    {
        
    }
    
    public void inserirVencedor()
    {
        
    }
    
    public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }
}
