package AlgoritmosEmGrafos;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class DFSTest {

    @Test
    public void dfsIterativo(){
        int[][] matrizDeAdjascencia = {
                {1,0,1,1},
                {0,1,1,0},
                {0,0,1,0},
                {1,1,0,1}
        };
        List<int[]> results = DFS.dfsIterativo(matrizDeAdjascencia);

        int[] predecessorsExpected = { -1, 3, 0, 0 };
        int[] discoveryExpected    = {  1, 5, 2, 4 };
        int[] finishExpected       = {  8, 6, 3, 7 };

        assertArrayEquals(discoveryExpected, results.get(0));
        assertArrayEquals(finishExpected,    results.get(1));
        assertArrayEquals(predecessorsExpected,       results.get(2));
    }

}
