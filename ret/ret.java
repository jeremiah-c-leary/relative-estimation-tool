import javax.swing.*;

public class ret {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run () {

                new mainFrame();
       
            }
        });
    }
}
