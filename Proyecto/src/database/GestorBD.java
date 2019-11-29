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

	public void desconectar() throws BDException {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new BDException("No se ha podido cerrar la conexion a la BD", e);
		}

	}

	public void crearTablePokemon() throws BDException {
		try (Statement stmt = connection.createStatement();) {
			String sql = "CREATE TABLE pokemon (id INTERGER PRIMARY KEY, " + "nombre VARCHAR, " + "tipo1 VARCHAR, "
					+ "tipo2 VARCHAR, " + "hp INTEGER, " + "attack INTEGER, " + "defense INTEGER, "
					+ "movimiento1 VARCHAR, " + "movimiento2 VARCHAR )";
		} catch (SQLException e) {
			throw new BDException("No se pudo crear la tabla 'pokemon'", e);
		}
	}

	public List<Pokemon> obtenerTodosPokemon2() throws BDException {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		try (Statement stmt = connection.createStatement();) {
			ResultSet result = stmt.executeQuery("SELECT id, " + "nombre, " + "tipo1, " + "tipo2, " + "hp, "
					+ "attack, " + "defense, " + "movimiento1, " + "movimiento2 FROM pokemon");
			while (result.next()) {
				Pokemon p = new Pokemon();
				Tipo[] tipos = new Tipo[2];
				tipos[0].setNombre(result.getString("tipo1"));
				tipos[1].setNombre(result.getString("tipo2"));
				List<Movimiento> movimientos = new ArrayList<Movimiento>();
				// movimientos.add(Movimiento m = new )
				// p.set
				p.setNombre(result.getString("nombre"));
				// p.setTipo(tipos);
				p.setHp(result.getInt("hp"));
				p.setAtak(result.getInt("attack"));
				p.setDefense(result.getInt("defense"));
				// p.setMovimientos(movimientos);
				pokemons.add(p);
			}
			return pokemons;
		} catch (SQLException e) {
			throw new BDException("No se pudo obtener el pokemons", e);
		}
	}

	public void crearTableEntrenador() throws BDException {

		try (Statement stmt = connection.createStatement()) {
			String sql = "CREATE TABLE entrenador (usuario VARCHAR, contrasena VARCHAR)";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new BDException("No se pudo crear la tabla 'entrenador'", e);
		}

	}

	public List<Entrenador> obtenerTodosUsuario() throws BDException {
		List<Entrenador> usuarios = new ArrayList<Entrenador>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT USUARIO, CONTRASEÑA, SCORE, POKEMON1, POKEMON2, POKEMON3, POKEMON4, POKEMON5, POKEMON6 FROM ENTRENADOR");
			while (rs.next()) {
				Entrenador e = new Entrenador();

				e.setName(rs.getString("NAME"));
				e.setUsuario(rs.getString("USUARIO"));
				e.setContraseña(rs.getString("CONTRASENA"));

				usuarios.add(e);
			}

		} catch (SQLException e) {
			throw new BDException("No se pudo obtener la lista de la tabla 'usuario'", e);
		}
		this.usuarios = usuarios;
		return usuarios;
	}

	public boolean comprobarEntrenadorExiste(Entrenador e) {
		for (Entrenador e2 : usuarios) {

		}
		return true;
	}

	public void insertarEntrenador(Entrenador e) throws BDException {
		try (Statement stmt = connection.createStatement()) {
			int res = stmt
					.executeUpdate("INSERT INTO ENTRENADOR VALUES(" + e.getName() + "," + e.getContraseña() + ")");
		}

		catch (SQLException e1) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Entrenador'", e1);
		}
	}

	public List<Tipo> obtenerTodosTipos() throws BDException {
		List<Tipo> tipos = new ArrayList<Tipo>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT NOMBRE_T FROM TIPOS");
			while (rs.next()) {
				Tipo t = new Tipo();

				t.setNombre(rs.getString("NOMBRE_T"));
				tipos.add(t);
			}
			return tipos;
		} catch (SQLException e1) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Tipos'", e1);
		}
	}

	public List<Movimiento> obtenerTodosMovimientos() throws BDException {
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT NOMBRE_M, TIPO, DAMAGE, EFECTO FROM MOVIMIENTOS");
			while (rs.next()) {
				Movimiento m = new Movimiento();

				m.setNombre(rs.getString("NOMBRE_M"));
				Tipo tipo = new Tipo(rs.getString("TIPO"));
				m.setTipo(tipo);
				m.setDaño(rs.getInt("DAMAGE"));
				m.setEfecto(rs.getString("EFECTO"));
				movimientos.add(m);
			}
			return movimientos;
		} catch (SQLException e1) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Movimientos'", e1);
		}
	}

	public List<Pokemon> obtenerTodosPokemon(List<Movimiento> movimientos) throws BDException {
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT ID_P, NOMBRE_P, SCORE, TIPO1, TIPO2, ATAQUE, DEFENSA, HP, VELOCIDAD, MOVIMIENTO1, MOVIMIENTO2 FROM POKEMON");
			while (rs.next()) {
				Pokemon p = new Pokemon();

				p.setUid(rs.getInt("ID_P"));
				p.setNombre(rs.getString("NOMBRE_P"));
				Tipo tipo1 = new Tipo(rs.getString("TIPO1"));
				p.setTipo1(tipo1);
				Tipo tipo2 = new Tipo(rs.getString("TIPO2"));
				p.setTipo2(tipo2);
				p.setAtak(rs.getInt("ATAQUE"));
				p.setDefense(rs.getInt("DEFENSA"));
				p.setHp(rs.getInt("HP"));
				p.setSpeed(rs.getInt("VELOCIDAD"));
				Movimiento movimiento1 = new Movimiento();
				for(Movimiento m : movimientos) {
					if(m.getNombre().equals(rs.getString("MOVIMIENTO1"))){
						movimiento1.setNombre(m.getNombre());
						movimiento1.setDaño(m.getDaño());
						movimiento1.setEfecto(m.getEfecto());
						movimiento1.setTipo(m.getTipo());
					}
					p.setMovimiento1(movimiento1);
				}
				Movimiento movimiento2 = new Movimiento();
				for(Movimiento m : movimientos) {
					if(m.getNombre().equals(rs.getString("MOVIMIENTO2"))){
						movimiento2.setNombre(m.getNombre());
						movimiento2.setDaño(m.getDaño());
						movimiento2.setEfecto(m.getEfecto());
						movimiento2.setTipo(m.getTipo());
					}
					p.setMovimiento1(movimiento2);
				}
				pokemon.add(p);
			}
			return pokemon;
		} catch (SQLException e1) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Pokemon'", e1);
		}
	}

	public List<Entrenador> obtenerTodosUsuario2(List<Pokemon> pokemon) throws BDException {
		List<Entrenador> usuarios = new ArrayList<Entrenador>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT USUARIO, CONTRASEÑA, SCORE, POKEMON1, POKEMON2, POKEMON3, POKEMON4, POKEMON5, POKEMON6 FROM ENTRENADOR");
			while (rs.next()) {
				Entrenador e = new Entrenador();

				e.setName(rs.getString("NAME"));
				e.setUsuario(rs.getString("USUARIO"));
				e.setContraseña(rs.getString("CONTRASENA"));
				Pokemon pokemon1 = new Pokemon();
				for(Pokemon p : pokemon) {
					if(p.getNombre().equals(rs.getString("MOVIMIENTO2"))){
						pokemon1.setNombre(p.getNombre());
						pokemon1.setDaño(m.getDaño());
						pokemon1.setEfecto(m.getEfecto());
						pokemon1.setTipo(m.getTipo());
					}
					p.setMovimiento1(movimiento2);
				}
				e.setPokemon1(rs.getString("POKEMON1"));
				e.setPokemon2(rs.getString("POKEMON2"));
				e.setPokemon3(rs.getString("POKEMON3"));
				e.setPokemon4(rs.getString("POKEMON4"));
				e.setPokemon5(rs.getString("POKEMON5"));
				e.setPokemon6(rs.getString("POKEMON6"));
				usuarios.add(e);
			}

		} catch (SQLException e) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Entrenador'", e);
		}
		this.usuarios = usuarios;
		return usuarios;
	}

}