package dev.skosarev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") String a,
                            @RequestParam("b") String b,
                            @RequestParam("action") String action,
                            Model model) {
        try {
            int a_num = Integer.parseInt(a);
            int b_num = Integer.parseInt(b);

            switch (action) {
                case "multiplication":
                case "m":
                    model.addAttribute("result", "Result: " + (a_num * b_num));
                    break;
                case "addition":
                case "a":
                    model.addAttribute("result", "Result: " + (a_num + b_num));
                    break;
                case "subtraction":
                case "s":
                    model.addAttribute("result", "Result: " + (a_num - b_num));
                    break;
                case "division":
                case "d":
                    model.addAttribute("result", "Result: " + 1.0 * (a_num / b_num));
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
            System.out.println(a_num / b_num);
        } catch (UnsupportedOperationException e) {
            model.addAttribute("result", "Error: unsupported action (" + action + ')');
        } catch (NumberFormatException e) {
            model.addAttribute("result", "Error: values are not numbers");
        } catch (ArithmeticException e) {
            model.addAttribute("result", "Error: division by zero");
        } catch (Exception e) {
            model.addAttribute("result", "Unknown error");
        }
        return "first/calculator";
    }
}
