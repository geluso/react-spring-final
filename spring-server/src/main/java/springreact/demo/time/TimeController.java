package springreact.demo.time;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/time")
public class TimeController {
    @GetMapping
    public @ResponseBody TimePOJO getTime() {
        System.out.println("getting time");
        Calendar cal = GregorianCalendar.getInstance();
        TimePOJO time = new TimePOJO();
        time.hour = cal.get(Calendar.HOUR_OF_DAY);
        time.minute = cal.get(Calendar.MINUTE);
        time.dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        time.month = cal.get(Calendar.MONTH);
        System.out.println("time: " + time);
        return time;
    }

    @GetMapping(path = "/html")
    public @ResponseBody String getHTML() {
        return "<h1>Bogus HTML</h1>";
    }
}
