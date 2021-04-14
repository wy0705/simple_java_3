package com.ease.archiecture.springjdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<TestStudent> {
    public TestStudent mapRow(ResultSet resultSet, int i) throws SQLException {
        TestStudent student = new TestStudent();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
