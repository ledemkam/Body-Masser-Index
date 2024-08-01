package techchillo.ledemkam.bmi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import techchillo.ledemkam.bmi.dto.ImcDTO;
import techchillo.ledemkam.bmi.entity.Imc;
import techchillo.ledemkam.bmi.mapper.ImcMapper;
import techchillo.ledemkam.bmi.service.ImcService;

import java.awt.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "imc")
public class ImcController {

    public ImcController(ImcMapper imcMapper, ImcService imcService) {
        this.imcMapper = imcMapper;
        this.imcService = imcService;
    }

    ImcMapper imcMapper;
    ImcService imcService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)//retour sous format json
    public Map<String, Double> calculate(@RequestBody ImcDTO imcDTO) {
        Imc imc = this.imcMapper.dtoEntity(imcDTO);
        double result = this.imcService.calculate(imc);
        return Map.of("imc", result);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)//retour sous format json
    public Set<ImcDTO> search() {
        Set<Imc> result = this.imcService.search();
        //  cidessous nous avons deux alternatives soit on utilise Set
        //final Set<ImcDTO> imcSet =  result
                 //       .stream()
                    //    .map(item ->this.imcMapper.entityDto(item))
                     //   .collect(Collectors.toSet());
       //soit loop(for)
        final Set<ImcDTO> imcSet = new HashSet<>();
        for (Imc item : result) {
            ImcDTO imcDTO = this.imcMapper.entityDto(item);
            imcSet.add(imcDTO);
        }
        return imcSet;
    }




}
