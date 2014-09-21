public class MyUnionFind {
    int[] nodes;
    int[] rootTreeSize;

    int largestTree;
    int nPeople;


    public MyUnionFind(int N) {
        nodes = new int[N];
        rootTreeSize = new int[N];
        largestTree = 1;
        nPeople = N;

        for (int i = 0; i < N; i++) {
            nodes[i] = i;
            rootTreeSize[i] = 1;
        }
    }

    public int treeSize(int i) {
        return rootTreeSize[i];
    }

    public void makeFriends(int i, int j) {
        int jRoot = root(j);
        int iRoot = root(i);
        if (iRoot != jRoot){
            if (rootTreeSize[jRoot] > rootTreeSize[iRoot]) {
                nodes[iRoot] = nodes[jRoot];
                rootTreeSize[jRoot] += rootTreeSize[iRoot];
                rootTreeSize[iRoot] = 0;
                if (rootTreeSize[jRoot] > largestTree) largestTree = rootTreeSize[jRoot];
            } else {
                nodes[jRoot] = nodes[iRoot];
                rootTreeSize[iRoot] += rootTreeSize[jRoot];
                rootTreeSize[jRoot] = 0;
                if (rootTreeSize[iRoot] > largestTree) largestTree = rootTreeSize[iRoot];
            }



        }
    }

    public boolean connected(int i, int j) {
        return root(i) == root(j);
    }

    public int root(int i) {
        while (nodes[i] != i) {
            i = nodes[i];
        }
        return i;
    }

    public boolean allConnected() {
        return nPeople == largestTree;
    }

}
