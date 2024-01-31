import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class Service {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void save(Entity entity) {
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setLong(1, entity.getId());
                preparedStatement.setString(2, entity.getFirstName());
                preparedStatement.setString(3, entity.getLastName());
                preparedStatement.setString(4, entity.getDepartment());
                preparedStatement.executeUpdate();


            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
        }
    }

    public List<Entity> findAll(int page, int pageSize) {
        List<Entity> entityList = new ArrayList<>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }

    public List<Entity> find(long id) {
        List<Entity> entityList = new ArrayList<Entity>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students where Student_ID=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }
    public boolean Exists(long id) {
        List<Entity> entityList = new ArrayList<>();
        int found=0;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students where Student_ID=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
                found++;
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
        }

        return found > 0;
    }

    public int count() {
        int selected = 0;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("SELECT count(Student_ID) from students");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                selected = rs.getInt("count(Student_ID)");
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }

            return selected;
        }
    }

    public int countOne(long id) {
        int selected = 0;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("SELECT count(Student_ID) from students where Student_ID=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                selected = rs.getInt("count(Student_ID)");
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }

            return selected;
        }
    }

    public List<Entity> OrderByID(int page, int pageSize) {
        List<Entity> entityList = new ArrayList<>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students order by Student_ID limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }

    public List<Entity> OrderByName(int page, int pageSize) {
        List<Entity> entityList = new ArrayList<>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students order by First_Name limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }

    public List<Entity> OrderByLastName(int page, int pageSize) {
        List<Entity> entityList = new ArrayList<Entity>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students order by Last_Name limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }

    public List<Entity> OrderByDepartment(int page, int pageSize) {
        List<Entity> entityList = new ArrayList<>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("SELECT * FROM students order by Department limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Entity p = new Entity();
                p.setId(rs.getLong("Student_ID"));
                p.setFirstName(rs.getString("First_Name"));
                p.setLastName(rs.getString("Last_Name"));
                p.setDepartment(rs.getString("Department"));
                entityList.add(p);
            }

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }

    public List<Entity> remove(long id) {
        List<Entity> entityList = new ArrayList<>();

        if (count() == 0) {
            return entityList;
        }
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("DELETE FROM students where Student_ID=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException exRollBack) {
                exRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException exClose) {
                exClose.printStackTrace();
            }
            return entityList;
        }
    }
}
