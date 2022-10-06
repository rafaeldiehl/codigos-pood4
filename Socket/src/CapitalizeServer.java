import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CapitalizeServer {

    /**
     * Executar o servidor. Quando um cliente conecta, o servidor cria uma nova thread
     * e imediatamente comeca a escutar. A aplicação limita o número de threads
     * via thread pool (milhares de clientes podem ser conectados, tudo dependendo
     * da capacidade de alocação de recursos do servidor).
     */
    public static void main(String[] args) throws Exception {
        try (ServerSocket novoSocketListener = new ServerSocket(59898)) {
            System.out.println("O servidor de letras está executando...");

            //cria um pool de threads
            ExecutorService pool = Executors.newFixedThreadPool(20);

            //esse loop é infinito
            while (true) {
                //a cada nova conexao do novo Socket, cria-se uma nova thread
                //e um objeto Capitalizer para trabalhar com ela
                pool.execute(new Capitalizer(novoSocketListener.accept()));
            }
        }
    }


}