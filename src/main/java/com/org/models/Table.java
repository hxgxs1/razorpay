package src.main.java.com.org.models;

import java.util.Map;
import java.util.Optional;

public interface Table {

    public Optional<String> insert(Map<String, Object> row);
    public void delete();
}
