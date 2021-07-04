package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

import static java.lang.System.out;

public class Main extends Application {
    Stage stg =new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("skylabsNetMonitor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            stg.setScene(new Scene(root));
            stg.setTitle("skylabsNetMonitor");
            stg.show();
            stg.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets)) {
            displayInterFaceInformation(netint);
        }
        launch(args);
    }

     static void displayInterFaceInformation(NetworkInterface netint) throws SocketException{
        out.printf("display name : %s\n" , netint.getDisplayName());
        out.printf("name :%s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses =netint.getInetAddresses();
        for(InetAddress inetAddress : Collections.list(inetAddresses)){
            out.printf("inetAddress %s\n", inetAddress );
        }
         out.printf("up? :%s\n", netint.isUp());
         out.printf("virtual? :%s\n", netint.isVirtual());
        out.printf("\n");
    }

}
