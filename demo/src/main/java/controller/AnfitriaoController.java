package controller;

import entity.Anfitriao;
import service.AnfitriaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/anfitrioes")
public class AnfitriaoController {

    @Autowired
    private AnfitriaoService anfitriaoService;


    @GetMapping
    public List<Anfitriao> getAllAnfitrioes() {
        return anfitriaoService.findAllAnfitrioes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anfitriao> getAnfitriaoById(@PathVariable Long id) {
        Optional<Anfitriao> anfitriao = anfitriaoService.findAnfitriaoById(id);
        return anfitriao.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Anfitriao createAnfitriao(@RequestBody Anfitriao anfitriao) {
        return anfitriaoService.saveAnfitriao(anfitriao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anfitriao> updateAnfitriao(@PathVariable Long id, @RequestBody Anfitriao updatedAnfitriao) {
        try {
            Anfitriao anfitriao = anfitriaoService.updateAnfitriao(id, updatedAnfitriao);
            return new ResponseEntity<>(anfitriao, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnfitriao(@PathVariable Long id) {
        anfitriaoService.deleteAnfitriao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

