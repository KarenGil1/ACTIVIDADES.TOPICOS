
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vane_
 */
public class Hilo extends Thread {

    private static volatile boolean finalizado = false;
    JProgressBar barraprogreso;

    public Hilo(JProgressBar bar) {
        barraprogreso = bar;
    }

    @Override
    public void run() {
        int min = barraprogreso.getMinimum();
        int max = barraprogreso.getMaximum();

        for (int i = 1; i <= max; i++) {
            if (finalizado) {
                break;
            }
            int value = barraprogreso.getValue();
            barraprogreso.setValue(1 + value);
            barraprogreso.repaint();
            if (i == max) {
                finalizado = true;
                JOptionPane.showMessageDialog(barraprogreso, "El hilo" + this.getName() + "ha terminado");
                break;
            }
        }

    }
}
