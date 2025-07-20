import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class task2 {

    
     public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Только 2 парамерта.");
            return;
        }

        
        
        try {
            File MidlePointAndR = new File(args[0]);
            Scanner s = new Scanner(MidlePointAndR);

            double CircleX = s.nextDouble();
            double CircleY = s.nextDouble();
            double CircleR = s.nextDouble();

            s.close();

            File Coords = new File(args[1]);
            s = new Scanner(Coords);
            
            double dotX;
            double dotY; 
            while (s.hasNextDouble()){
                dotX = s.nextDouble();
                dotY = s.nextDouble();
                double d=Math.sqrt(Math.pow((dotX-CircleX),2)+(Math.pow((dotY-CircleY),2)));

                if (d == CircleR) System.out.println(0);  
                else if (d < CircleR) System.out.println(1);
                else if (d > CircleR) System.out.println(2);
            }

            s.close();

        } catch (IOException  e) {
            System.err.println("Error: File not found at " + args[0]);
            e.printStackTrace();
        }

    }
}
