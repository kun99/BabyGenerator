import java.util.Random;

public class Hospital {

    Random random;
    private int babiesPerDay;
    private int days;

    public Hospital(int babiesPerDay, int days) {
        this.babiesPerDay = babiesPerDay;
        this.days = days;
        random = new Random();
    }

    public int simulate() {
        int daysSimulated = 0, daysWithMoreMales = 0;
        while(daysSimulated < days){
            int males = 0;
            int babies = 0;
            //tried to figure out a more efficient way to run this program
            //but im dumb D: (runtime: daysSimulated * babiesPerDay)
            while(babies < babiesPerDay){
                int randomized = random.nextInt(2);
                if(randomized==0){
                    males += 1;
                }
                babies += 1;
            }
            if(males > babiesPerDay*0.6){
                daysWithMoreMales += 1;
            }
            daysSimulated += 1;
        }
        return daysWithMoreMales;
    }

    public static void main(String[] args) {
        Hospital hospitalA = new Hospital(15, 1000);
        int iterations = 0, sum = 0;
        while(iterations < 100){
            sum += hospitalA.simulate();
            iterations += 1;
        }
        System.out.println("Hospital A: " + sum/100);

        Hospital hospitalB = new Hospital(45, 1000);
        iterations = 0;
        sum = 0;
        while(iterations < 100){
            sum += hospitalB.simulate();
            iterations += 1;
        }
        System.out.println("Hospital B: " + sum/100);

        Hospital hospitalC = new Hospital(100, 1000);
        iterations = 0;
        sum = 0;
        while(iterations < 100){
            sum += hospitalC.simulate();
            iterations += 1;
        }
        System.out.println("Hospital C: " + sum/100);
    }
}
