package Model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class ComboBoxListWaktu extends DefaultComboBoxModel<String>{
    
    public ComboBoxListWaktu(List<String> listWaktuTersedia) {
        for (String waktu : listWaktuTersedia) {
            addElement(waktu);
        }
    }

   
}
