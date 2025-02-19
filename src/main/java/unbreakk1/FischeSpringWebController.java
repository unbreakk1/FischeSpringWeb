package unbreakk1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController()
public class FischeSpringWebController
{
    private final List<Message> messages = new ArrayList<>();
    private final int secretNumber = (int) (Math.random() * 100 + 1);

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

    @GetMapping("/api/joke")
    public String getRandomJoke()
    {
        String[] jokes =
        {
          "What do you call a fake noodle? An impasta!",
          "Why don’t skeletons fight each other? They don’t have the guts.",
          "Parallel lines have so much in common. It’s a shame they’ll never meet."
        };
        int randomIndex = (int) (Math.random() * jokes.length);
        return jokes[randomIndex];
    }

    @GetMapping("/api/reverse")
    public String reverseText(@RequestParam String text)
    {
        return new StringBuilder(text).reverse().toString();
    }

    @GetMapping("/api/guess")
    public String guessNumber(@RequestParam int guess)
    {
        if (guess < secretNumber)
            return "Too low! Try again.";
        else if (guess > secretNumber)
            return "Too high! Try again.";
        else
            return "Congratulations! You guessed the number!";
    }
}
