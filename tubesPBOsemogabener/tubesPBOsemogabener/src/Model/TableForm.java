/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TableForm extends AbstractTableModel{

    private List<Form> listForm;
    
    @Override
    public int getRowCount() {
                return listForm.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return listForm.get(rowIndex).getIdForm();
            case 1: return listForm.get(rowIndex).getNamaRumah();
            case 2: return listForm.get(rowIndex).getIdRumah();
            case 3: return listForm.get(rowIndex).getIdPembeli();
            case 4: return listForm.get(rowIndex).getStatus();
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID FORM";
            case 1: return "Nama Rumah";
            case 2: return "ID RUMA";
            case 3: return "ID PEMBELI";
            case 4: return "STATUS";
            default: return null;
        }
    }
    
    public TableForm(List<Form> list){
        this.listForm = list;
    }
    
}
