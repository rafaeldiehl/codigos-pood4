import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeClient {
    public static void main(String[] args) throws Exception {

        try (Socket socket = new Socket("127.0.0.1", 59898)) {

            System.out.println("Entre com as linhas de texto, ou Ctrl+C ou Ctrl+D para sair!");

            //cria um scanner para leitura do teclado
            Scanner scanner = new Scanner(System.in);

            //cria um scanner para o gerenciamento da stream de entrada do socket
            Scanner recebeDoServidor = new Scanner(socket.getInputStream());

            //imprime a mensagem para a stream de saida do socket
            PrintWriter imprimeNoServidor = new PrintWriter(socket.getOutputStream(), true);

            //faz a leitura do teclado
            while (scanner.hasNextLine()) {

                //imprime o texto no socket
                imprimeNoServidor.println(scanner.nextLine());

                //imprime o texto recebido do servidor
                System.out.println(recebeDoServidor.nextLine());
            }
        }
    }
}