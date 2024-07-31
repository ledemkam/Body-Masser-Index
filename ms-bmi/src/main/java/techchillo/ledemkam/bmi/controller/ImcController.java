package techchillo.ledemkam.bmi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techchillo.ledemkam.bmi.dto.ImcDTO;

@RestController
@RequestMapping("imc")
public class ImcController {

    @PostMapping
    public void calculate(@RequestBody ImcDTO imcDTO) {

    }
}
