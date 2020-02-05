package dk.cphbusiness.alg.basics;

public class QuickFind implements UnionFind{
    private int count;
    private int[] pointSets;

    public QuickFind(int count) {
        this.count = count;
        this.pointSets = new int[count];
        for (int i = 0; i < count; i++) pointSets[i] = i;
        }

    @Override
    public void union(int p, int q) {
        int setOfp = pointSets[p];
        int setOfq = pointSets[q];
        for (int i = 0; i < pointSets.length; i++)
            if (pointSets[i] == setOfp) pointSets[i] = setOfq;
        count--;
        }

    @Override
    public int find(int p) {
        return pointSets[p];
        }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
        }

    @Override
    public int count() {
        return count;
        }

    }
