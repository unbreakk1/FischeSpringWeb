package unbreakk1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController()
public class FischeSpringWebController
{
    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/api/hello")
    public String hello()
    {
        return "Hello World!";
    }

    @GetMapping("/api/hello/{name}")
    public String hello(@PathVariable String name)
    {
        return "Hello " + name;
    }

    @GetMapping("/api/messages")
    public List<Message> getAllMessages()
    {
        return messages;
    }

    @PostMapping("/api/messages")
    public String addMessage(@RequestBody Message newMessage)
    {
        messages.add(newMessage);
        return "Message added successfully!";
    }

    @DeleteMapping("/api/messages/{id}")
    public String deleteMessageById(@PathVariable String id)
    {
        Iterator<Message> iterator = messages.iterator();

        // messages.removeIf(message -> message.getId().equals(id) does the same thing
        while (iterator.hasNext())
        {
            Message message = iterator.next();
            if (message.getId().equals(id))
            {
                iterator.remove();
                return "Message with id " + id + " was deleted successfully!";
            }
        }
        return "Message with id " + id + " not found.";
    }
}
