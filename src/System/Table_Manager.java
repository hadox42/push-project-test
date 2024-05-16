package System;

import javax.swing.table.DefaultTableModel;

public class Table_Manager {
    public static void refreshTable(DefaultTableModel model) {
        model.setRowCount(0);
        Database_Manager.fetchData(model);
    }
}