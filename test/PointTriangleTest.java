import org.junit.Test;
import org.mockito.Matchers;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
public class PointTriangleTest {

    @Test
    public void testValueDefault() {
        PointTriangle pointTriangle = new PointTriangle();
        pointTriangle.valueDefault();
        assertEquals(pointTriangle.width,800);
        assertEquals(pointTriangle.height,600);
        assertEquals(pointTriangle.speed,3);
        assertEquals(pointTriangle.pA, new Point(100,100));
        assertEquals(pointTriangle.pB, new Point(400,200));
        assertEquals(pointTriangle.pC, new Point(400,600));
        assertEquals(pointTriangle.stepA, new Point(3,3));
        assertEquals(pointTriangle.stepB, new Point(-3,-3));
        assertEquals(pointTriangle.stepC, new Point(3,-3));
    }

    @Test
    public void testRelogio() {
        Graphics g = mock(Graphics.class);
        PointTriangle pointTriangle = mock(PointTriangle.class);
        doCallRealMethod().when(pointTriangle).relogio(Matchers.any(Graphics.class));
        pointTriangle.speed = 3;
        pointTriangle.pA = new Point(10,10);
        pointTriangle.pB = new Point(400,10);
        pointTriangle.pC = new Point(400,400);
        pointTriangle.stepA = new Point(pointTriangle.speed,pointTriangle.speed);
        pointTriangle.stepB = new Point(-pointTriangle.speed,pointTriangle.speed);
        pointTriangle.stepC = new Point(pointTriangle.speed,pointTriangle.speed);
        pointTriangle.relogio(g);
        verify(pointTriangle,times(1)).relogio(g);
    }

    @Test
    public void testCls() {
        Graphics g = mock(Graphics.class);
        PointTriangle pointTriangle = mock(PointTriangle.class);
        doCallRealMethod().when(pointTriangle).cls(Matchers.any(Graphics.class));
        pointTriangle.cls(g);
        verify(pointTriangle,times(1)).cls(g);
    }
}
