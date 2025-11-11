package AlgoritmosEmGrafos;

import org.junit.Test;

import java.util.*;

import static AlgoritmosEmGrafos.KosajaruSharir.kosarajuSharir;
import static org.junit.Assert.*;

public class KosarajuTest {

    @Test
    public void deveEncontrarComponentesFortementeConectados() {
        // 0 -> 1, 1 -> 2, 2 -> 0 formam um ciclo (1 SCC)
        // 3 fica isolado (outra SCC)
        int[][] grafo = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0}
        };

        List<int[]> resultado = kosarajuSharir(grafo);

        assertNotNull(resultado);
        assertEquals(3, resultado.size());

        int[] predecessor = resultado.get(2);
        assertNotNull(predecessor);
        assertEquals(grafo.length, predecessor.length);

        // monta SCCs a partir do predecessor do SEGUNDO DFS
        Map<Integer, List<Integer>> sccs = agruparPorRaiz(predecessor);

        // esperamos exatamente 2 SCCs: {0,1,2} e {3}
        assertEquals(2, sccs.size());

        // transforma em conjuntos para facilitar comparação independente da ordem
        List<Set<Integer>> conjuntos = new ArrayList<>();
        for (List<Integer> comp : sccs.values()) {
            conjuntos.add(new HashSet<>(comp));
        }

        Set<Integer> sccGrande = new HashSet<>(Arrays.asList(0, 1, 2));
        Set<Integer> sccSozinho = new HashSet<>(Collections.singletonList(3));

        // verifica que as duas SCCs esperadas estão na lista
        assertTrue(contemConjunto(conjuntos, sccGrande));
        assertTrue(contemConjunto(conjuntos, sccSozinho));
    }

    /**
     * Para cada vértice, sobe pelo predecessor até achar a raiz (predecessor == -1)
     * e agrupa todo mundo pela raiz encontrada.
     */
    private Map<Integer, List<Integer>> agruparPorRaiz(int[] predecessor) {
        Map<Integer, List<Integer>> mapa = new HashMap<>();

        for (int v = 0; v < predecessor.length; v++) {
            int raiz = encontrarRaiz(v, predecessor);
            mapa.computeIfAbsent(raiz, k -> new ArrayList<>()).add(v);
        }

        return mapa;
    }

    private int encontrarRaiz(int v, int[] predecessor) {
        int atual = v;
        while (predecessor[atual] != -1) {
            atual = predecessor[atual];
        }
        return atual;
    }

    private boolean contemConjunto(List<Set<Integer>> lista, Set<Integer> alvo) {
        for (Set<Integer> s : lista) {
            if (s.equals(alvo)) {
                return true;
            }
        }
        return false;
    }
}
