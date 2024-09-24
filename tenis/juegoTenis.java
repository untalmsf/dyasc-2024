public class juegoTenis {

    int puntaje1;
    int puntaje2;
    int set1;
    int set2;

    public juegoTenis(String jugador1, String jugador2) {
        this.puntaje1 = 0;
        this.puntaje2 = 0;
        this.set1 = 0;
        this.set2 = 0;
    }

    public int obtenerPuntaje(String jugador) {
        if (jugador.equals("Jugador1")) {
            return this.puntaje1;
        }

        return this.puntaje2;
    }

    public void pelotaExitosa(String jugador) {
        if (jugador.equals("Jugador1")) {
            if (this.puntaje1 == 30) {
                this.puntaje1 = 40;
            } else if (this.puntaje1 == 40) {
                this.puntaje1 = 0;
                this.set1 = 1;
            } else
                this.puntaje1 += 15;
        } else
            if (this.puntaje2 == 30) {
                this.puntaje2 = 40;
            }else
                this.puntaje2 += 15;

    }
}
