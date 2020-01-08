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

	private static Connection connection = null;

	public GestorBD() throws BDException {

	}

	public void conectar() throws BDException {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:showdown");
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


	public boolean comprobarEntrenadorExiste(Entrenador e, List<Entrenador> usuarios) {
		for (Entrenador e2 : usuarios) {

		}
		return true;
	}

	public void insertarEntrenador(Entrenador e) throws BDException, ClassNotFoundException {
		
		try (Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("INSERT INTO ENTRENADOR VALUES('" + e.getUsuario() + "', " + "'"
					+ e.getContraseña() + "', " + e.getScore() + ", " + e.getPokemons().get(0).getId() + ","
					+ e.getPokemons().get(1).getId() + "," + e.getPokemons().get(2).getId() + ","
					+ e.getPokemons().get(3).getId() + "," + e.getPokemons().get(4).getId() + ","
					+ e.getPokemons().get(5).getId() + ");");
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

	public static List<Movimiento> obtenerTodosMovimientos(List<Tipo> tipos) throws BDException {
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

	public static List<Pokemon> obtenerTodosPokemon(List<Movimiento> movimientos) throws BDException {
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT ID_P, NOMBRE_P, TIPO1, TIPO2, ATAQUE, DEFENSA, HP, VELOCIDAD, MOVIMIENTO1, MOVIMIENTO2 FROM POKEMON");
			while (rs.next()) {
				Pokemon p = new Pokemon();

				p.setId(rs.getInt("ID_P"));
				p.setNombre(rs.getString("NOMBRE_P"));
				Tipo tipo1 = new Tipo(rs.getString("TIPO1"));
				p.setTipo1(tipo1);
				Tipo tipo2 = new Tipo(rs.getString("TIPO2"));
				p.setTipo2(tipo2);
				p.setAttack(rs.getInt("ATAQUE"));
				p.setDefense(rs.getInt("DEFENSA"));
				p.setHp(rs.getInt("HP"));
				p.setSpeed(rs.getInt("VELOCIDAD"));
				Movimiento movimiento1 = new Movimiento();
				for (Movimiento m : movimientos) {
					if (m.getNombre().equals(rs.getString("MOVIMIENTO1"))) {
						movimiento1.setNombre(m.getNombre());
						movimiento1.setDaño(m.getDaño());
						movimiento1.setEfecto(m.getEfecto());
						movimiento1.setTipo(m.getTipo());
					}
					p.setMovimiento1(movimiento1);
				}
				Movimiento movimiento2 = new Movimiento();
				for (Movimiento m : movimientos) {
					if (m.getNombre().equals(rs.getString("MOVIMIENTO2"))) {
						movimiento2.setNombre(m.getNombre());
						movimiento2.setDaño(m.getDaño());
						movimiento2.setEfecto(m.getEfecto());
						movimiento2.setTipo(m.getTipo());
					}
					p.setMovimiento2(movimiento2);
				}
				pokemon.add(p);
			}
			return pokemon;
		} catch (SQLException e1) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Pokemon'", e1);
		}
	}

	public List<Entrenador> obtenerTodosUsuarios(List<Pokemon> pokemon) throws BDException {
		List<Entrenador> usuarios = new ArrayList<Entrenador>();
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT USUARIO, CONTRASEÑA, SCORE, POKEMON1, POKEMON2, POKEMON3, POKEMON4, POKEMON5, POKEMON6 FROM ENTRENADOR");

			while (rs.next()) {
				Entrenador e = new Entrenador();

				e.setUsuario(rs.getString("USUARIO"));
				e.setContraseña(rs.getString("CONTRASEÑA"));
				e.setScore(rs.getInt("SCORE"));
				List<Pokemon> equipo = new ArrayList<Pokemon>();
				Pokemon pokemon1 = new Pokemon();
				for (Pokemon p : pokemon) {
					if (p.getId() == (rs.getInt("POKEMON1"))) {
						pokemon1.setId(p.getId());
						pokemon1.setNombre(p.getNombre());
						pokemon1.setTipo1(p.getTipo1());
						pokemon1.setTipo2(p.getTipo2());
						pokemon1.setAttack(p.getAttack());
						pokemon1.setDefense(p.getDefense());
						pokemon1.setHp(p.getHp());
						pokemon1.setSpeed(p.getSpeed());
						pokemon1.setMovimiento1(p.getMovimiento1());
						pokemon1.setMovimiento2(p.getMovimiento2());
						equipo.add(pokemon1);
					}

				}
				Pokemon pokemon2 = new Pokemon();
				for (Pokemon p : pokemon) {
					if (p.getId() == (rs.getInt("POKEMON2"))) {
						pokemon2.setId(p.getId());
						pokemon2.setNombre(p.getNombre());
						pokemon2.setTipo1(p.getTipo1());
						pokemon2.setTipo2(p.getTipo2());
						pokemon2.setAttack(p.getAttack());
						pokemon2.setDefense(p.getDefense());
						pokemon2.setHp(p.getHp());
						pokemon2.setSpeed(p.getSpeed());
						pokemon2.setMovimiento1(p.getMovimiento1());
						pokemon2.setMovimiento2(p.getMovimiento2());
						equipo.add(pokemon2);

					}
				}
				Pokemon pokemon3 = new Pokemon();
				for (Pokemon p : pokemon) {
					if (p.getId() == (rs.getInt("POKEMON3"))) {
						pokemon3.setId(p.getId());
						pokemon3.setNombre(p.getNombre());
						pokemon3.setTipo1(p.getTipo1());
						pokemon3.setTipo2(p.getTipo2());
						pokemon3.setAttack(p.getAttack());
						pokemon3.setDefense(p.getDefense());
						pokemon3.setHp(p.getHp());
						pokemon3.setSpeed(p.getSpeed());
						pokemon3.setMovimiento1(p.getMovimiento1());
						pokemon3.setMovimiento2(p.getMovimiento2());
						equipo.add(pokemon3);

					}
				}
				Pokemon pokemon4 = new Pokemon();
				for (Pokemon p : pokemon) {
					if (p.getId() == (rs.getInt("POKEMON4"))) {
						pokemon4.setId(p.getId());
						pokemon4.setNombre(p.getNombre());
						pokemon4.setTipo1(p.getTipo1());
						pokemon4.setTipo2(p.getTipo2());
						pokemon4.setAttack(p.getAttack());
						pokemon4.setDefense(p.getDefense());
						pokemon4.setHp(p.getHp());
						pokemon4.setSpeed(p.getSpeed());
						pokemon4.setMovimiento1(p.getMovimiento1());
						pokemon4.setMovimiento2(p.getMovimiento2());
						equipo.add(pokemon4);

					}
				}
				Pokemon pokemon5 = new Pokemon();
				for (Pokemon p : pokemon) {
					if (p.getId() == (rs.getInt("POKEMON5"))) {
						pokemon5.setId(p.getId());
						pokemon5.setNombre(p.getNombre());
						pokemon5.setTipo1(p.getTipo1());
						pokemon5.setTipo2(p.getTipo2());
						pokemon5.setAttack(p.getAttack());
						pokemon5.setDefense(p.getDefense());
						pokemon5.setHp(p.getHp());
						pokemon5.setSpeed(p.getSpeed());
						pokemon5.setMovimiento1(p.getMovimiento1());
						pokemon5.setMovimiento2(p.getMovimiento2());
						equipo.add(pokemon5);

					}
				}
				Pokemon pokemon6 = new Pokemon();
				for (Pokemon p : pokemon) {
					if (p.getId() == (rs.getInt("POKEMON6"))) {
						pokemon6.setId(p.getId());
						pokemon6.setNombre(p.getNombre());
						pokemon6.setTipo1(p.getTipo1());
						pokemon6.setTipo2(p.getTipo2());
						pokemon6.setAttack(p.getAttack());
						pokemon6.setDefense(p.getDefense());
						pokemon6.setHp(p.getHp());
						pokemon6.setSpeed(p.getSpeed());
						pokemon6.setMovimiento1(p.getMovimiento1());
						pokemon6.setMovimiento2(p.getMovimiento2());
						equipo.add(pokemon6);

					}
				}
				e.setPokemons(equipo);

				usuarios.add(e);
			}

		} catch (SQLException e) {
			throw new BDException("No se pudo obtener la lista de la tabla 'Entrenador'", e);
		}

		return usuarios;
	}

}