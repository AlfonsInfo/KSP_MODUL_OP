
package view;
    
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PurchaseItemDto;

public class ShoppingChartView extends AbstractTableModel{
        private List<PurchaseItemDto> items;

    public ShoppingChartView(List<PurchaseItemDto> items) {
        this.items = items;
    }
    
    @Override
    public int getRowCount() {
       return  items.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
             case 2:
                 return "Jumlah";
             default :
                 return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return items.get(rowIndex).getProduct().getId();
            case 1:
                return items.get(rowIndex).getProduct().getName();
            case 2:
                return items.get(rowIndex).getQuantityPurchased();
            default:
                return null;
            }    
    }
    }

   
    
    
    
    
    
    
        
        
