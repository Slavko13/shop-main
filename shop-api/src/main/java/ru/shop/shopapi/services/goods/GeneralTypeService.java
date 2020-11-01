package ru.shop.shopapi.services.goods;

import ru.shop.shopapi.dto.FilteredGeneralTypeDTO;
import ru.shop.dbtools.models.goods.GeneralType;

import java.util.List;

public interface GeneralTypeService {

    List<GeneralType> getAllGeneralsType();
    List<GeneralType> getFilteredGeneralTypes(FilteredGeneralTypeDTO filteredGeneralTypeDTO);
}
