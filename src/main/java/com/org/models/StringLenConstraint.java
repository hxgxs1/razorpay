package src.main.java.com.org.models;

public class StringLenConstraint implements Constraints {

    Field field;
    private int maxLen;

    public StringLenConstraint(Field field, int _maxLen) {
        this.field = field;
        maxLen=_maxLen;
    }

    @Override
    public boolean check(Object o) {
        if(o==null && field.isMandatory)
            return false;

       String s=(String)o;
       return s.length()<=maxLen;
    }
}
