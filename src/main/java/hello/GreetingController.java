package hello;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {
    URL url = null;

    {
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?appid=b2c8c36cbcb39ca70c9bad387ea5ca99&q=Coimbatore");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    Connection connection = new Connection(url);


    private static final String template = "Hello , %s!" ;
    private static final String climate = "Todays Weather Condition: %s!" ;
    private final AtomicInteger counter =new AtomicInteger();
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name),String.format(climate,connection.weatherData));
    }
}
