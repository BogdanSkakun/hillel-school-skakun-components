package components.urlbuilder;


import java.util.HashMap;
import java.util.Map;

public class Url {

    private String url;
    private String http;
    private String resource;
    private String serverName;
    private HashMap<String, String> param;
    private String qA;


    private Url(){

    }

    private Url(UrlBuilder urlBuilder){
        this.http = urlBuilder.http;
        this.resource = urlBuilder.resource;
        this.serverName = urlBuilder.serverName;
        this.param = urlBuilder.param;
        this.qA = urlBuilder.qA;
    }

    public String getUrl(){
        String parameters = "";
        for(Map.Entry<String, String> entry: param.entrySet()){
            parameters = parameters + "&" + entry.getKey() + "=" + entry.getValue();
        }
        if( parameters!="")
        parameters = "?" + parameters.substring(1)  + qA;
        if(parameters == ""){
            return this.url = http + "://" + serverName;
        }else {
            return this.url = http + "://" + serverName + "/" + resource + "/" + parameters;
        }
    }



    public static class UrlBuilder{

        private String http = "http";
        private String resource = "";
        private String serverName = "";
        private HashMap<String, String> param =new HashMap<String, String>();
        private String qA = "";

        private UrlBuilder(){

        }

        public UrlBuilder(String serverName){
            this.serverName = serverName;
        }

        public  UrlBuilder withHttps(boolean isHttps){
            http = isHttps ? "https" : "http";
            return this;
        }
        public  UrlBuilder withResource(String resource){
            this.resource =  resource;
            return this;
        }
        public UrlBuilder withParam(String key, String value){
            this.param.put(key, value);
            return this;

        }
        public UrlBuilder withIsQa(boolean isQa){
            qA = isQa ? "&isqa=true" :"&isqa=false";
            return  this;
        }
        public Url build(){
            return  new Url(this);

        }










    }

}
