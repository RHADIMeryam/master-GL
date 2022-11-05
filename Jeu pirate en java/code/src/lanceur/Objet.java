
public class Objet {
    private int id;
    private typeObjet o;
    public Objet(int id , typeObjet ob ){
        this.o=ob;
        this.id=id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
}