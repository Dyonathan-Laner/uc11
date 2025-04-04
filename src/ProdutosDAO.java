/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ProdutosDAO {

    public boolean insert(ProdutosDTO P) {

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

    public ArrayList<ProdutosDTO> listarProdutos() {

        
    }

}
