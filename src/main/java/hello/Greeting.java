package hello;



public class Greeting {
    private final int id;
    private final String content;
    private final String weather ;

    public Greeting(int id , String content, String weather){
        this.id=id;
        this.content=content;
        this.weather=weather;
    }

    public int getId(){
        return id;
    }

    public String getContent(){
        return content;
    }
//
    public String getweather(){
        return  weather;
    }

}
