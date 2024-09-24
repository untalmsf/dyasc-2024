public class juegoTenis {

    int puntaje;

    public juegoTenis(String jugador1, String jugador2) {
        this.puntaje = 0;
    }

    public int obtenerPuntaje(String jugador) {
        return this.puntaje;
    }

    public int pelotaExitosa(String jugador) {
        this.puntaje = 15;
        return this.puntaje;
    }
}
