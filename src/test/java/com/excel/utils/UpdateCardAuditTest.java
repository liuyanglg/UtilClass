package com.excel.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateCardAuditTest {
    String path = "D:\\Download\\corret_data.xlsx";

    @Test
    public void updateTable() throws Exception {
        UpdateCardAudit.updateTable(path);
    }

}