
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Σταύρος
 */
public class RMIServer extends UnicastRemoteObject implements RMI{

    public RMIServer() throws RemoteException{
        super();
    }
    
    
    
    @Override
    public String getData(String text) throws RemoteException {
        
        int randomScoreteam1=(int) (Math.random() * (100 - 0));
       int randomScoreteam2=(int) (Math.random() * (100 - 0));
        
        //Initialize the headquarters of the host team, and two random numbers for the score;
        String teamStadium="unknown";
        String hostHeadquarters="unknown";
        String guestHeadquarters="unknown";
        if(text.equals("Boston Celtics vs LA Lakers")) {
        teamStadium="Boston";
        }
        else if(text.equals("Huston Rockets vs Indiana Pacers")) {
            teamStadium="Huston Texas";
        }
        else if(text.equals("Miami Heat vs New York Knicks")) {
            teamStadium="Miami";
        }
        else if(text.equals("Chicago Bulls vs Cleveland Cavalliers")) {
            teamStadium="Chicago";
        }
        
        //Quarters
        for(int i=0; i<4; i++){
            //Count the quarters
              int quarter= i+1;
              System.out.println("you are in quarter" + i);
            for(int j=0; j<12; j++){
                //Random numbers for the score
                int randomNumber= (int) (Math.random() * (5 - 0));
                int randomNumber2= (int) (Math.random() * (5 - 0));
                randomScoreteam1 = randomScoreteam1 + randomNumber;
                randomScoreteam2=randomScoreteam2 + randomNumber2;
              String scores=(randomScoreteam1) + "-" + (randomScoreteam2);

               try {
                 Thread.sleep(300);
                 //return the teams, the headquarters of the host team and the score to client
                 text= text + "\t at\t" + teamStadium + ": \t" + scores + "quarter" + quarter + "\n";
                   } 
              catch(InterruptedException ex) {
              Thread.currentThread().interrupt();
             }
                  

          }
         }
    return text;
    }
    
    public static void main(String args[]){
        
        try
        {
            //bind the server with the client
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("Server", new RMIServer());
            System.out.println("Server Started");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    
 
}