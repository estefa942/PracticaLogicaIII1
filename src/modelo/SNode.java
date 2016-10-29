package modelo;

public class SNode {
    private Object data;
    private SNode link;
    
    
    public SNode (Object d){
        data = d;
        link= null;
    }
     
    public Object getData(){
        return data;
    }
    
    public SNode getLink(){
        return link;
    }
    
    
    
    public void setData(Object x){
        data = x;
    }
    
    public void setLink(SNode x){
        link =x;
        
    }
}
