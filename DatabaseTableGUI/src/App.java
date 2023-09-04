import com.mysql.cj.jdbc.MysqlDataSource;

public class App {

    private static Service studentService;

    public static Service getStudentService() {
        return studentService;
    }


    public static void main(String[] args) {


        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword(" ");
        dataSource.setURL("jdbc:mysql://localhost:3306/university");
        dataSource.setServerName("localhost");

        studentService = new Service();
        studentService.setDataSource(dataSource);

        java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }
}
