
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn = null;
    
    public  Connection Conectar(){
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11","root","cardy293230");
            System.out.println("BD conectado com sucesso");
            return conn;
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Falha na conexão com o BD ");
            return null;
        } 
        
    }
    public boolean Desconectar(){
        try{
        conn.close();
            System.out.println("BD desconectado com sucesso");
            return true;
        }
        catch(SQLException ex){
            System.out.println("ouve um erro ao desconectar");
            return false;
        }
    }
}