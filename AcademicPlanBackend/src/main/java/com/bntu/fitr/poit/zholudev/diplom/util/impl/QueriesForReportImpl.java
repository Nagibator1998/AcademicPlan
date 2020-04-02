package com.bntu.fitr.poit.zholudev.diplom.util.impl;

import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import com.bntu.fitr.poit.zholudev.diplom.entity.University;
import com.bntu.fitr.poit.zholudev.diplom.util.QueriesForReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class QueriesForReportImpl implements QueriesForReport {

    private static final String GET_UNIVERSITY_BY_EXPLANATORY_NOTE_QUERY =
            "select un.* from universities un, faculties fac, departments dep, specialities spec where " +
            "spec.id = ? " +
            "and spec.department_id = dep.id " +
            "and dep.faculty_id = fac.id " +
            "and fac.university_id = un.id";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public University getUniversityByExplanatoryNote(ExplanatoryNote explanatoryNote){
        Long specialityId = explanatoryNote.getActiveSpecialities().get(0).getSpeciality().getId();
        University university = new University();
        jdbcTemplate.query(GET_UNIVERSITY_BY_EXPLANATORY_NOTE_QUERY, new Object[]{specialityId}, new ResultSetExtractor<University>() {
            @Override
            public University extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultSet.next();
                university.setId(resultSet.getLong("id"));
                university.setName(resultSet.getString("name"));
                university.setAbbreviation(resultSet.getString("abbreviation"));
                return university;
            }
        });
        return university;
    }
}
