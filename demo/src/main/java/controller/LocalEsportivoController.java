package controller;

import entity.LocalEsportivo;
import service.LocalEsportivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locais-esportivos")
public class LocalEsportivoController {

    @Autowired
    private LocalEsportivoService localEsportivoService;


    @GetMapping
    public List<LocalEsportivo> getAllLocaisEsportivos() {
        return localEsportivoService.findAllLocaisEsportivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalEsportivo> getLocalEsportivoById(@PathVariable Long id) {
        return localEsportivoService.findLocalEsportivoById(id)
                .map(local -> new ResponseEntity<>(local, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<LocalEsportivo> createLocalEsportivo(@RequestBody LocalEsportivo localEsportivo) {
        LocalEsportivo novoLocal = localEsportivoService.saveLocalEsportivo(localEsportivo);
        return new ResponseEntity<>(novoLocal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalEsportivo> updateLocalEsportivo(@PathVariable Long id, @RequestBody LocalEsportivo updatedLocalEsportivo) {
        try {
            LocalEsportivo localEsportivo = localEsportivoService.updateLocalEsportivo(id, updatedLocalEsportivo);
            return new ResponseEntity<>(localEsportivo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalEsportivo(@PathVariable Long id) {
        localEsportivoService.deleteLocalEsportivo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
