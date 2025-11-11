package AlgoritmosEmGrafos;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /*
    Função auxiliar para pegar os vizinhos de um vértice por matriz de adjacência
     */
    public static List<Integer> getNeighboors(int[][] mat, int vertexIndex){
        List<Integer> neighboors = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            if(vertexIndex != i && mat[vertexIndex][i] == 1){
                neighboors.add(i);
            }
        }
        return neighboors;
    }

    /*
    Função para transpor um digrafo
     */
    public static int[][] transpoe(int[][] mat){
        int n = mat.length;
        int[][] transposto = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                transposto[i][j] = mat[j][i];
            }
        }
        return transposto;
    }
}
