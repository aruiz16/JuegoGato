/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro RG
 */
public class Gato {

    private int[][] datos;
    private String jugador1;
    private String jugador2;
    private int tiroJ1;     // 1 = "x", 2 = "O"
    private int tiroJ2;
    private boolean turnoJ1;   // True = le toca al jugador 1, false = le toca al jugador 2
    private int tiros;  // Número de tiros realizados 
    private boolean perTiro;
    private boolean caro;

    public boolean isCaro() {
        return caro;
    }

    public void setCaro(boolean caro) {
        this.caro = caro;
    }
    
    public boolean isPerTiro() {
        return perTiro;
    }

    public void setPerTiro(boolean perTiro) {
        this.perTiro = perTiro;
    }

    
    public Gato() {
        datos = new int[3][3];
        turnoJ1 = true;
        tiros = 0;
    }

    /**
     * En este método se obtiene el setJugador1 para mandarlo llamar
     * dentro de otras clases.
     * @param jugador1 
     */
    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * En este método se obtiene el setJugador2 para mandarlo llamar
     * dentro de otras clases.
     * @param jugador2 
     */
    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     * En este método se verifica la posición en la que se va a insertar el dato
     * ya sea X o O dependiendo de quien va a tirar y con que elemento.
     * @param pos 
     */
    public void setTiro(int pos) {
        //if (tiros < 9 && ganador() == 0) {
            int x;
            int y;
            x = pos / 3;
            y = pos % 3;
            if (turnoJ1) {
                datos[x][y] = tiroJ1;
            } else {
                datos[x][y] = tiroJ2;
            }
        //}
    }

    /**
     * En este método se verifica quien es el tirador, si =1 significa que es
     * el turno del jugador1, si es =2 entonces es el turno del jugadior2
     * @param tiroJ1 
     */
    public void setTiroJ1(int tiroJ1) {
        this.tiroJ1 = tiroJ1;
        if (tiroJ1 == 1) {  //Tira "X"
            tiroJ2 = 2;       //Tira "O"
        } else {
            tiroJ2 = 1;
        }
    }

    /**7
     * En este método se utiliza para cambiar de turno y dependiendo de a quien
     * le toque, le hará la sumatoria de las posiciones para saber el ganador
     */
    public void cambiarTurno() {
        if (turnoJ1) {
            turnoJ1 = false;
        } else {
            turnoJ1 = true;
        }
        tiros++;
    }

    /**
     * Este método nos regresa el turnoJ1 y es "is" por ser boolean
     * @return 
     */
    public boolean isTurnoJ1() {
        return turnoJ1;
    }

    /**
     * Devuelve el tiroJ1
     * @return 
     */
    public int getTiroJ1() {
        return tiroJ1;
    }

    /**
     * Devuelve el tiroj2
     * @return 
     */
    public int getTiroJ2() {
        return tiroJ2;
    }

    /**
     * Devuelve los tiros registrados del jugador
     * @return 
     */
    public int getTiros() {
        return tiros;
    }

    /**
     * Devuelve el nombre del jugador 1
     * @return 
     */
    public String getJugador1() {
        return jugador1;
    }

    /**
     * Devuelve el nombre del jugador 2
     * @return 
     */
    public String getJugador2() {
        return jugador2;
    }

    /**
     * En este método se obtiene el ganador del juego
     * verifica el arreglo y si se tiene 3 "X" o 3 "O" en linea, es así
     * como se gana el juego
     * @return 
     */
    public int ganador() {
        //int win = 0;   //No hay ganador aún
        if (datos[0][0] != 0 && datos[0][0] == datos[0][1]
                && datos[0][0] == datos[0][2]) {
            return 1;
        }
        if (datos[1][0] != 0 && datos[1][0] == datos[1][1]
                && datos[1][0] == datos[1][2]) {
            return 2;
        }
        if (datos[2][0] != 0 && datos[2][0] == datos[2][1]
                && datos[2][0] == datos[2][2]) {
            return 3;
        }
        if ( datos[0][0] != 0 && datos[0][0] == datos[1][0]
                && datos[0][0] == datos[2][0]) {
            return 4;
        }
        if (datos[0][1] != 0 && datos[0][1] == datos[1][1]
                && datos[0][1] == datos[2][1]) {
            return 5;
        }
        if ( datos[0][2] != 0 && datos[0][2] == datos[1][2]
                && datos[0][2] == datos[2][2]) {
            return 6;
        }
        if (datos[0][0] != 0 && datos[0][0] == datos[1][1]
                && datos[0][0] == datos[2][2]) {
            return 7;
        }
        if ( datos[2][0] != 0 && datos[2][0] == datos[1][1]
                && datos[2][0] == datos[0][2]) {
            return 8;
        }
        return 0;
    }

    /**
     * Verifica si no hay ningun ganador, es decir si se utilizaron todas 
     * las posiciones disponibles.
     * @return true = si aún quedan espacios
     * false = si no hay espacios disponibles
     */
    public boolean esEmpate() {
        if (ganador() == 0 && tiros == 9) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * En este método se inicializan los valores en cero para reiniciar el
     * juego.
     */
    public void reiniciar() {
        for ( int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                datos[i][j] = 0;
            }
        }
        tiros = 0;
        turnoJ1 = true;
    }
}
