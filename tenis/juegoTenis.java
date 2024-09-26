public class juegoTenis {

    int puntaje1;
    int puntaje2;
    int games1;
    int games2;
    int set1;
    int matchpoint;

    public juegoTenis(String jugador1, String jugador2) {
        this.puntaje1 = 0;
        this.puntaje2 = 0;
        this.games1 = 0;
        this.games2 = 0;
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
            } else if (this.puntaje1 == 40 && this.hayDeuce() && this.matchpoint == 1) {
                this.puntaje1 = 0;
                this.puntaje2 = 0;
                this.matchpoint = 0;
                this.games1 += 1;   
            } else if (this.puntaje1 == 40 && this.hayDeuce() && this.matchpoint <= 0){
                this.matchpoint += 1;
            } else if (this.puntaje1 == 40 && !this.hayDeuce()) {
                this.puntaje1 = 0;
                this.puntaje2 = 0;
                this.matchpoint = 0;
                this.games1 += 1;
            } else
                this.puntaje1 += 15;
        } else
            if (this.puntaje2 == 30) {
                this.puntaje2 = 40;
            } else if (this.puntaje2 == 40 && this.hayDeuce() && this.matchpoint == -1) {
                this.puntaje1 = 0;
                this.puntaje2 = 0;
                this.matchpoint = 0;
                this.games2 += 1;
            }else if (this.puntaje2 == 40 && this.hayDeuce() && this.matchpoint >= 0){
                this.matchpoint += -1;
            }else if (this.puntaje2 == 40 && !this.hayDeuce()) {
                this.puntaje1 = 0;
                this.puntaje2 = 0;
                this.matchpoint = 0;
                this.games2 += 1;
            } else
                this.puntaje2 += 15;
    }
    
    public int[] marcador(String jugador1, String jugador2) {
        int[] marcador = {this.obtenerPuntaje(jugador1), this.obtenerPuntaje(jugador2),this.matchpoint, this.games1, this.games2};
        return marcador;
    }

    public boolean hayDeuce(){
        if (this.puntaje1 == 40 && this.puntaje2 == 40){
            return true;
        } else 
            return false;
    }

    

}