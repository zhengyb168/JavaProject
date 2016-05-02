import java.io.*;
import java.net.*;
import java.util.ArrayList;
  
public class Server extends ServerSocket {
    private static final int SERVER_PORT =8000;
    
    public Server()throws IOException {
        super(SERVER_PORT);
  
        try {
            while (true) {
                Socket socket = accept();
                new CreateServerThread(socket);//当有请求时，启一个线程处理
            }
        }catch (IOException e) {
        }finally {
            close();
        }
    }
  
    //线程类
    class CreateServerThread extends Thread {
        private Socket client;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;
        private ArrayList arrayList;
  
        public CreateServerThread(Socket s)throws IOException {
        	arrayList=new ArrayList();
            client = s;
            
            bufferedReader =new BufferedReader(new InputStreamReader(client.getInputStream()));
              
            printWriter =new PrintWriter(client.getOutputStream(),true);
            
            System.out.println("Client(" + getName() +") came in...");
            
            start();
        }
  
        public void run() {
            try {
                String line = bufferedReader.readLine();
                System.out.println("Client(" + getName() +") say: " + line);
                arrayList.add(line);
                
                while (!line.equals("bye")) {
                    printWriter.println(" Have Received Your Information! continue, Client(" + getName() +")!");
                    line = bufferedReader.readLine();
                    System.out.println("Client(" + getName() +") say: " + line);
                    arrayList.add(line);
                    if(arrayList.size()==5){
                    	for(int i=0; i<arrayList.size(); i++){
                    		System.out.println(i+": "+arrayList.get(i));
                    	}
                    	new Network(arrayList);
                    	
                    	ManagementSystem ms=new ManagementSystem();
                    	ms.update(arrayList);
                    	arrayList.clear();
                    }
                }
                printWriter.println("bye, Client(" + getName() +")!");
                  
                System.out.println("Client(" + getName() +") exit!");
                printWriter.close();
                bufferedReader.close();
                client.close();
            }catch (IOException e) {
            	
            }
        }
    }
  
    public static void main(String[] args)throws IOException {
        new Server();
    }
}