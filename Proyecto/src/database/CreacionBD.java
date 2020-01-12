package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class CreacionBD {
	private final static Logger LOG_creacionBD = Logger.getLogger(CreacionBD.class.getName());
	private final static ConsoleHandler consoleHandlerCreacionBD = new ConsoleHandler();

	public static void main(String[] args) throws ClassNotFoundException {
		LOG_creacionBD.addHandler(consoleHandlerCreacionBD);
		
		// Carga del sqlite-JDBC driver
		Class.forName("org.sqlite.JDBC");
		
		LOG_creacionBD.info("Conectando a la base de datos");
		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:showdown"); Statement statement = connection.createStatement();){
			// Crear la conexión
			
			
			
			statement.setQueryTimeout(30); // poner timeout 30 msg
			LOG_creacionBD.info("Se ha concetado a la base de datos");
			
			statement.executeUpdate("drop table if exists tipos");
			statement.executeUpdate("drop table if exists pokemon");
			statement.executeUpdate("drop table if exists movimientos");
			statement.executeUpdate("drop table if exists entrenador");
			statement
					.executeUpdate("CREATE TABLE TIPOS(" + "NOMBRE_T VARCHAR(20) NOT NULL," + "PRIMARY KEY(NOMBRE_T))");
			statement.executeUpdate("CREATE TABLE MOVIMIENTOS(" + "NOMBRE_M VARCHAR(20) NOT NULL,"
					+ "TIPO VARCHAR(20) NOT NULL," + "DAMAGE INT (4) DEFAULT NULL," + "EFECTO VARCHAR(20) DEFAULT NULL,"
					+ "PRIMARY KEY(NOMBRE_M)," + "FOREIGN KEY(TIPO) REFERENCES TIPOS(NOMBRE_T));");
			LOG_creacionBD.info("Se ha creado la tabla tipos");
			statement.executeUpdate("CREATE TABLE POKEMON(" + "ID_P INT(3) NOT NULL," + "NOMBRE_P VARCHAR(20),"
					+ "TIPO1 VARCHAR(20)," + "TIPO2 VARCHAR(20) DEFAULT NULL," + "ATAQUE INT(6)," + "DEFENSA INT(6),"
					+ "HP INT (6)," + "VELOCIDAD INT (6)," + "MOVIMIENTO1 VARCHAR(20) NOT NULL,"
					+ "MOVIMIENTO2 VARCHAR(20) NOT NULL," + "PRIMARY KEY (ID_P),"
					+ "FOREIGN KEY (MOVIMIENTO1) REFERENCES MOVIMIENTOS(NOMBRE_M),"
					+ "FOREIGN KEY (MOVIMIENTO2) REFERENCES MOVIMIENTOS(NOMBRE_M),"
					+ "FOREIGN KEY (TIPO1) REFERENCES TIPOS(NOMBRE_T),"
					+ "FOREIGN KEY (TIPO2) REFERENCES TIPOS(NOMBRE_T));");
			LOG_creacionBD.info("Se ha creado la tabla pokemon");
			statement.executeUpdate("CREATE TABLE ENTRENADOR(" + "USUARIO VARCHAR(20) NOT NULL,"
					+ "CONTRASEÑA VARCHAR(20) NOT NULL," + "SCORE INT(4) DEFAULT 0," + "POKEMON1 INT(3) NOT NULL,"
					+ "POKEMON2 INT(3) NOT NULL," + "POKEMON3 INT(3) NOT NULL," + "POKEMON4 INT(3) NOT NULL,"
					+ "POKEMON5 INT(3) NOT NULL," + "POKEMON6 INT(3) NOT NULL," + "PRIMARY KEY(USUARIO),"
					+ "FOREIGN KEY (POKEMON1) REFERENCES POKEMON(ID_P),"
					+ "FOREIGN KEY (POKEMON2) REFERENCES POKEMON(ID_P),"
					+ "FOREIGN KEY (POKEMON3) REFERENCES POKEMON(ID_P),"
					+ "FOREIGN KEY (POKEMON4) REFERENCES POKEMON(ID_P),"
					+ "FOREIGN KEY (POKEMON5) REFERENCES POKEMON(ID_P),"
					+ "FOREIGN KEY (POKEMON6) REFERENCES POKEMON(ID_P));");
			LOG_creacionBD.info("Se ha creado la tabla entrenador");
			
			int res = statement.executeUpdate("INSERT INTO TIPOS VALUES('NORMAL')");
			// System.out.println( res ); para asegurarse de que se ejecuta
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('FIRE');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('FIGHTING');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('FLYING');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('WATER');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('GRASS');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('POISON');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('ELECTRIC');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('GROUND');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('PSYCHYC');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('ROCK');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('ICE');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('BUG');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('DRAGON');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('GHOST');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('DARK');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('STEEL');");
			res = statement.executeUpdate("INSERT INTO TIPOS VALUES('FAIRY');");
			ResultSet rs = statement.executeQuery("select * from tipos");
			LOG_creacionBD.info("Se han insertado los tipos en la tabla tipos");
			while (rs.next()) {
				// Leer el resultset
				System.out.println("name = " + rs.getString("nombre_t"));
			}
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('JUDGEMENT', 'NORMAL', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('PSYCHYC', 'PSYCHYC', 90, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('DARK PULSE', 'DARK', 80, NULL);");
			res = statement
					.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('PSYCHOATTACK', 'PSYCHYC', 140, NULL);");
			res = statement
					.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('DISTORSION', 'DRAGON', 150, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('FLASH CANNON', 'STEEL', 80, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('DRAGON PULSE', 'DRAGON', 80, NULL);");
			res = statement
					.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('SHADOW FORCE', 'GHOST', 150, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('LAVA PLUME', 'FIRE', 80, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('EXPLOSION', 'NORMAL', 120, 'BOOM');");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('SACRED FIRE', 'FIRE', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('MIST BALL', 'PSYCHYC', 90, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('LUSTER PURGE', 'PSYCHYC', 90, NULL);");
			res = statement
					.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('DRACO METEOR', 'DRAGON', 140, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('AEROBLAST', 'FLYING', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('HYDRO PUMP', 'WATER', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('SPACIAL REND', 'DRAGON', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('RETURN', 'NORMAL', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('THUNDERBOLT', 'ELECTRIC', 80, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('IRON TAIL', 'STEEL', 100, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('SLUDGE BOMB', 'POISON', 90, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('GIGA DRAIN', 'GRASS', 90, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('FIRE BLAST', 'FIRE', 120, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('SLASH', 'NORMAL', 80, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('BODY SLAM', 'NORMAL', 80, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('ICE BEAM', 'ICE', 90, NULL);");
			res = statement.executeUpdate("INSERT INTO MOVIMIENTOS VALUES('SHADOW BALL', 'GHOST', 90, NULL);");
			rs = statement.executeQuery("select * from MOVIMIENTOS");
			LOG_creacionBD.info("Se han metido los datos de movimiento");
			while (rs.next()) {
				// Leer el resultset
				System.out.println("name = " + rs.getString("nombre_m"));
				System.out.println("tipo = " + rs.getString("tipo"));
				System.out.println("damage = " + rs.getString("damage"));
				System.out.println("effect = " + rs.getString("efecto"));
				System.out.println();
			}
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(0, 'ARCEUS', 'NORMAL', NULL, 100, 100, 500, 100, 'JUDGEMENT', 'FIRE BLAST');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(1, 'CRESSELIA', 'PSYCHYC', NULL, 50, 200, 400, 50, 'PSYCHYC', 'ICE BEAM');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(2, 'DARKRAI', 'DARK', NULL, 200, 50, 350, 200, 'SLUDGE BOMB', 'DARK PULSE');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(3, 'DEOXYS', 'PSYCHYC', NULL, 250, 20, 350, 250, 'PSYCHOATTACK', 'THUNDERBOLT');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(4, 'DIALGA', 'DRAGON', 'STEEL', 100, 150, 450, 50, 'DISTORSION', 'FLASH CANNON');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(5, 'GIRATINA', 'DRAGON', 'GHOST', 80, 120, 500, 70, 'DRAGON PULSE', 'SHADOW FORCE');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(6, 'HEATRAN', 'STEEL', 'FIRE', 150, 150, 450, 60, 'LAVA PLUME', 'EXPLOSION');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(7, 'HO-OH', 'FIRE', 'FLYING', 120, 120, 500, 90, 'SACRED FIRE', 'SLASH');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(8, 'LATIAS', 'DRAGON', 'PSYCHYC', 130, 70, 400, 250, 'MIST BALL', 'DRACO METEOR');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(9, 'LATIOS', 'DRAGON', 'PSYCHYC', 130, 70, 400, 250, 'LUSTER PURGE', 'DRACO METEOR');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(10, 'LUGIA', 'PSYCHYC', 'FLYING', 80, 150, 500, 80, 'AEROBLAST', 'PSYCHYC');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(11, 'MEW', 'PSYCHYC', NULL, 70, 150, 500, 100, 'PSYCHYC', 'SHADOW BALL');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(12, 'PALKIA', 'DRAGON', 'WATER', 130, 100, 500, 65, 'HYDRO PUMP', 'SPACIAL REND');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(13, 'REGIGIGAS', 'NORMAL', NULL, 100, 200, 650, 20, 'EXPLOSION', 'RETURN');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(14, 'PIKACHU', 'ELECTRIC', NULL, 160, 75, 400, 300, 'THUNDERBOLT', 'IRON TAIL');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(15, 'VENUSAUR', 'GRASS', 'POISON', 80, 180, 550, 40, 'GIGA DRAIN', 'SLUDGE BOMB');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(16, 'CHARIZARD', 'FIRE', 'FLYING', 130, 80, 550, 90, 'FIRE BLAST', 'SLASH');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(17, 'BLASTOISE', 'WATER', NULL, 70, 180, 500, 10, 'HYDRO PUMP', 'BODY SLAM');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(18, 'SNORLAX', 'NORMAL', NULL, 100, 140, 1000, 30, 'BODY SLAM', 'SHADOW BALL');");
			res = statement.executeUpdate(
					"INSERT INTO POKEMON VALUES(19, 'LAPRAS', 'WATER', 'ICE', 100, 150, 800, 120, 'ICE BEAM', 'HYDRO PUMP');");
			rs = statement.executeQuery("select * from pokemon");
			LOG_creacionBD.info("Se han insertado todos los pokemons");
			while (rs.next()) {
				// Leer el resultset
				System.out.println("id = " + rs.getInt("id_p"));
				System.out.println("name = " + rs.getString("nombre_p"));
				System.out.println("tipo1 = " + rs.getString("tipo1"));
				System.out.println("tipo2 = " + rs.getString("tipo2"));
				System.out.println("at  = " + rs.getString("ataque"));
				System.out.println("def = " + rs.getString("defensa"));
				System.out.println("hp = " + rs.getString("hp"));
				System.out.println("vel = " + rs.getString("velocidad"));
				System.out.println("at1 = " + rs.getString("movimiento1"));
				System.out.println("at2 = " + rs.getString("movimiento2"));
				System.out.println();
			}
			res = statement.executeUpdate(
                    "INSERT INTO ENTRENADOR VALUES('RED', 'C', 999, 14, 15, 16, 17, 18, 19);");
			LOG_creacionBD.info("Se han metido los datos de red");
			rs = statement.executeQuery("select * from entrenador");
			while(rs.next()) {
			System.out.println("usuario = " + rs.getString("usuario"));
			System.out.println("cont = " + rs.getString("contraseña"));
			System.out.println("score = " + rs.getInt("score"));
			System.out.println("pok1 = " + rs.getInt("pokemon1"));
			System.out.println("pok2 = " + rs.getInt("pokemon2"));
			System.out.println("pok3 = " + rs.getInt("pokemon3"));
			System.out.println("pok4 = " + rs.getInt("pokemon4"));
			System.out.println("pok5 = " + rs.getInt("pokemon5"));
			System.out.println("pok6 = " + rs.getInt("pokemon6"));
			System.out.println();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			LOG_creacionBD.info(e.getMessage());
		} 
	}

}