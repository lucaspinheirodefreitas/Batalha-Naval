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

    public String getPathControladorDeTurno() {
        return pathControladorDeTurno;
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

    public void setPathAdversario(String pathAdversario) {
        this.pathAdversario = pathAdversario;
    }
    
    public void criarArquivo(String path)
    {
        try (FileWriter fw = new FileWriter(path, true)) {
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.newLine();
            conexao.close();
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
    
    public boolean buscar(String path, String posicao) throws InterruptedException {
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
                aguardaInsercao();
            }
        }
        return false;
    }
    
    public void aguardaInsercao() throws InterruptedException {
        boolean controle = false;
        File file = new File(pathAdversario);
        
        System.out.println("Aguarde, o adversário ainda não definiu "
                + "a disposição dos seus navios.");
        System.out.println();
        while(!controle) {
            Thread.sleep(1000);
            if(file.exists() && contaLinhas() == 22) {
                controle = true;
            }
        }
    }
    
    public int contaLinhas() {
        int cont = 0;
        String linha = " ";
        try (FileReader fr = new FileReader(pathAdversario)) {
            BufferedReader br = new BufferedReader(fr);
            while (linha != null) {
                linha = br.readLine();
                if(linha != null) {
                    cont++;
                }
            }
        } 
        catch(IOException e) {

            System.out.println("problema com o contador");
            System.out.println();
        }
        return cont;
    }
    
    public boolean verificarFim(String path) throws InterruptedException {
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
    	try (FileWriter fw = new FileWriter(pathControladorDeTurno, true)) {
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.newLine();
            conexao.close();
        } 
        catch(Exception e) {
            System.out.println("problema ao gerar arquivo controle de turno!");
        }
    }
    
    public String verificarTurno() throws IOException {
    	String vez = "";
        String line;
        try {
            InputStream is = new FileInputStream(pathControladorDeTurno);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            line = " ";
            while (line != null) {
                line = br.readLine();
                if (line != null) {
                    vez = line;
                }
            }
            br.close();
        } 
        catch (IOException e) {
        
        }
        return vez;
    }

    public void alterarTurno() {
        String atual = null;
        char vez = ' ';
        try {
            atual = verificarTurno();
        } 
        catch (IOException e1) {
            System.out.println("Problema ao atribuir o turno atual");
        }
        if (atual != null && atual.charAt(0) != '3') {
            vez = pathAdversario.charAt(1);
        }
        else
            vez = '1';
        try {
            FileWriter fw = new FileWriter(pathControladorDeTurno, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(vez);
            conexao.newLine();
            conexao.close();  
        } 
        catch(Exception e) {
            System.out.println("Inconsistência no controle de turnos");
        }
    }
} 
