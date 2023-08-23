import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import connection.ConnectionFactory;
import domain.dao.UsuarioDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conn = connectionFactory.recuperarConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        usuarioDAO.buscarTodos().forEach(System.out::println);
        System.out.println("Fechando Conexão!");
        LocalDate  date = LocalDate.now() ;
        System.out.println(date);
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
