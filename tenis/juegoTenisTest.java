
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class juegoTenisTest {

    private juegoTenis juego;

    @BeforeEach
    public void setUp() {
        juego = new juegoTenis("Jugador1", "Jugador2");
    }

    @Test
    public void losJugadoresEmpiezanConCeroPuntos() {
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void Jugador1PelotaExitoso() {
        juego.pelotaExitosa("Jugador1");
        assertEquals(15, juego.obtenerPuntaje("Jugador1"));
    }

    @Test
    public void primerPunto() {
        juego.pelotaExitosa("Jugador1");
        assertEquals(15, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void SegundoPunto() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(30, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void TercerPunto() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(40, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void PrimerGame() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void primerPuntoJugador2() {
        juego.pelotaExitosa("Jugador1");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(15, juego.obtenerPuntaje("Jugador2"));
    }

}
