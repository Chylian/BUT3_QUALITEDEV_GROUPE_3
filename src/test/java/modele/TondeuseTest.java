package modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;

public class TondeuseTest {

    private Tondeuse tondeuse;

    @Test
    public void testAvancerNord() throws DeplacementException {
        tondeuse = new Tondeuse(10, 10, 5, 5, EDirection.NORTH);

        tondeuse.deplacement(EDeplacement.A);

        assertEquals(5, tondeuse.getCaseFinale().getX());
        assertEquals(6, tondeuse.getCaseFinale().getY()); // Y + 2 dans ton code
    }

    @Test
    public void testAvancerEst() throws DeplacementException {
        tondeuse = new Tondeuse(10, 10, 5, 5, EDirection.EAST);

        tondeuse.deplacement(EDeplacement.A);

        assertEquals(6, tondeuse.getCaseFinale().getX());
        assertEquals(5, tondeuse.getCaseFinale().getY());
    }

    @Test
    public void testAvancerSud() throws DeplacementException {
        tondeuse = new Tondeuse(10, 10, 5, 5, EDirection.SOUTH);

        tondeuse.deplacement(EDeplacement.A);

        assertEquals(5, tondeuse.getCaseFinale().getX());
        assertEquals(4, tondeuse.getCaseFinale().getY());
    }

    @Test
    public void testAvancerOuest() throws DeplacementException {
        tondeuse = new Tondeuse(10, 10, 5, 5, EDirection.WEST);

        tondeuse.deplacement(EDeplacement.A);

        assertEquals(4, tondeuse.getCaseFinale().getX());
        assertEquals(5, tondeuse.getCaseFinale().getY());
    }

    @Test(expected = DeplacementException.class)
    public void testAvancerHorsLimitesThrowsException() throws DeplacementException {
        // En (0,0) face à l'Ouest : X devient -1
        tondeuse = new Tondeuse(5, 5, 0, 0, EDirection.WEST);

        tondeuse.deplacement(EDeplacement.A);
    }
}