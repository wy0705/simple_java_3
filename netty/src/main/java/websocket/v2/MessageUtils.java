package websocket.v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageUtils {
    /*private static DBDao dbDao=new DBDao();
    private static Connection connection=dbDao.start();*/
    public int addMessage(Message message) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tst_websocket", "root", "root");

        boolean result=false;
        if (message==null){
            return 0;
        }
        String sql = "insert into tb_message(mid,content,timestamp) values(?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,message.getId());
        ps.setString(2,message.getContent());
        ps.setLong(3,message.getTimestamp());
        int i=ps.executeUpdate();
        ps.close();
        conn.close();
        return i;
    }

}
