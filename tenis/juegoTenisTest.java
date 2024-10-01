import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class juegoTenisTest {

    private juegoTenis juego;
    private juegoTenis juego2;

    @BeforeEach
    public void setUp() {
        juego = new juegoTenis("Jugador1", "Jugador2");
        juego2 = new juegoTenis("Jorge", "Pedro");
    }

    @Test
    public void losJugadoresEmpiezanConCeroPuntos() {
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void Jugador1PelotaExitoso() {
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 15 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void primerPunto() {
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 15 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void segundoPunto() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 30 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void tercerPunto() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 40 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void primerGame() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 1 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void primerPuntoJugador2() {
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 15 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void segundoPuntoJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 30 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void tercerPuntoJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 40 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void primerGameJugador2() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 1 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void primerPuntoSegundoGame() {
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 15 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 1 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
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
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 2 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
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
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 2 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
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
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 1 + " - Jugador2: " + 1 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void quinceAquince() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 15 + " - Jugador2: " + 15 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void treintaAtreinta() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 30 + " - Jugador2: " + 30 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void cuarentaAcuarenta() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 40 + " - Jugador2: " + 40 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0 + " | Deuce";
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void reiniciarPuentos() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 1 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }

    @Test
    public void hayDeuce() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 40 + " - Jugador2: " + 40 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0 + " | Deuce";
        assertEquals(puntuacion, juego.obtenerMarcador());
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
        String puntuacion = "Puntajes: Jugador1: " + 40 + " - Jugador2: " + 40 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0 + " | Ventaja Jugador1";
        assertEquals(puntuacion, juego.obtenerMarcador());
    }
    
    @Test
    public void matchPointGameJugador2() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 1 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }
    
    @Test
    public void matchPointGameJugador1() {
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador2");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 1 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
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
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 1 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
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
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 6 + " - Jugador2: " + 5 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }
    
    @Test
    public void ganarSetTieBreack(){
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
        //Game12
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 1 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }
    
    @Test
    public void obtenerGanador(){
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
        //Game7
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game8
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game9
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game10
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game11
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game12
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game13
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game14
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game15
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game16
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game17
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        //Game18
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        juego.pelotaExitosa("Jugador1");
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Sets: Jugador1: " + 3 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }
    
    @Test
    public void obtenerMarcador(){
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
        String puntuacion = "Puntajes: Jugador1: " + 0 + " - Jugador2: " + 0 +
                          " | Games: Jugador1: " + 5 + " - Jugador2: " + 4 +
                          " | Sets: Jugador1: " + 0 + " - Jugador2: " + 0;
        assertEquals(puntuacion, juego.obtenerMarcador());
    }
    
    @Test
    public void matchPointGameJorge() {
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Jorge");
        String puntuacion = "Puntajes: Jorge: " + 0 + " - Pedro: " + 0 +
                          " | Games: Jorge: " + 1 + " - Pedro: " + 0 +
                          " | Sets: Jorge: " + 0 + " - Pedro: " + 0;
        assertEquals(puntuacion, juego2.obtenerMarcador());
    }
    
    @Test
    public void matchPointGamePedro() {
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Jorge");
        juego2.pelotaExitosa("Pedro");
        juego2.pelotaExitosa("Pedro");
        String puntuacion = "Puntajes: Jorge: " + 0 + " - Pedro: " + 0 +
                          " | Games: Jorge: " + 0 + " - Pedro: " + 1 +
                          " | Sets: Jorge: " + 0 + " - Pedro: " + 0;
        assertEquals(puntuacion, juego2.obtenerMarcador());
    }
}