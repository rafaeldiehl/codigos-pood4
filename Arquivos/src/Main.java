import java.io.File;

public class Main {
    public static void main(String[] args) {
        File diretorio = new File("C:/teste/dir");

        File arquivo = new File("C:/teste/teste.txt");
        File arquivo1 = new File("C:/teste/dir/teste1.txt");
        File arquivo2 = new File("C:/teste/dir/teste2.txt");
        File arquivo3 = new File("C:/teste/dir/teste3.txt");

        GerenciadorArquivos gerenciadorArquivos = new GerenciadorArquivos();

        // gerenciadorArquivos.criarArquivo(arquivo);
        // gerenciadorArquivos.removerArquivo(arquivo);
        gerenciadorArquivos.criarDiretorio(diretorio);

        // gerenciadorArquivos.removerDiretorio(diretorio);

        gerenciadorArquivos.criarArquivo(arquivo1);
        gerenciadorArquivos.criarArquivo(arquivo2);
        gerenciadorArquivos.criarArquivo(arquivo3);

        gerenciadorArquivos.listarDiretorio(diretorio);

        gerenciadorArquivos.escreverArquivo(arquivo1, "DFASFASASFASF");
        gerenciadorArquivos.escreverArquivo(arquivo2, "Lorem ipsum");

        gerenciadorArquivos.lerArquivo(arquivo1);
        gerenciadorArquivos.lerArquivo(arquivo2);

        gerenciadorArquivos.removerArquivo(arquivo3);
    }
}