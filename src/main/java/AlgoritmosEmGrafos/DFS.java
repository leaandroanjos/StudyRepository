package AlgoritmosEmGrafos;

import EstruturasDeDados.Pilha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {

    public static List<Integer> getNeighboors(int[][] mat, int vertexIndex){
        List<Integer> neighboors = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            if(vertexIndex != i && mat[vertexIndex][i] == 1){
                neighboors.add(i);
            }
        }
        return neighboors;
    }

    public static List<int[]> dfsIterativo(int[][] mat){
        List<int[]> resultados = new ArrayList<>();
        int n = mat.length;
        int[] discoveryTime = new int[n];
        int[] finishTime = new int[n];
        int[] predecessor = new int[n];
        resultados.add(discoveryTime);
        resultados.add(finishTime);
        resultados.add(predecessor);
        String[] collor = new String[n];
        int time = 0;
        Pilha pilha = new Pilha(mat.length);
        for(int i = 0; i < n; i++){
            collor[i] = "white";
            predecessor[i] = -1;
        }
        for(int i = 0; i < mat.length; i++){
            if(collor[i].equals("white")){
                pilha.push(i);
                while(!pilha.isEmpty()){
                    int atual = pilha.top();
                    if(collor[atual].equals("white")){
                        collor[atual] = "gray";
                        discoveryTime[atual] = ++time;
                    }
                    List<Integer> neighboors = getNeighboors(mat, atual).stream()
                            .filter((Integer vertex) -> {
                                return collor[vertex].equals("white");
                            }).toList();
                    if (neighboors.isEmpty()){
                        pilha.pop();
                        finishTime[atual] = ++time;
                        collor[atual] = "black";
                    } else {
                        int firstNeighboor = neighboors.getFirst();
                        predecessor[firstNeighboor] = atual;
                        pilha.push(firstNeighboor);
                    }
                }
            }
        }
        return resultados;
    }

}
