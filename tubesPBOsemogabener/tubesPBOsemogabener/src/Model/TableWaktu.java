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
public class TableWaktu extends AbstractTableModel {

    private List<WaktuTersediaForm> listWaktu;
    
    @Override
    public int getRowCount() {
        return listWaktu.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return listWaktu.get(rowIndex).getWaktuTersedia();
            case 1: return listWaktu.get(rowIndex).getKodeAgensi();
            default: return null;
        }
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "WAKTU";
            case 1: return "KODE AGENSI";
            default: return null;
        }
    }
    
    public TableWaktu(List<WaktuTersediaForm> list){
        this.listWaktu = list;
    }
    
}
