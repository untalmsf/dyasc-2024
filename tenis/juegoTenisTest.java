
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class juegoTenisTest {

    private juegoTenis juego;

    @BeforeEach
    public void setUp() {
        juego = new juegoTenis("Jugador 1", "Jugador 2");
    }

    @Test
    public void losJugadoresEmpiezanConCeroPuntos() {
        assertEquals(0, juego.obtenerPuntaje("Jugador 1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador 2"));
    }
    @Test
    public void Jugador1PelotaExitoso() {
        juego.pelotaExitosa("jugador1");
        assertEquals(15, juego.obtenerPuntaje("Jugador 1"));
    }
    
    @Test
    public void primerPunto() {
        juego.pelotaExitosa("jugador1");
        assertEquals(15, juego.obtenerPuntaje("Jugador 1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador 2"));
    }
}
