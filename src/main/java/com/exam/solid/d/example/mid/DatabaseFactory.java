package com.exam.solid.d.example.mid;

import com.exam.solid.d.example.low.OracleDatabase;

public class DatabaseFactory {

    public static Database create() {
        return new OracleDatabase();
    }

}
