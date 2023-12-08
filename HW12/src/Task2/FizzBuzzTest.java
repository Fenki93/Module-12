package Task2;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzTest {

    public static void main(String[] args) {

        Processor A = new Processor((n) -> {
            if((n%3) == 0 && (n%5)!=0) {
                System.out.println("fizz");
            }
        });

        Processor B = new Processor((n) -> {
            if((n%5) == 0 && (n&3)!=0) {
                System.out.println("buzz");
            }
        });

        Processor C = new Processor((n) -> {
            if((n%3) == 0 && (n%5) == 0) {
                System.out.println("fizzbuzz");
            }
        });

        Processor D = new Processor((n) -> {
            if((n%3) !=0 && (n%5) !=0) {
                System.out.println(n);
            }
        });

        List<Processor> nps = new ArrayList<>();
        nps.add(A);
        nps.add(B);
        nps.add(C);
        nps.add(D);

        for(Processor np: nps){
            np.start();
        }

        for(int i=1; i<16;i++){
            for(Processor np:nps){
                np.process(i);
            }

            while(true){
                int processedNumbersCount = 0;
                for(Processor np:nps){
                    if(np.isNumberProcessed()){
                        processedNumbersCount++;
                    }
                }
                if(processedNumbersCount == 4){
                    break;
                }

            }

        }

        for(Processor np: nps){
            np.interrupt();
        }
    }
}