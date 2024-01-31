import com.mysql.cj.jdbc.MysqlDataSource;

public class App {

    private static Service service;

    public static Service getService() {
        return service;
    }


    public static void main(String[] args) {


        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setURL("jdbc:mysql://localhost:3306/university");
        dataSource.setServerName("localhost");

        service = new Service();
        service.setDataSource(dataSource);

        java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }
}
