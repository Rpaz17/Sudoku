/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author MARTI
 */
import java.util.Random;
import javax.swing.JTextField;

import java.util.Random;

import java.util.Random;

public class Logica {

    private int sudoku[][];

    public Logica() {
        sudoku = new int[9][9];
        LIMPIAR();
    }

    public boolean RESOLVER() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    for (int valor = 1; valor <= 9; valor++) {
                        if (VAL_FILA(i, valor) && VAL_COLUMNA(j, valor) && VAL_CUADRANTE(i, j, valor)) {
                            sudoku[i][j] = valor;
                            if (RESOLVER()) {
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean COMPROBACION() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                int aux = sudoku[i][j];
                sudoku[i][j] = 0;
                if (!VAL_FILA(i, aux) || !VAL_COLUMNA(j, aux) || !VAL_CUADRANTE(i, j, aux)) {
                    sudoku[i][j]=aux;
                    return false;

                }
                sudoku[i][j]=aux;
            }
        }
        return true;
    }

    public boolean VAL_CUADRANTE(int i, int j, int valor) {
        int posI = subCuadranteActual(i);
        int posJ = subCuadranteActual(j);

        for (int k = posI - 3; k < posI; k++) {
            for (int l = posJ - 3; l < posJ; l++) {
                if (sudoku[k][l] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public void LIMPIAR() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                sudoku[i][j] = 0;
            }
        }
    }

    public int subCuadranteActual(int pos) {
        if (pos <= 2) {
            return 3;
        } else if (pos <= 5) {
            return 6;
        } else {
            return 9;
        }
    }

    public boolean VAL_FILA(int i, int valor) {
        for (int j = 0; j < sudoku[i].length; j++) {
            if (sudoku[i][j] == valor) {
                return false;
            }
        }
        return true;
    }

    public boolean VAL_COLUMNA(int j, int valor) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][j] == valor) {
                return false;
            }
        }
        return true;
    }

    public void MOSTRAR() {
        RESOLVER();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j]);
                if (!(j == sudoku[0].length - 1)) {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public void GENERAR(int nivel) {
        LIMPIAR();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = random.nextInt(9) + 1;
                if (VAL_CUADRANTE(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                int num = random.nextInt(9) + 1;
                if (VAL_CUADRANTE(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }

        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                int num = random.nextInt(9) + 1;
                if (VAL_CUADRANTE(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        RESOLVER();

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                int aux = j;
                int rand = random.nextInt(nivel + 1);
                j += rand;
                for (int k = aux; k < j && k < sudoku.length; k++) {
                    sudoku[i][k] = 0;
                }
            }
        }

    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

}