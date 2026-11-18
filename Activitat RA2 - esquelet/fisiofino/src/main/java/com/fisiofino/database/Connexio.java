package com.fisiofino.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/****AQUESTA CLASSE DEFINEIX LA CONNEXIÓ I EL DATASOURCE */
public class Connexio {

    /************** S'HA D'IMPLEMENTAR TOT INCLOSES LES FUNCIONS
                  DEFINIDES A SOTA        ********************/

    private static final Path FITXER_CONFIG =
            Path.of("src", "main", "resources", "conn.properties");
    private static HikariDataSource pool;

    public static void iniciaConnexio () throws IOException {
        Properties propietats = new Properties();
        try (BufferedReader lector = Files.newBufferedReader(FITXER_CONFIG)) {
            propietats.load(lector);
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(propietats.getProperty("DB_URL"));
        config.setUsername(propietats.getProperty("DB_USER"));
        config.setPassword(propietats.getProperty("DB_PASSWORD"));
        config.setMaximumPoolSize(
                Integer.parseInt(propietats.getProperty("DB_MAX_POOL", "5")));

        pool = new HikariDataSource(config);
    }

    public static Connection obtenirConnexio() throws SQLException {
        if (pool == null) {
            throw new IllegalStateException("Cal iniciar la connexió abans d'obtenir-ne una");
        }
        return pool.getConnection();
    }


    public static void tancaConnexio () {
        if (pool != null) {
            pool.close();
            pool = null;
        }
    }

}
