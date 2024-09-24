public class juegoTenis {

    int puntaje1;
    int puntaje2;

    public juegoTenis(String jugador1, String jugador2) {
        this.puntaje1 = 0;
        this.puntaje2 = 0;
    }

    public int obtenerPuntaje(String jugador) {
        if (jugador.equals("Jugador1")) {
            return this.puntaje1;
        }

        return this.puntaje2;
    }

    public void pelotaExitosa(String jugador) {
        if (jugador.equals("Jugador1")) {
            this.puntaje1 += 15;
        } else
            this.puntaje2 = 0;

    }
}
