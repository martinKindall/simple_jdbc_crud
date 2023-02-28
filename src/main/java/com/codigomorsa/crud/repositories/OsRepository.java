package com.codigomorsa.crud.repositories;

import com.codigomorsa.crud.model.Os;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OsRepository {

    private final RowMapper<Os> mapper = new OsRowMapper();
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertIntoOs;

    public OsRepository(NamedParameterJdbcTemplate crudNamedParameterJdbcTemplate, DataSource crudDataSource) {
        jdbcTemplate = crudNamedParameterJdbcTemplate;
        insertIntoOs = new SimpleJdbcInsert(crudDataSource).withTableName("os").usingGeneratedKeyColumns("id");
    }

    public List<Os> getAllOs() {
        String sql = "select * from os";
        return jdbcTemplate.query(sql, mapper);
    }

    public long createOs(Os newOs) {
        return insertIntoOs.executeAndReturnKey(new MapSqlParameterSource("name", newOs.name)).longValue();
    }

    private static class OsRowMapper implements RowMapper<Os> {

        @Override
        public Os mapRow(ResultSet rs, int rowNum) throws SQLException {
            var os = new Os();
            long id = rs.getLong("id");
            String name = rs.getString("name");

            os.id = id;
            os.name = name;

            return os;
        }
    }
}
