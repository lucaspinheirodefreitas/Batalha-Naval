package poo.projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    private String path;
    private String pathAdversario;

    public Arquivo(String path, String pathAdversario) {
        this.path = path;
        this.pathAdversario = pathAdversario;
    }

    public String getPathAdversario() {
        return pathAdversario;
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
        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(texto);
            conexao.newLine();
            conexao.close();  
        } 
        catch(Exception e) {
            System.out.println("deu merda");
        }
    }
    
    public boolean buscar(String path, String posicao) {
        String linha = " ";
        try (FileReader fr = new FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
            
            while (linha != null) {
                
                linha = br.readLine();
                
                if(linha != null && linha.equals(posicao)) {
                    return true;
                }
            }
        } 
        catch(IOException e) {
            System.out.println("Erro na leitura");
        }
        return false;
}
    
    //--------------------------Ideias de alguns possíveis métodos---------------------------//
    
    public void inserirAcabou()
    {
        
    }
    
    public void apagarLinha()
    {
        
    }
    
    public void deletarArquivo()
    {
        File file = new File(path);
        
        if(file.exists()){
            file.delete();
        }
            
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
