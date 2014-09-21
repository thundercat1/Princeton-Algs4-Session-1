
/**
 * Created by mch on 9/11/14.
 */
public class PercolationStats {
    private int trialGoal;
    private double[] percolationTrialData;

    public PercolationStats(int N, int T) {
        //perform T experiments on an NxN grid
        if (N < 1 || T < 1) throw new IllegalArgumentException(
                "Instantiate PercolationStats with two arguments > 0!");

        trialGoal = T;
        percolationTrialData = new double[T];

        Percolation p;
        int cellsOpened;

        for (int testNumber = 0; testNumber < T ; testNumber++) {
            p = new Percolation(N);
            cellsOpened = 0;
            while (!p.percolates()) {
                int iRandom = StdRandom.uniform(1, N + 1);
                int jRandom = StdRandom.uniform(1, N + 1);
                if (!p.isOpen(iRandom, jRandom)) {
                    p.open(iRandom, jRandom);
                    cellsOpened++;
                }
            }
            percolationTrialData[testNumber] = cellsOpened / (double)(N*N);
        }
    }


   //public double mean()                     // sample mean of percolation threshold
    public double mean() {
        double dataSum = 0;
        for(int i = 0; i < trialGoal; i++) {
            dataSum += percolationTrialData[i];
        }
        return dataSum / trialGoal;
    }

   //public double stddev()
    public double stddev() {
        double m = mean();
        double sumSquareError = 0.0;
        double trialError = 0;
        for (int i = 0; i < trialGoal; i++) {
            trialError = percolationTrialData[i] - m;
            sumSquareError += trialError * trialError;
        }
        return Math.sqrt(sumSquareError / (trialGoal-1));
    }
   //public double confidenceLo()             // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96*stddev()/Math.sqrt(trialGoal));
    }

    public double confidenceHi() {
        return mean() + (1.96*stddev()/Math.sqrt(trialGoal));
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            PercolationStats p = new PercolationStats(
                    Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            StdOut.println("mean                    = " + String.valueOf(p.mean()));
            StdOut.println("stddev                  = " + String.valueOf(p.stddev()));
            StdOut.println("95% confidence interval = " + String.valueOf(p.confidenceLo() +
                ", " + String.valueOf(p.confidenceHi())));
        }

    }

}
