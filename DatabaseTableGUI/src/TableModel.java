import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {

    List<Entity> entityList = new ArrayList<>();
    private final String[] HEADER = {"ID", "First Name", "Last Name", "Departments"};

    public void setList(List<Entity> listProduct) {
        this.entityList = listProduct;
    }

    public void save(Entity entity) {
        entityList.add(entity);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, Entity entity) {
        entityList.set(index, entity);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        entityList.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Entity findOne(int index) {
        return entityList.get(index);
    }

    public boolean findById(long id){

        for(int i = 0; i< entityList.size(); i++){

            if( entityList.get(i).getId()==id){
                return  true;
            }
        }

        return false;
    }

    public int getRowCount() {
        return entityList.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    public String getColumnName(int column) {
        return HEADER[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Entity product = entityList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return product.getId();

            case 1:
                return product.getFirstName();

            case 2:
                return product.getLastName();

            case 3:
                return product.getDepartment();

            default:
                return null;
        }
    }
}

