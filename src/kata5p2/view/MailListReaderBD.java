package kata5p2.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderBD {
    
    private Connection connect() {
        // Cadena de conexión SQLite
        String url = "jdbc:sqlite:mail.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @SuppressWarnings("empty-statement")
    public List<String> read() throws FileNotFoundException, IOException {
        String sql = "SELECT * FROM direcc_email";
        List<String> list = new ArrayList<>();;
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                Mail m = new Mail(rs.getString("direccion"));
                if (!m.getDomain().equals("")){
                    list.add(m.getDomain());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
