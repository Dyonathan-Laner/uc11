/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public static boolean insert(ProdutosDTO P) {

        Conexao C = new Conexao();
        try {

            PreparedStatement PS = C.Conectar().prepareStatement("insert into produtos(nome,valor,status)values(?,?,?)");
            PS.setString(1, P.getNome());
            PS.setInt(2, P.getValor());
            PS.setString(3, P.getStatus());
            
            PS.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println("não foi possivel cadastrar");
            return false;
        } finally {
            C.Desconectar();
        }

    }
    public static List<ProdutosDTO> Select (){
        Conexao C = new Conexao();
        try{
            PreparedStatement ST = C.Conectar().prepareStatement("SELECT * FROM produtos");
            ResultSet rs = ST.executeQuery();
            
            List<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();
        
            while(rs.next()){
            ProdutosDTO P = new ProdutosDTO();
                P.setId(rs.getInt("id"));
                P.setNome(rs.getString("nome"));
                P.setStatus(rs.getString("status"));
                P.setValor(rs.getInt("valor"));
                
                lista.add(P);
            }
            return lista;
        }catch(Exception e){
            System.out.println("Erro ao montar tabela");
            return null;
        }finally{C.Desconectar();}
    }
    public static boolean VenderProduto(int id){
        Conexao C = new Conexao();
        try{
            PreparedStatement st = C.Conectar().prepareStatement("Update produtos set status='Vendido' where id = ?");
            st.setInt(1, id);
            
            st.executeUpdate();
        return true;
        }catch(Exception e){
            System.out.println("Erro ao vender Produto");
            return false;
        }finally{C.Desconectar();}
        
    }
    public static List<ProdutosDTO> PVendidos (){
        Conexao C = new Conexao();
        try{
            PreparedStatement ST = C.Conectar().prepareStatement("SELECT * FROM produtos where status = 'Vendido'");
            ResultSet rs = ST.executeQuery();
            
            List<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();
        
            while(rs.next()){
            ProdutosDTO P = new ProdutosDTO();
                P.setId(rs.getInt("id"));
                P.setNome(rs.getString("nome"));
                P.setStatus(rs.getString("status"));
                P.setValor(rs.getInt("valor"));
                
                lista.add(P);
            }
            return lista;
        }catch(Exception e){
            System.out.println("Erro ao montar tabela");
            return null;
        }finally{C.Desconectar();}
    }


}
