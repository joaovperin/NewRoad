/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.manager;

/**
 * Descrição da classe.
 */
public class TimeManager implements Runnable {

    private int timePass;
    private final int DELAY_1_MS = 1;

    private boolean isRunning;

    public void start(int timePass) {
        this.timePass = timePass;
    }

    @Override
    public void run() {
        this.isRunning = true;
        try {
            Thread.sleep(DELAY_1_MS * timePass);
        } catch (InterruptedException e) {
            System.out.println("Thread Sleep Exc.: " + e);
        }
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

}
