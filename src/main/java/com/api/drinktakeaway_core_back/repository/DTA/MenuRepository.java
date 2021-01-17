package com.api.drinktakeaway_core_back.repository.DTA;

import com.api.drinktakeaway_core_back.entity.DTA.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    // public List<Menu> findByPriceLesserThan(int maxPrice);

    @Query("Select m from Menu m where m.price < :maxPrice")
    List<Menu> findBevandaWithMaxPrice(@Param("maxPrice") float maxPrice);

    @Query("Select m from Menu m where m.locale.id = :idLocale")
    List<Menu> findMenuLocaleByIdLocale(@Param("idLocale") int idLocale);

    @Query("Select m from Menu m where m.bevanda.id = :idBevanda")
    List<Menu> findLocaliByIdBevanda(@Param("idBevanda") int idBevanda);

    @Query("Select m from Menu m where m.locale.name = :nameLocale")
    List<Menu> findMenuByNomeLocale(@Param("nameLocale") String nameLocale);

    @Query("Select m from Menu m where m.locale.name = :nameLocale AND m.bevanda.type = :typeBevanda")
    List<Menu> findBevandaByNomeLocaleTypeBevanda(@Param("nameLocale") String nameLocale,
            @Param("typeBevanda") String typeBevanda);

    @Query("Select m from Menu m where m.locale.id = :idLocale AND m.bevanda.id = :idBevanda")
    Menu findMenuByIDs(@Param("idLocale") int idLocale, @Param("idBevanda") int idBevanda);

}
