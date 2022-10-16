package de.RomanWiesbaden.ServingWebContent.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // Hier legen wir das Paar Schlüssel und den Wert (пара ключ - значение) mit der Hilfe addAttribute
        model.addAttribute("name", name);

        // Wir übergeben die folgenden Parameter der HTTP Request ind die View und geben sie zu dem Benutzer
        // In den Parametern geben wir Model an. Die Model wird an die View weitergeleitet und die der View mit
        // Hilfe des Schablonizator Thymeleave bekommen wir den Zugang zu dieser Zeile
        // man kann auch ausser schlüssel noch den Wert hinlegen, die mit der Hilfe der Konkatanation erstellt wird
        // "Hello,  " +name + " "
      //  System.out.println("Hello,  " +name + " ");
        // Модель будет передана в представление. И в представление с помощью шаблонизатора таймлиф
        // мы получим доступ к строке System.out.println("Hello,  " +name + " ");
        return "greeting";
    }

//    Model leitet das Ergebnis von dem Controller an die View weiter.
//     Spring fügt das Model in die Methode des Kontrollers ein
//     In der String wird einn von 4 möglichen Werten liegen

//    Пользователь по ниже указанному адресу может попасть в этот метод контроллера
    // Теперь я должен получить от пользователя три параметра гет запроса. для этого
    // я использую анатацию RequestParam
    // В строке будет лежать одно из четерых значений
    // модель нужна для передачи результата от контроллера к представлению
@GetMapping("/calculator")
public String calculator(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model ){
        double result;

        switch(action){
            case "multiplication":
                result = a *b;
                break;
                case "division":
                    result = a /(double) b;
                    break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a +b;
                break;
            default:
                result = 0;
                break;

        }

//        Das Ergebnis kehren wir mit Hilfe vom Model an die View zurück.
//    Результат мы сможем передаст с помощью модели в представление
    // по ключу рresult мы поместим значение переменной result
    model.addAttribute("result", result);
        // Теперь нам нужно создать html преставление, где result будет отображен
        return "calculator";
}

}