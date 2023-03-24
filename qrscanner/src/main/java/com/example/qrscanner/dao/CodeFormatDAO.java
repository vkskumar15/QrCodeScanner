package com.example.qrscanner.dao;


import com.example.qrscanner.db.CodeFormatItem;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeFormatDAO extends BaseDaoImpl<CodeFormatItem, Integer> {

    private List<CodeFormatItem> contactCallRecordList = new ArrayList<>();

    public CodeFormatDAO(ConnectionSource connectionSource, Class<CodeFormatItem> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<CodeFormatItem> getAllItems() throws SQLException {
        return this.queryForAll();
    }


}