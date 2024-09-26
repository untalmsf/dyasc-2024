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

    @Test
    public void reiniciarPuentos() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        int[] marcador = juego.marcador("Jugador1","Jugador2");
        assertEquals(0, marcador[0]);
        assertEquals(0, marcador[1]);
        assertEquals(0, marcador[2]);
        assertEquals(1, marcador[3]);
        assertEquals(0, marcador[4]);
    }

    @Test
    public void hayDeuce() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        int[] marcador = juego.marcador("Jugador1","Jugador2");
        assertTrue(juego.hayDeuce());
        assertEquals(40, marcador[0]);
        assertEquals(40, marcador[1]);
        assertEquals(0, marcador[2]);
        assertEquals(0, marcador[3]);
    }
    
    @Test
    public void matchPoint() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        int[] marcador = juego.marcador("Jugador1","Jugador2");
        assertEquals(40, marcador[0]);
        assertEquals(40, marcador[1]);
        assertEquals(1, marcador[2]);
        assertEquals(0, marcador[3]);
        assertEquals(0, marcador[4]);
    }
    @Test
    public void ganarSet(){
        //Game1
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game2
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game3
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game4
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game5
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game6
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        int[] marcador = juego.marcador("Jugador1","Jugador2");
        assertEquals(0, marcador[0]);
        assertEquals(0, marcador[1]);
        assertEquals(0, marcador[2]);
        assertEquals(0, marcador[3]);
        assertEquals(0, marcador[4]);
        assertEquals(1, juego.obtenerSet(1));
    }
    @Test
    public void ganarGame5a6(){
        //Game1
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game2
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game3
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game4
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game5
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game6
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        //Game7
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        //Game8
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        //Game9
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        //Game10
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        //Game11
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        int[] marcador = juego.marcador("Jugador1","Jugador2");
        assertEquals(0, marcador[0]);
        assertEquals(0, marcador[1]);
        assertEquals(0, marcador[2]);
        assertEquals(6, marcador[3]);
        assertEquals(5, marcador[4]);
        assertEquals(0, juego.obtenerSet(1));
        assertEquals(0, juego.obtenerSet(2));
    }
}