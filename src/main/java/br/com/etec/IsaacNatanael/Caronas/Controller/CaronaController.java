package br.com.etec.IsaacNatanael.Caronas.Controller;

import br.com.etec.IsaacNatanael.Caronas.Entity.Carona;
import br.com.etec.IsaacNatanael.Caronas.Repository.CaronaRepository;
import br.com.etec.IsaacNatanael.Caronas.Service.CaronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CaronaController {
    @Autowired
    private CaronaService service;
    @Autowired
    private CaronaRepository repository;
    @GetMapping("/caronas")
    public List<Carona> ListarCarona(){
        return service.ListarCarona();
    }
    @GetMapping("/caronas/{Id}")
    public Carona buscarPorId(@PathVariable Long Id){
        var carona = repository.findById(Id);
        if (carona.isPresent()){
           return (Carona) carona.get();
        }
        return null;
    }
    @PostMapping
    public void Cadastrar(@RequestBody Carona carona){
        repository.save(carona);
    }
    @DeleteMapping("/{Id}")
    public void deletar(@PathVariable Long Id){
        var carona = repository.findById(Id);
        if (carona.isPresent()){
            repository.delete(carona.get());
        }
    }
}
