package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.RankingEntity;
import G1TBD.LABTBD.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
@CrossOrigin(origins = "http://localhost:8090/rankings")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    String homeLinkRedirect = "redirect:/rankings";

    @PostMapping("/create")
    public String create(@RequestBody RankingEntity ranking) {
        rankingService.create(ranking);
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<RankingEntity> getAll() {
        return rankingService.getAll();
    }

    @GetMapping("/id/{id}")
    public RankingEntity getById(@PathVariable long id) {
        return rankingService.getById(id);
    }

    @GetMapping("/taskId/{id}")
    public List<RankingEntity> getByTaskId(@PathVariable long id) {
        return rankingService.getByTaskId(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody RankingEntity ranking) {
        return rankingService.update(ranking);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return rankingService.delete(id);
    }
}
