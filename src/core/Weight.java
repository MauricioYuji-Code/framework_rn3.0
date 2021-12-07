package core;

import java.io.Serializable;

public class Weight implements Serializable, Cloneable {

    /**
     * Valor Peso
     */
    public double value;

    /**
     * Muda Peso
     */
    public double weightChange;


    /**
     * Cria uma instancia de connection weight com valor aleatorio de peso dentro de [-1 .. 1]
     */
    public Weight() {
        this.value = Math.random() - 1d;
        this.weightChange = 1;
    }

    /**
     * Cria uma instancia de connection weight com valor especifico de peso
     */
    public Weight(double value) {
        this.value = value;
    }

    /**
     * Define um valor de peso
     */
    public final void setValue(double value) {
        this.value = value;
    }

    /**
     * Retorna o valor do peso
     */
    public final double getValue() {
        return this.value;
    }
}
