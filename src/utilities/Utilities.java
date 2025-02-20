package utilities;

import javax.swing.*;
import java.awt.*;

public class Utilities {

    public static void ativaDesativa(boolean estadoBotoes, JPanel painel){

        Component[] matrizComponentes = painel.getComponents();
        for (Component componenteAtualDaMatriz : matrizComponentes) {

            if (componenteAtualDaMatriz instanceof JButton) {

                if ((((JButton) componenteAtualDaMatriz).getActionCommand() == "0")){
                    componenteAtualDaMatriz.setEnabled(estadoBotoes);
                } else if (((JButton) componenteAtualDaMatriz).getActionCommand() == "1"){
                    componenteAtualDaMatriz.setEnabled(!estadoBotoes);
                }
            }
        }
    }
    public static void limpaComponentes(boolean status, Container container) {
        Component[] componentes = container.getComponents();

        for (Component componente : componentes) {
            if (componente instanceof JPanel || componente instanceof JTabbedPane) {
                limpaComponentes(status, (Container) componente);  // Recursão para subpainéis e abas
            } else if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
            } else if (componente instanceof JTextArea) {
                ((JTextArea) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof JPasswordField) {
                ((JPasswordField) componente).setText("");
            }
            componente.setEnabled(status);
        }
    }


}
