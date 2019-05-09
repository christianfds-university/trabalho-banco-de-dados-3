package trabalho;
import java.sql.*; 

public class Driver {	
	private String dbURL = "jdbc:mysql://localhost:3306/?";
	private String usuario = "root";
	private String senha = "franchin";
	
	/*
	 * Define qual usuario fara acesso ao servidor
	 * Por padrão o usuário root é selecionado
	 */
	public void setUserRoot() {
		usuario = "root";
		senha = "franchin";
	}

	public void setUser1() {
		usuario = "Usuario1";
		senha = "UserSenha@1";
	}

	public void setUser2() {
		usuario = "Usuario2";
		senha = "UserSenha@2";
	}

	public void setUser3() {
		usuario = "Usuario3";
		senha = "UserSenha@3";
	}

	/*
	 * Realiza a conexão e fechamento da conexão com o servidor
	 */
	private Connection startConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection myConn = DriverManager.getConnection(dbURL,usuario,senha);
		return myConn;
	}

	private void closeConnection(Connection myConn) throws Exception {
		myConn.close();
	}
		
	/*
	 * Iterações com a tabela pais
	 */
	public void listarPais() {
		try{
			Connection myConn = startConnection(); 
						
			String sql = "SELECT * FROM trabalho.pais";
			
			Statement statement = myConn.createStatement();
			ResultSet result = statement.executeQuery(sql); 
			
			while (result.next()){
				Integer id = result.getInt(1);
			    String nome = result.getString(2);
			    Integer cod = result.getInt(3);
			 
			    String output = "Pais:\n"
			    		+ "\tId: [%d]\n"
			    		+ "\tNome: [%s]\n"
			    		+ "\tCod: [%d]\n";
			    System.out.println(String.format(output,id,nome,cod));
			}
			
			closeConnection(myConn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserirPais(String Nome, Integer ddi) {
		try{
			Connection myConn = startConnection(); 
						
			String sql = "INSERT INTO trabalho.pais (nome,cod) VALUES (?,?)";
			
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setString(1, Nome);
			statement.setInt(2, ddi);
			 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Pais inserido com sucesso!");
			}

			closeConnection(myConn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarPais(int idPais) {
		try{
			Connection myConn = startConnection(); 

			String sql = "DELETE FROM trabalho.pais WHERE id=?";
			 
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setInt(1, idPais);
			 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Pais deletado com sucesso!\n");
			}
			
			closeConnection(myConn);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void atualizarPais(Integer idPais, String nome, Integer ddi) {
		try{
			Connection myConn = startConnection(); 

			String sql = "UPDATE trabalho.pais SET nome=?, cod=? WHERE id=?";
			 
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setInt(2, ddi);
			statement.setInt(3,idPais);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("Pais atualizado com sucesso!\n");
			}

			closeConnection(myConn);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/*
	 * Iterações com a tabela envio
	 */
	public void listarEnvio() {
		try{
			Connection myConn = startConnection(); 
						
			String sql = "SELECT * FROM trabalho.envio";
			
			Statement statement = myConn.createStatement();
			ResultSet result = statement.executeQuery(sql); 
			
			while (result.next()){
				Integer id = result.getInt(1);
			    String nome = result.getString(2);
			 
			    String output = "Envio:\n"
			    		+ "\tId: [%d]\n"
			    		+ "\tNome: [%s]\n";
			    System.out.println(String.format(output,id,nome));
			}
			
			closeConnection(myConn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserirEnvio(String Nome) {
		try{
			Connection myConn = startConnection(); 
						
			String sql = "INSERT INTO trabalho.envio (nome) VALUES (?)";
			
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setString(1, Nome);
						 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("Envio inserido com sucesso!");
			}

			closeConnection(myConn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarEnvio(int idEnvio) {
		try{
			Connection myConn = startConnection(); 

			String sql = "DELETE FROM trabalho.envio WHERE id=?";
			 
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setInt(1, idEnvio);
			 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("Envio deletado com sucesso!\n");
			}
			
			closeConnection(myConn);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void atualizarEnvio(Integer idEnvio, String nome) {
		try{
			Connection myConn = startConnection(); 

			String sql = "UPDATE trabalho.envio SET nome=? WHERE id=?";
			 
			PreparedStatement statement = myConn.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setInt(2,idEnvio);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("Envio atualizado com sucesso!\n");
			}

			closeConnection(myConn);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}