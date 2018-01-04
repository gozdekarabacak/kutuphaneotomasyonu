package DBSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    private final String url = "org.sqlite.JDBC";
    private final String db = "jdbc:sqlite:db/kutuphanem.db";

    Connection conn = null;
    Statement st = null;

    public Statement baglan() {
        try {
            Class.forName(url);
            conn = DriverManager.getConnection(db);

            st = conn.createStatement();
            System.out.println("Bağlantı başarılı");
        } catch (Exception e) {
            System.err.println("Bağlantı hatalı : " + e);
        }

        return st;

    }

    public void kapat() {
        try {
            if (conn != null || !conn.isClosed()) {
                st.close();
                conn.close();
                System.out.println("DB Kapatıldı");

            }
        } catch (SQLException e) {
            System.err.println(" Kapatma hatası : " + e);
        }

    }

}
