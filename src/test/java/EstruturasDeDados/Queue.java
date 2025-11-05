package EstruturasDeDados;

import org.junit.Assert;
import org.junit.Test;

public class Queue {

    @Test
    public void QueueTest(){
        Fila<Integer> fila = new Fila<>();
        fila.push(2);
        fila.push(5);
        fila.push(8);
        Assert.assertEquals(3, fila.getSize());
        Assert.assertEquals(Integer.valueOf(2), fila.pop());
        Assert.assertEquals(Integer.valueOf(5), fila.pop());
        Assert.assertEquals(Integer.valueOf(8), fila.pop());
        Assert.assertEquals(0, fila.getSize());
    }

}
