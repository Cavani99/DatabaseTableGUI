import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {

    List<Student> studentList = new ArrayList<Student>();
    private final String[] HEADER = {"ID", "First Name", "Last Name", "Departments"};

    public void setList(List<Student> listProduct) {
        this.studentList = listProduct;
    }

    public void save(Student student) {
        studentList.add(student);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, Student student) {
        studentList.set(index, student);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        studentList.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Student findOne(int index) {
        return studentList.get(index);
    }

    public boolean findById(long id){

        for(int i=0;i<studentList.size();i++){

            if( studentList.get(i).getId()==id){
                return  true;
            }
        }

        return false;
    }

    public int getRowCount() {
        return studentList.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    public String getColumnName(int column) {
        return HEADER[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student product = studentList.get(rowIndex);

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

