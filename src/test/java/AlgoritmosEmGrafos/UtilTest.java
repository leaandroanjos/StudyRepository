package AlgoritmosEmGrafos;

import org.junit.Assert;
import org.junit.Test;

import static AlgoritmosEmGrafos.Util.transpoe;

public class UtilTest {

    @Test
    public void verificaTransposto(){
        int[][] matrizDeAdjascencia = {
                {1,0,1,1},
                {0,1,1,0},
                {0,0,1,0},
                {1,0,0,1}
        };
        int[][] transposto = transpoe(matrizDeAdjascencia);
        System.out.println("*Grafo Original*");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(matrizDeAdjascencia[i][j]);
            }
            System.out.println();
        }
        System.out.println("*Grafo Transposto*");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(transposto[i][j]);
            }
            System.out.println();
        }

        int[][] resultadoEsperado = {
                {1,0,0,1},
                {0,1,0,0},
                {1,1,1,0},
                {1,0,0,1}
        };

        Assert.assertEquals(transposto, resultadoEsperado);
    }

}
