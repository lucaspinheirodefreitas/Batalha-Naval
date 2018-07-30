package poo.projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Arquivo {

    private String path;
    private String pathAdversario;
    private String pathControladorDeTurno;

    public Arquivo(String path, String pathAdversario) {
        this.path = path;
        this.pathAdversario = pathAdversario;
    }
    
    public Arquivo() {
        this.pathControladorDeTurno = "ControladorDeTurno.txt";
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
    
    public boolean verificarFim(String path) {
        boolean achou = buscar(path, "fim");
        
        return achou;
    }
    
    public void deletarArquivo() {
        File file = new File(pathAdversario);
        
        if(file.exists()){
            file.delete();
        }
    }
    
    public void criarControladorTurno() throws IOException {
    	FileWriter fw = new FileWriter(pathControladorDeTurno, true);
        try (BufferedWriter conexao = new BufferedWriter(fw)) {
            conexao.write("1");
            conexao.newLine();
        }
    }
    
    public String verificarTurno() throws IOException {
    	
    	String vez = "";
        try {
            InputStream is = new FileInputStream(pathControladorDeTurno);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = "";
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    vez = line;
                }
            }
            br.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return vez;
    }

    public void alterarTurno() {
        String atual = " ";
        char vez = ' ';

        try {
            atual = verificarTurno();
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            if (verificarTurno().charAt(0) == '3')
                vez = '1';
            else
                vez = pathAdversario.charAt(1);
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(pathControladorDeTurno, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(vez);
            conexao.newLine();
            conexao.close();  
        } 
        catch(Exception e) {
            System.out.println("Erro ao Tentar alterar Turno");
        }
    }
} 
