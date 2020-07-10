package src.main.java.com.org;

import src.main.java.com.org.models.Field;
import src.main.java.com.org.models.SQLTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDB {

    private static InMemoryDB instance;

    Map<String, SQLTable> tables;

    private InMemoryDB() {
        tables=new HashMap<>();
    }

    public static InMemoryDB getInstance(){
        if(instance==null){
            instance=new InMemoryDB();
        }
        return instance;
    }

    public void createTable(SQLTable table){
        tables.put(table.getName(), table);
    }

    public SQLTable getTable(String name){
        return tables.get(name);
    }

    public void deleteTable(String name){

        tables.remove(name);
    }

}
