package AlgoritmosEmGrafos;

import EstruturasDeDados.Pilha;

import java.util.*;

import static AlgoritmosEmGrafos.DFS.dfsIterativo;
import static AlgoritmosEmGrafos.Util.getNeighboors;
import static AlgoritmosEmGrafos.Util.transpoe;

public class KosajaruSharir {

    public static List<int[]> kosarajuSharir(int[][] mat){
        List<int[]> result = dfsIterativo(mat);
        int[][] transposto = transpoe(mat);
        //Aqui vai precisar de uma fila de prioridade para implementar (Ordenado pelo tempo de término)
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] termino = result.get(1);
        HashMap<Integer, Integer> termino_vertex = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            heap.add(termino[i]);
            //Mapa do termino para o vetex
            termino_vertex.put(termino[i], i);
        }
        return dfsQueue(transposto, heap, termino_vertex);
    }

    public static List<int[]> dfsQueue(int[][] mat, PriorityQueue<Integer> heap, HashMap<Integer, Integer> termino_vertex){
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
        for(int i = 0; i < n; i++){
            collor[i] = "white";
            predecessor[i] = -1;
        }
        while (!heap.isEmpty()){
            dfsVisit(mat, termino_vertex.get(heap.poll()), collor, resultados, time);
        }
        return resultados;
    }

    public static void dfsVisit(int[][] mat, int vertex, String[] collor, List<int[]> resultados, int time){
        resultados.get(0)[vertex] = ++time;
        collor[vertex] = "gray";
        List<Integer> neighboors = getNeighboors(mat, vertex).stream()
                .filter((Integer v) -> {
                    return collor[v].equals("white");
                }).toList();
        for(Integer neighboor : neighboors){
            resultados.get(2)[neighboor] = vertex;
            dfsVisit(mat, neighboor, collor, resultados, time);
        }
        resultados.get(1)[vertex] = ++time;
    }

    public static int[][] getSCC(int[][] mat){
        int n = mat.length;
        List<int[]> resultado = kosarajuSharir(mat);
        int[] predecessor = resultado.get(2);
        int[] componentOf = new int[n]; //Inicializado com 0
        int comp = 1;
        for(int i = 0; i < n; i++){
            if(componentOf[i] == 0) //Significa que ele ainda não tem componente
                getComponent(predecessor, comp, i, componentOf);
        }
        return null;
    }

    public static int getComponent(int[] predecessor, int comp, int i, int[] componentOf){
        if(predecessor[i] == -1){ //Raíz da DFS-Tree
            componentOf[i] = comp;
            comp++;
            return comp-1;
        } else {
            componentOf[i] = getComponent(predecessor, comp, predecessor[i], componentOf);
        }
        throw new Error("Critério de parada não alcançado em getComponent");
    }
}
