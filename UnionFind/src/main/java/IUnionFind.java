interface IUnionFind {

    void union(int p, int q);
    int find(int p);
    boolean isConnected(int p, int q);
    int count();
}
