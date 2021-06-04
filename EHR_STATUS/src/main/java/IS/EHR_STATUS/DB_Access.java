package IS.EHR_STATUS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Access {




    public String get_EHR_Id_Status(String id){

        String x = "";
        try {



            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password="
                            + "root" + "&useTimezone=true&serverTimezone=UTC");

            Statement select = conn.createStatement();
            String sql = "SELECT ehr_status, id_version, is_queryable, is_modifiable, ehr_subject, ehr_version_at_time FROM ehr_status WHERE ehr_id =  " + id+ " ;";

            ResultSet rs = select.executeQuery(sql);

            while (rs.next()) {
                x = rs.getString(1);
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }

        return x;
    }




}
