package teste.piProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teste.piProject.service.midia.MidiaService;
import teste.piProject.service.midia.dto.MidiaParaSalvarDto;

@RestController
@RequestMapping("/midias")
public class MidiaController {
    @Autowired
    private MidiaService service;
    @GetMapping("/midia-para-salvar/{idApi}")
    public ResponseEntity<MidiaParaSalvarDto> getMidiaParaSalvar(@PathVariable String idApi){
        MidiaParaSalvarDto anime = null;
        try {
            anime = service.midiaParaSalvar(Integer.parseInt(idApi));
        } catch (Exception e){
            throw e;
        }
        return ResponseEntity.status(200).body(anime);
    }
}
