import java.io.*;

public class GerenciadorArquivos {
    public void criarArquivo(File arquivo) {
        if(arquivo.exists()) {
            System.out.println("O arquivo já existe");
        } else {
            System.out.println("O arquivo não existe");
            try {
                if(arquivo.createNewFile()) {
                    System.out.println("Arquivo criado com sucesso");
                } else {
                    System.out.println("Erro ao criar arquivo");
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removerArquivo(File arquivo) {
        if(arquivo.exists()) {
            if(arquivo.delete()) {
                System.out.println("Arquivo removido com sucesso");
            } else {
                System.out.println("Erro ao remover arquivo");
            }
        } else {
            System.out.println("O arquivo não existe e, portanto, não foi possível removê-lo");
        }
    }

    public void escreverArquivo(File arquivo, String texto) {
        if(arquivo.exists()) {
            try {
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(texto);
                bw.close();
                fw.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo não existe e, portanto, não foi possível escrever nele");
        }
    }

    public void lerArquivo(File arquivo) {
        if(arquivo.exists()) {
            try {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);
                while(br.ready()) {
                    String linha = br.readLine();
                    System.out.println(linha);
                }
                br.close();
                br.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O arquivo não existe e, portanto, não foi possível lê-lo");
        }
    }

    public void criarDiretorio(File diretorio) {
        if(diretorio.exists()) {
            System.out.println("O diretório já existe");
        } else {
            System.out.println("O diretório não existe");
            if(diretorio.mkdir()) {
                System.out.println("Diretório criado com sucesso");
            } else {
                System.out.println("Erro ao criar diretório");
            }
        }
    }

    public void removerDiretorio(File diretorio) {
        if(diretorio.exists()) {
            if(diretorio.delete()) {
                System.out.println("Diretório removido com sucesso");
            } else {
                System.out.println("Erro ao remover diretório");
            }
        } else {
            System.out.println("O diretório não existe e, portanto, não foi possível removê-lo");
        }
    }

    public void listarDiretorio(File diretorio) {
        File[] arquivos = diretorio.listFiles();
        System.out.println("Listando o diretório " + diretorio.getName() + " (" + diretorio + ")");
        for(File arquivo: arquivos) {
            System.out.println("- " + arquivo.getName() + " (" + arquivo + ")");
        }
    }
}
