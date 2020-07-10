package src.main.java.com.org.models;

import java.beans.FeatureDescriptor;
import java.util.*;

public class SQLTable implements Table {


    private Map<String, Field> definition;
    private String name;
    private List<Map<String , Object>> rows;



    public SQLTable() {
        definition=new HashMap<>();
        rows=new ArrayList<>();
    }

    public Map<String, Field> getDefinition() {
        return definition;
    }

    public void setDefinition(Map<String, Field> definition) {
        this.definition = definition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    private int getMandatoryCount(){
        int count=0;
        for(Map.Entry<String, Field> e: definition.entrySet()){
            if(e.getValue().isMandatory)
                count++;
        }
        return count;
    }

    @Override
    public Optional<String> insert(Map<String, Object> row) {

        int mandatoryCount=getMandatoryCount();
        int count=0;

        for(Map.Entry<String, Object> column: row.entrySet()){
            if(definition.containsKey(column.getKey())){
                Field f=definition.get(column.getKey());

                if(f.validate(column.getValue())){
                    //Todo: fail-fast
                    if(f.isMandatory)
                        count++;
                }else {

                    System.out.println("column validation failed for: {} " + column.getKey() + " value: " + column.getValue());
                    return Optional.empty();
                }

            }else{
                System.out.println("Column Name not present");
                return Optional.empty();
            }

        }
        if(count==mandatoryCount) {
            rows.add(row);
            return Optional.of("SUCCESS");
        }
        else {
            System.out.println("Not all mandatory column are present");
            return Optional.empty();
        }

    }

    @Override
    public void delete() {

    }

    @Override
    public String toString() {
        return "SQLTable{" +
                "definition=" + definition +
                ", name='" + name + '\'' +
                ", rows=" + rows +
                '}';
    }
}
