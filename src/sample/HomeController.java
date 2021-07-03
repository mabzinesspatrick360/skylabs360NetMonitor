package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML public Label LBconnectionStatus;
    @FXML public Label LBpublicIP;
    @FXML public Label LBprivateip;
    String publicipaddress = "";
    String privateip;
//the object of the main class
    Main main = new Main();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //calling the getipaddress method
        try {
            getIpAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public void connectionDetails(){
        main.loadStage("ConnectionDetails.fxml");
    }
    public void favoriteHosts(){
        main.loadStage("FavoriteHost.fxml");
    }
    public void contactus(){
        main.loadStage("FavoriteHost.fxml");
    }
    public void exit(){
        System.exit(0);
    }
    //this method is to get the ip addresses for the host
    public String getIpAddress() throws UnknownHostException {
        // Returns the instance of InetAddress containing local host name and address
        InetAddress localhost = InetAddress.getLocalHost();
        privateip=localhost.getHostAddress().trim();
        //setting the private ip to the label
        LBprivateip.setText(""+privateip);
        // Find public IP address
        try
        {
            //this is the online utility to find the public ip address
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
            // reads system IPAddress
            publicipaddress = sc.readLine().trim();
        }
        catch (Exception e)
        {
            //if no public ip address here is the error
            publicipaddress = "No public IP :Cannot Execute Properly";
        }
        //printing the la public ip to the label
        LBpublicIP.setText(""+publicipaddress);

        return  privateip;
    }
}
