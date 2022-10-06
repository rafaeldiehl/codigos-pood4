import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

    public static void main(String[] args) throws ClassNotFoundException  {
        Socket tsocket;
        PrintWriter imprimeNoSocket;
        BufferedReader leitor;
        ServerSocket ss;

        try{

            //Mensagem de espera
            System.out.println("Servidor em espera...");

            //instancia e espera uma conexao
            ss=new ServerSocket(8889);

            //ao estabelecer uma conexao, aceita, e um socket é criado em tsocket
            tsocket=ss.accept();

            //estabelece um gerenciamento de stream de saída para socket
            imprimeNoSocket=new PrintWriter(tsocket.getOutputStream());

            //estabelece um gerenciamento de stream de entrada para socket
            InputStream tis=tsocket.getInputStream();

            //estabelece um gerenciamento de stream de leitura para socket
            InputStreamReader tisr=new InputStreamReader(tis);

            //faz a leitura da stream de leitura para lei
            leitor=new BufferedReader(tisr);

            //obtem o texto da stream de leitura
            String textoDoCliente=leitor.readLine();

            //imprime a palavra servidor para a stream de saída
            imprimeNoSocket.println("olá, sou o servidor");

            //descarrega a stream para o socket
            imprimeNoSocket.flush();

            //fecha o socket
            tsocket.close();

            //imprime o texto recebido
            System.out.println("Recebido do Cliente:"+textoDoCliente);

        }catch(IOException e){
            System.out.println("Cliente não conseguiu conectar...");
            e.printStackTrace();
        }
    }

}