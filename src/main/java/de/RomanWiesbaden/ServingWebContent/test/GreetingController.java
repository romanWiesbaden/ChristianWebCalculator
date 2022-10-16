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


        // Model wird an die View weitergeleitet
        // und in der View mit Hilfe des Schablonizator
        // erhalten wir den Zugang zu der Zeile
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

    // Der benutzer auf die unter angegebene Adresse kann in diese Methode des Controllers
    // gelangen. Jetzt muss ich von dem Benutzer 3 Parameter des HTTP Get Requests erhalten.
    // Dafür benutze ich Annotation RequestParam
    // in dem String liegt ein des vier Werten
    // Model brauch man für die Übergabe des Ergebnisses von dem Kontroller zu der View
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

//        Das Ergebnis kehren wir mit Hilfe vom Model an die View  mit dem Schlüssel zurück.
//    Результат мы сможем передаст с помощью модели в представление
    // по ключу рresult мы поместим значение переменной result
    model.addAttribute("result", result);
        // Теперь нам нужно создать html преставление, где result будет отображен
    //Jetzt müssen wir die View erstellen, wo result wiedergegeben wird
        return "calculator";
}

}