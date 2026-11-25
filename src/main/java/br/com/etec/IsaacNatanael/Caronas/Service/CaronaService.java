package br.com.etec.IsaacNatanael.Caronas.Service;

import br.com.etec.IsaacNatanael.Caronas.Entity.Carona;
import br.com.etec.IsaacNatanael.Caronas.Repository.CaronaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaronaService {
    @Autowired
    private CaronaRepository repository;
    @Autowired
    private Carona carona;
    public Object ReservarCarona(Id){
    var carona = repository.findById(Id);
    if (carona.VagasDisponiveis <= 0 || carona.status == "LOTADO"){
        throw new IllegalArgumentException("Não há vagas disponíveis para esta carona.");

    }
    carona.vagasDisponiveis = carona.vagasDisponiveis - 1;
    if (carona.vagasDisponiveis == 0){
        this.carona.setStatus("LOTADO");
    }
    return repository.save(carona);

    }
    public List<Carona> ListarCarona(){
        var result = repository.findAll();
        return result;
    }

}
