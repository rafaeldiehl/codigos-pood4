import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Capitalizer implements Runnable {
    private Socket socket;             //representa um socket

    Capitalizer(Socket socket) {       //injeção de um socket
        this.socket = socket;
    }

    @Override
    public void run() { //o run só é executado na thread se a conexao foi estabelecida
        System.out.println("Connected: " + socket); //estabeleceu a conexao
        try {

            //cria a leitura e a escrita para o cliente
            Scanner recebeDoCliente = new Scanner(socket.getInputStream());
            PrintWriter imprimeParaOCliente = new PrintWriter(socket.getOutputStream(), true);

            //enquanto o cliente tem informação

            while (recebeDoCliente.hasNextLine()) {
                //recebe a informacao,  recebeDoCliente.nextLine()
                // converte em maiuscula, toUpperCase()
                //e reenvia de volta, imprimeParaOCliente.println();
                String texto = recebeDoCliente.nextLine();
                String[] cmds = texto.split("@");
                if(cmds[0].equals("u")) {
                    imprimeParaOCliente.println(cmds[1].toUpperCase());
                } else if(cmds[0].equals("l")) {
                    imprimeParaOCliente.println(cmds[1].toLowerCase());
                } else {
                    imprimeParaOCliente.println("Não foi possível identificar a operação, use 'u' para uppercase e 'l' para lowercase");
                }

            }
        } catch (Exception e) {
            System.out.println("Error:" + socket);
        } finally {
            try { socket.close(); } catch (IOException e) {}
            System.out.println("Closed: " + socket);
        }
    }
}