
import javax.swing.JFormattedTextField;

import java.text.NumberFormat;

public class HourTextField extends JFormattedTextField {

    private Integer myIndex;

    public HourTextField (NumberFormat nf, int index) {
        super(nf);
        myIndex = index;
    }

    public Integer getIndex() {
        return this.myIndex;
    }

}
