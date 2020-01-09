import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
class HomeController {            //HomeController handles the request to the path “/”.
    @Autowired
    public SpringLibDAO dao;
    @RequestMapping("/")
    public String viewHome() {
        return "LMS";        // method viewHome() tell us that any request for path “/” will go inside this method and will return the view “index”
    }
}
