package src.main.java.com.org.api;

import src.main.java.com.org.InMemoryDB;
import src.main.java.com.org.models.Field;
import src.main.java.com.org.models.SQLTable;
import src.main.java.com.org.models.Table;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TableApi {

    private InMemoryDB db;


    public TableApi(){
        db=InMemoryDB.getInstance();
    }

    public SQLTable createTable(String name, Map<String, Field> def){
        SQLTable t=new SQLTable();
        t.setName(name);
        t.setDefinition(def);
        db.createTable(t);
        System.out.println("Table has been created");
        return t;
    }

    public void insertInTable(String tableName, Map<String, Object> row){
        SQLTable table=db.getTable(tableName);
        Optional<String> response=table.insert(row);
        if(response.isPresent())
            System.out.println("Insertion Successful");
        else
            System.out.println("ERROR in insertion");

    }

    public void printTable(String tableName){
        SQLTable table=db.getTable(tableName);
        Set<String> columnNames= table.getDefinition().keySet();
        columnNames.forEach(x-> System.out.print(x+"\t"));
        System.out.println();
        for(Map<String, Object> row: table.getRows()){
            for(Map.Entry<String, Object> e: row.entrySet()){

                System.out.print(e.getValue()+ "\t");
            }
            System.out.println();
        }

    }

    public void deleteTable(String name){
        SQLTable table=db.getTable(name);
        table.setName(null);
        table.setRows(null);
        table.setDefinition(null);
        db.deleteTable(name);
        System.out.println("Table has been deleted");
    }
}
