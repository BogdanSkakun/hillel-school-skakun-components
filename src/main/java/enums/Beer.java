package enums;

/**
 * Created by HillelNew5 on 12.04.2018.
 */
public enum Beer {
    HEINEKEN(Type.LAGER, 5.0),
    GUINESS(Type.STOUT, 4.2),
    CORONA(Type.LAGER,4.6),
    BUDWEISER(Type.LAGER, 5.0);

    private final Type type;
    private final double alcoholContent;
    Beer(Type type,double alcoholContent){
        this.type = type;
        this.alcoholContent = alcoholContent;
    }
    public Type getType(){
        return  this.type;
    }
    public double getAlcoholContent(){
        return  this.alcoholContent;
    }
}
