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
    
     public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void criarArquivo(String path)
    {
            try (FileWriter fw = new FileWriter(path, true)) {
                BufferedWriter conexao = new BufferedWriter(fw);
            } 
            catch(Exception e) {
                System.out.println("problema ao gerar arquivo!");
            }
    }

    public void escrever(String path, String texto)
    {
        try (FileWriter fw = new FileWriter(path, true)) {
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(texto);
            conexao.newLine();
            conexao.close();  
        } 
        catch(Exception e) {
            System.out.println("problema na escrita do arquivo!");
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
            boolean controle = false;
            
            File file = new File(pathAdversario);

            if(file.exists()){
                System.out.println("Erro na leitura");
            }
            else {
                System.out.println("Aguarde, o adversário ainda não definiu "
                        + "a disposição dos seus navios.");
                System.out.println();
                while(!controle) {
                    if(file.exists()) {
                        controle = true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean verificarFim(String path)
    {
        boolean achou = buscar(path, "fim");
        
        if(achou) {
            return true;
        }
        return false;
    }
    
    public void deletarArquivo()
    {
        File file = new File(pathAdversario);
        
        if(file.exists()){
            file.delete();
        }
        /*posso pensar em usr isso
        boolean isFile() -> retorna true se o argumento passado ao construtor da 
        File é um arquivo, falso o contrário
        */
    }
} 
