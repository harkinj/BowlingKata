import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }
    @Test
    public void testGutterGame() {
        rollMany(20,0);
        assertEquals(0, g.score());
    }


    @Test
    public void testAllOnes() {
        //Setup
        rollMany(20, 1);
        assertEquals(20, g.score());
    }


    @Test
    public void testOneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    @Test
    public void testOneStrike() {

        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(17, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectScore() {

        rollMany(12, 10);
        assertEquals(300, g.score());
    }

    private void rollStrike() {
        g.roll(10);
    }


    private void rollMany(int numRolls, int pins) {
        for (int i = 0; i < numRolls; i++) {
            g.roll(pins);
        }
    }


    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

}
