package ru.shop.shopapi.services.goods;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shop.shopapi.dto.FilteredGeneralTypeDTO;
import ru.shop.dbtools.models.goods.GeneralType;
import ru.shop.dbtools.repositories.GeneralTypeRepo;

import java.util.List;

@Service
public class GeneralTypeServiceImpl implements GeneralTypeService {

    private final GeneralTypeRepo generalTypeRepo;

    public GeneralTypeServiceImpl(GeneralTypeRepo generalTypeRepo) {
        this.generalTypeRepo = generalTypeRepo;
    }


    @Override
    @Transactional
    public List<GeneralType> getAllGeneralsType() {
        return (List<GeneralType>) generalTypeRepo.findAll();
    }

    @Override
    @Transactional
    public List<GeneralType> getFilteredGeneralTypes(FilteredGeneralTypeDTO filteredGeneralTypeDTO) {
        return null;
    }
}
