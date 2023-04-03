import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        boolean appRun = true;
        Stub stub = new Stub("127.0.0.1", 10000);
        while(appRun){
            stub.main("DIV", 4, 5);
            appRun = false;
        }
        stub.endServer();
    }
}