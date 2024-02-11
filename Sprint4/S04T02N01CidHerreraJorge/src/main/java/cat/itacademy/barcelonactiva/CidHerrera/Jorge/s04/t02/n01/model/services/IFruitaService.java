package cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.exceptions.FruitaNotFoundException;
import cat.itacademy.barcelonactiva.CidHerrera.Jorge.s04.t02.n01.model.domain.Fruita;

public interface IFruitaService {
    List<Fruita> getAllFruites();

    Fruita getFruitaById(int id);

    Fruita createFruita(Fruita fruitaDto);

    Fruita updateFruita(int id, Fruita updatedFruita);

    void deleteFruitaById(int id) throws FruitaNotFoundException;
}
