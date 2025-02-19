package unbreakk1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FischeSpringWebController
{
    @GetMapping("/api/hello/{name}")
    public String hello(@PathVariable String name)
    {
        return "Hello " + name;
    }
}
