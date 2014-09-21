

public class SocialNetwork {
    private MyUnionFind networkUF;
    private static String workingDate;

    private static boolean fileEnd;

    public SocialNetwork(int N) {
        networkUF = new MyUnionFind(N);
        fileEnd = false;
    }

    public boolean networkClosed() {
        return networkUF.allConnected();
    }

    public void makeConnection(int i, int j) {
        networkUF.makeFriends(i, j);
    }

    public int getRoot(int i) {
        return networkUF.root(i);
    }

    public int largestNetwork() {
        return networkUF.largestTree;
    }

    public String[] readNextLogEntry(In fileIn) {
        String date = fileIn.readString();
        String p1 = fileIn.readString();
        String p2 = fileIn.readString();
        String[] returnArray = {date, p1, p2};
        return returnArray;
    }

    private void createConnectionsFromFile(String fname) {
        In fileIn = new In(fname);
        String[] entry = readNextLogEntry(fileIn);

        while (fileIn.hasNextLine() && !networkUF.allConnected()) {
            entry = readNextLogEntry(fileIn);
            workingDate = entry[0];

            makeConnection(Integer.parseInt(entry[1]), Integer.parseInt(entry[2]));
        }
    }

    public static void main(String[] args) {
        String fname = "./resources/networkLog.txt";
        In fileIn = new In(fname);

        SocialNetwork n = new SocialNetwork(10);
        n.createConnectionsFromFile(fname);

        StdOut.println("Every person is a friend of a friend on " + String.valueOf(workingDate));
    }
}
