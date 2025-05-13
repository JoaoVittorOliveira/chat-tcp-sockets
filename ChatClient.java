import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost"; 
    private static final int SERVER_PORT = 12345; // porta usada pelo servidor

    public static void main(String[] args) {
        try (
            // cria conexão com o servidor
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

            
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            // envia mensagens para o servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            // thread para escutar e mostrar mensagens recebidas do servidor
            Thread listener = new Thread(() -> {
                String response;
                try {
                    while ((response = input.readLine()) != null) {
                        System.out.println(response); // mensagens recebidas
                    }
                } catch (IOException e) {
                    System.out.println("Desconectado do servidor.");
                }
            });

            listener.start(); // escuta de mensagens

            String userInput;
            // Loop para ler mensagens digitadas e enviá-las ao servidor
            while ((userInput = keyboard.readLine()) != null) {
                out.println(userInput); // Envia mensagem
                if (userInput.equalsIgnoreCase("/sair")) {
                    break; // Sai se usuário digitar /sair
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}