package src.main.java.com.org;


import src.main.java.com.org.api.TableApi;
import src.main.java.com.org.models.*;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {

        TableApi api= new TableApi();

        Field id=new Field(FieldType.NUMBER, true);
        Field name=new Field(FieldType.STRING, false);
        id.addConstraints(new NumberRangeConstraint(id, 1, 10000));
        name.addConstraints(new StringLenConstraint(name, 20));


        /* Table creation */
        Map<String, Field> def=new HashMap<>();
        def.put("id", id);
        def.put("name", name);
        SQLTable t=api.createTable("Employee", def);

        /** Insert rows**/
        Map<String, Object> row=new HashMap<>();
        row.put("id", 1);
        row.put("name", "rick");

        Map<String, Object> row2=new HashMap<>();
        row2.put("id", 2);
        row2.put("name", "morty");

        Map<String, Object> row3=new HashMap<>();
        row3.put("id", 3);
        row3.put("name", "mahjdkjdsljdsljdklsjdsdkjsdkjsdsesh");


        Map<String, Object> row4=new HashMap<>();
        row4.put("id", 832902);
        row4.put("name", "jerry");


        api.insertInTable(t.getName(), row);
        api.insertInTable(t.getName(), row2);
        api.insertInTable(t.getName(), row3);
        api.insertInTable(t.getName(), row4);

        /** print Table **/
        System.out.println("==================="+ t.getName() + " Table=========================");
        api.printTable(t.getName());




        /** delete table **/
        api.deleteTable(t.getName());
    }
}
