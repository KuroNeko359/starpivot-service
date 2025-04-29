package org.kuroneko.starpivot.service;

import org.junit.jupiter.api.Test;
import org.kuroneko.starpivot.services.SQLiteOperation;

public class SQLiteTest {
    @Test
    public void test() {
        SQLiteOperation sqLiteOperation = new SQLiteOperation();
        sqLiteOperation.createTable();
    }
}
