public class Percolation {
    private boolean[] cells;
    //private boolean[] cellsNoBackwash;
    private WeightedQuickUnionUF uf;
    //private WeightedQuickUnionUF nb;
    private boolean percolationAchieved;

    private int sideLength;

    public Percolation(int N) {
        if (N < 1) throw new IllegalArgumentException();
        sideLength = N;
        percolationAchieved = false;
        // create union find structures
        uf = new WeightedQuickUnionUF(N*N + 3);
        //nb = new WeightedQuickUnionUF(N*N + 3);

        //create list of cells to keep track of openness
        cells = new boolean[N*N + 2];
        //cellsNoBackwash = new boolean[N*N + 2];

        //turn on the faucets
        cells[0] = true;
        ///cellsNoBackwash[0] = true;

        //turn on the drain for the first data structure
        //N*N + 1 is backwash drain. N*N + 2 is non-backwash drain
        cells[N*N + 1] = true;
    }

    public void open(int i, int j) {
        //open the site at (row i, column j)
        //StdOut.println("opening " + String.valueOf(i) + "," + String.valueOf(j));

        checkInputs(i, j);
        cells[idx(i, j)] = true;

        //if cell is on the top row, connect to the faucet
        if (i == 1) {
            uf.union(idx(i, j), 0);
            //nb.union(idx(i, j), 0);
        }

         //Connect to cell above it, if that one's open
        if (i != 1 && isOpen(i - 1, j)) {
            uf.union(idx(i - 1, j), idx(i, j));
            //nb.union(idx(i - 1, j), idx(i, j));
        }

        //Connect to the one below, if it's open
        if (i != sideLength && isOpen(i+1, j)) {
            uf.union(idx(i,j), idx(i+1,j));
            //nb.union(idx(i,j), idx(i+1,j));
        }

        //Connect to left and right
        if (j != 1 && isOpen(i,j-1)) {
            uf.union(idx(i, j), idx(i, j-1));
            //nb.union(idx(i, j), idx(i, j - 1));
        }

        if (j != sideLength && isOpen(i, j+1)) {
            uf.union(idx(i, j), idx(i, j+1));
            //nb.union(idx(i, j), idx(i, j+1));
        }

        //StdOut.println("percolationAchied: " + String.valueOf(percolationAchieved));
        if (!percolationAchieved) {
            //no percolation yet, so keep operating only on the backwash object
            if (i == sideLength) {
                //if it's on the bottom row, attach it to faucet (for the backwash structure)
                uf.union(idx(i, j), sideLength * sideLength + 1);
            }

            if (percolates()) {
                //If the system percolates, note it!
                percolationAchieved = true;
            }
        }

        if (percolationAchieved) {
            if(i == sideLength) {
                //Percolation has been reached, so newly filled bottom cells connect to
                //non-backwash drain as well
                //uf.union(idx(i, j), sideLength * sideLength + 1);
                ///uf.union(idx(i, j), sideLength * sideLength + 2);
                if (uf.connected(idx(i, j), 0)) uf.union(idx(i,j), sideLength * sideLength + 2);
            }
        }
    }

    public boolean isOpen(int i, int j) {
        //is the site (row i, column j) open?
        checkInputs(i,j);
        return cells[idx(i,j)];
    }

    //public boolean isFull(int i, int j)      // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        checkInputs(i, j);
        if (!percolationAchieved) {
            return uf.connected(0,idx(i, j));
        } else {
            //return nb.connected(0, idx(i,j));
            return uf.connected(0, idx(i, j));
        }
    }

    public boolean percolates()  {
        //Percolates if and only if the fauce is connected to drain
        //if (percolationAchieved) return true;
        //return uf.connected(0, sideLength * sideLength + 1);
        return percolationAchieved || uf.connected(0, sideLength * sideLength + 1);
    }

    private void checkInputs(int i, int j) {
        if (i < 1 || j < 1 || i > sideLength || j > sideLength)
            throw new IndexOutOfBoundsException();
    }

    private int idx(int i, int j) {
        return sideLength*(i-1) + (j);
    }
}