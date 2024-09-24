
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
    public void segundoPunto() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(30, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void tercerPunto() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(40, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void primerGame() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void primerPuntoJugador2() {
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(15, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void segundoPuntoJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(30, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void tercerPuntoJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(40, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void primerGameJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void primerPuntoSegundoGame() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void segundoGameGanadoJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void segundoGameGanadoJugador1() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void segundoGameTerminado() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        assertEquals(0, juego.obtenerPuntaje("Jugador1"));
        assertEquals(0, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void quinceAquince() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        assertEquals(15, juego.obtenerPuntaje("Jugador1"));
        assertEquals(15, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void treintaAtreinta() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        assertEquals(30, juego.obtenerPuntaje("Jugador1"));
        assertEquals(30, juego.obtenerPuntaje("Jugador2"));
    }

    @Test
    public void cuarentaAcuarenta() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        assertEquals(40, juego.obtenerPuntaje("Jugador1"));
        assertEquals(40, juego.obtenerPuntaje("Jugador2"));
    }

}
