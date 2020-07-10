package src.main.java.com.org.models;

public class TypeCheckConstraint implements Constraints {


    Field field;

    public TypeCheckConstraint(Field field) {
        this.field = field;
    }

    @Override
    public boolean check(Object o) {

        if(field.isMandatory && o==null)
            return false;

        if(field.type==FieldType.NUMBER){
            try{
                Integer i=(Integer)o;
                return true;
            }catch(Exception e){
                return false;
            }
        }
        else{
            if(field.type==FieldType.STRING){
                String s=(String)o;
                for(char ch: s.toCharArray()){
                    if(ch<'a' || ch>'z')
                        return false;
                }
            }
            return true;
        }

    }

}
