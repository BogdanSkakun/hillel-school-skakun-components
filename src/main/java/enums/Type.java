package enums;

/**
 * Created by HillelNew5 on 12.04.2018.
 */
public enum Type {
    LAGER("lager"),
    STOUT("Stout");

    private final String type;
    Type(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
