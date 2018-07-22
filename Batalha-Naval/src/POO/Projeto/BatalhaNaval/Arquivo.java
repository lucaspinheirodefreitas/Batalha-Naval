package POO.Projeto.BatalhaNaval;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Arquivo {

    private String path;

    public Arquivo(String path) {
        this.path = path;
    }
    
     public String getPath()
    {
        return path;
    }
    
    public void setPath(String path)
    {
        this.path = path;
    }


    public void escrever(String path, String texto)
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
    
   
} 

/*public GeraArquivo()
    {
            ACHO QUE NÃO PRECISA DE CONSTRUTOR NESSA PARTE.
    }

    public void criArquivo(String path, String jogador, int num)              
 ///////////////////////PRECISO PENSAR MELHOR NESSA IMPLEMENTAÇÃO\\\\\\\\\\\\\\\\\\\\\\\\\\\
{
    /*File arquivo = new File(path);
    System.out.println("Chegou aqui");
    if(arquivo.exists()) 
    {
            System.out.println("Arquivo: " + jogador + num + "].\nCriado com sucesso!");
    }
    Não esta fazedo nada essa função, não sei como resolver.
}*/
