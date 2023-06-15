package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableDataRumah extends AbstractTableModel{

    private List<DataRumah> listRumah;
    
    @Override
    public int getRowCount() {
        return listRumah.size();
    }

    @Override
    public int getColumnCount() {
        return listRumah.getClass().getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return listRumah.get(rowIndex).getIdRumah();
            case 1: return listRumah.get(rowIndex).getNamaRumah();
            case 2: return listRumah.get(rowIndex).getAlamat();
            case 3: return listRumah.get(rowIndex).getHarga();
            case 4: return listRumah.get(rowIndex).getKodeAgensi(); 
            case 5: return listRumah.get(rowIndex).getLuasTanah(); 
            default: return null;
        }
    }
    
    public List<Object> getColumnValues(int columnIndex) {
        List<Object> columnValues = new ArrayList<>();

        for (int row = 0; row < 4; row++) {
            Object value = getValueAt(row, columnIndex);
            columnValues.add(value);
        }

        return columnValues;
    }
    
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "idRumah";
            case 1: return "Nama Rumah";
            case 2: return "Alamat";
            case 3: return "Harga (Juta)";
            case 4: return "Agensi";
            case 5: return "LuasTanah M"+'\u00B2';
            default: return null;
        }
    }
    
    public TableDataRumah(List<DataRumah> listRumah){
        this.listRumah = listRumah;
    }

}
