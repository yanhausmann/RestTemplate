package com.yanhausmann.testresttemplate.consultaCEP;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yanhausmann.testresttemplate.DTO.ResultCEPDTO;

@RestController
@RequestMapping(value = "/consulta-cep")
@CrossOrigin("*")

public class ConsultaCEPApi {

    @GetMapping("{cep}")
    public ResultCEPDTO consultaCEP(@PathVariable("cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultCEPDTO> resp = restTemplate.getForEntity(String.format("http://viacep.com.br/ws/%s/json/", cep),ResultCEPDTO.class);
        
        return resp.getBody();
    }
}
