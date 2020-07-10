package src.main.java.com.org.models;

public class NumberRangeConstraint implements Constraints {

    private  Field field;
    private int minValue;
    private int maxValue;


    public NumberRangeConstraint(Field field, int minVal, int maxVal) {
        this.field = field;
        minValue=minVal;
        maxValue=maxVal;
    }

    @Override
    public boolean check(Object o) {
        Integer num=(Integer)o;
        if(num<minValue || num> maxValue)
            return false;
        return true;
    }
}
