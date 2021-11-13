package Handler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static java.lang.System.exit;

/**
 * Write log to an external file
 */
public class Writer {

    private static String Timestamp;
    private static final String fileName = "Server.txt";

    /**
     * append an object to the text file
     */
    public static void receiveClient(Object object){
        //get current timestamp
        Timestamp = new Date().toString();

        //add object to file with a timestamp
        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName,true))){
            StringBuilder str = new StringBuilder();

            str.append("\n----------------NEW MESSAGE From Client--------------------");
            System.out.println(str);
            br.write(str.toString());
            br.newLine();
            br.write(object.toString());
            System.out.println(object);
            br.newLine();
            br.write(Timestamp);
            System.out.println(Timestamp);
            br.newLine();
        }catch (IOException e) {
            //e.printStackTrace();
            String log = "IOException.... ";
            log += "\nClosing client....\n ";
            Writer.log(log);
            exit(1);
        }
    }

    /**
     * log any string to the file
     */
    public static void log(String log){

        Timestamp = new Date().toString();

        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName,true))){
            StringBuilder str = new StringBuilder();

            str.append("\n-------------------------------------------------");
            System.out.println(str);
            br.write(str.toString());
            br.newLine();
            br.write(log);
            System.out.print(log);
            br.newLine();
            br.write(Timestamp);
            System.out.println(Timestamp);
            br.newLine();
            br.write(str.toString());
            br.newLine();
        }catch (IOException e) {
        //e.printStackTrace();
        log = "IOException.... ";
        log += "\nClosing client....\n ";
        Writer.log(log);
        exit(1);
        }
    }

    /**
     * add the object sent to a client from server
     */
    public static void sendResponse(Object object, String clientAddress, int clientPort){
        Timestamp = new java.util.Date().toString();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) {
            StringBuilder str = new StringBuilder();

            str.append("\n----------------SENDING-------------");
            br.write(str.toString());
            System.out.println(str);
            br.newLine();
            br.write(object.toString());
            System.out.println(object);
            br.newLine();
            br.write("Sending to ->" + clientAddress + ":" + clientPort);
            System.out.println("Sending to ->" + clientAddress + ":" + clientPort);
            br.newLine();
            br.write(Timestamp);
            System.out.println(Timestamp);
            br.newLine();
        }catch (IOException e) {
            //e.printStackTrace();
            String log = "IOException.... ";
            log += "\nClosing client....\n ";
            Writer.log(log);
            exit(1);
        }
    }
}