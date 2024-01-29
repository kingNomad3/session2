package BorneInformatisee;

import java.util.GregorianCalendar;

public class Piece {
    private double VINGT_CINQ_SOU;
    private double UN_DOLLARD;
    private double DEUX_DOLLARD;

    public Piece() {
        this.VINGT_CINQ_SOU = 0.25;
        this.UN_DOLLARD = 1;
        this.DEUX_DOLLARD = 2;
    }

    public double getVINGT_CINQ_SOU() {
        return VINGT_CINQ_SOU;
    }

    public double getUN_DOLLARD() {
        return UN_DOLLARD;
    }

    public double getDEUX_DOLLARD() {
        return DEUX_DOLLARD;
    }

    public void setVINGT_CINQ_SOU(double VINGT_CINQ_SOU) {
        this.VINGT_CINQ_SOU = VINGT_CINQ_SOU;
    }

    public void setUN_DOLLARD(double UN_DOLLARD) {
        this.UN_DOLLARD = UN_DOLLARD;
    }

    public void setDEUX_DOLLARD(double DEUX_DOLLARD) {
        this.DEUX_DOLLARD = DEUX_DOLLARD;
    }
}

