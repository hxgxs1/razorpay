package src.main.java.com.org.models;

import java.util.ArrayList;
import java.util.List;

public class Field {

    FieldType type;
    List<Constraints> constraints;
    boolean isMandatory;

    public Field(FieldType type, boolean isMandatory) {
        this.type = type;
        this.isMandatory=isMandatory;
        this.constraints=new ArrayList<>();
        constraints.add(new TypeCheckConstraint(this));
    }

    public boolean validate(Object o){
        for(Constraints c: constraints){
            if(!c.check(o))
                return false;
        }
        return true;
    }


    public void addConstraints(Constraints constraint){
        constraints.add(constraint);
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public List<Constraints> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<Constraints> feilds) {
        this.constraints = feilds;
    }

    @Override
    public String toString() {
        return "Field{" +
                "type=" + type +
                ", constraints=" + constraints +
                '}';
    }
}
