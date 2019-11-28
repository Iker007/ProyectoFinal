package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;
import clases.Tipo;

public class GestorBD {
	public List<Entrenador> usuarios;
	private Connection connection = null;

	public GestorBD() {

	}
	public void conectar() throws BDException {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:datos/pokemon.bd");
		} catch (ClassNotFoundException e) {
			throw new BDException("No se pudo cargar el driver", e);
		} catch (SQLException e) {
			throw new BDException("No se ha podido conectar a la BD", e);
		}

	}
	public void desconectar() throws BDException{
		try {
			if(connection != null) {
				connection.close();
			}
		}catch (SQLException e) {
			throw new BDException("No se ha podido cerrar la conexion a la BD", e);
		}
	
		
	}
	public void crearTablePokemon() throws BDException{
		try(Statement stmt = connection.createStatement();){
			String sql = "CREATE TABLE pokemon (id INTERGER PRIMARY KEY, "
					+ "nombre VARCHAR, "
					+ "tipo1 VARCHAR, "
					+ "tipo2 VARCHAR, "
					+ "hp INTEGER, "
					+ "attack INTEGER, "
					+ "defense INTEGER, "
					+ "movimiento1 VARCHAR, "
					+ "movimiento2 VARCHAR )";
		}catch (SQLException e) {
			throw new BDException("No se pudo crear la tabla 'pokemon'",e);
		}
	}
	public List<Pokemon> obtenerTodosPokemon() throws BDException{
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		try(Statement stmt = connection.createStatement();){
			ResultSet result = stmt.executeQuery("SELECT id, "
					+ "nombre, "
					+ "tipo1, "
					+ "tipo2, "
					+ "hp, "
					+ "attack, "
					+ "defense, "
					+ "movimiento1, "
					+ "movimiento2 FROM pokemon");
			while(result.next()) {
				Pokemon p = new Pokemon();
				Tipo[] tipos = new Tipo[2];
				tipos[0].setNombre(result.getString("tipo1"));
				tipos[1].setNombre(result.getString("tipo2"));
				List<Movimiento> movimientos = new ArrayList<Movimiento>();
				//movimientos.add(Movimiento m = new )
				//p.set
				p.setNombre(result.getString("nombre"));
				p.setTipo(tipos);
				p.setHp(result.getInt("hp"));
				p.setAtak(result.getInt("attack"));
				p.setDefense(result.getInt("defense"));
				p.setMovimientos(movimientos);
				pokemons.add(p);
			}
			return pokemons;
		}catch(SQLException e) {
			throw new BDException("No se pudo obtener el pokemons", e);
		}
	}
	public void crearTableEntrenador() throws BDException{
		
		try(Statement stmt = connection.createStatement()){
			String sql = "CREATE TABLE entrenador (usuario VARCHAR, contrasena VARCHAR)";
			stmt.executeUpdate(sql);
		}catch (SQLException e) {
			// TODO: handle exception
			throw new BDException("No se pudo crear la tabla 'entrenador'", e);
		}
		
	}
	public List<Entrenador> obtenerTodosUsuario() throws BDException{
		List<Entrenador> usuarios = new ArrayList<Entrenador>();
		try(Statement stmt = connection.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT USUARIO, CONTRASEÑA, SCORE, POKEMON1, POKEMON2, POKEMON3, POKEMON4, POKEMON5, POKEMON6 FROM ENTRENADOR");
			while(rs.next()) {
				Entrenador e = new Entrenador();
				
				e.setName(rs.getString("NAME"));
				e.setUsuario(rs.getString("USUARIO"));
				e.setContraseña(rs.getString("CONTRASENA"));
				
				usuarios.add(e);
			}
			
		}catch (SQLException e) {
			throw new BDException("No se pudo obtener la lista de la tabla 'usuario'", e);	
		}
		this.usuarios = usuarios;
		return usuarios;
	}
	public boolean comprobarEntrenadorExiste(Entrenador e){
		for(Entrenador e : usuarios) {
			
		}
		return true;
	}
	public void insertarEntrenador(Entrenador e) {
		try(Statement stmt = connection.createStatement()){
			int res = stmt.executeUpdate("INSERT INTO ENTRENADOR VALUES("+ e.getName() + "," + e.getContraseña() + ")" );
		
				
	
			}
			
		}catch (SQLException e) {
			throw new BDException("No se pudo obtener la lista de la tabla 'usuario'", e);	
		}
		
	
	
}