package ru.shop.dbtools.services.Goods;

import ru.shop.dbtools.dto.FilteredGeneralTypeDTO;
import ru.shop.dbtools.models.goods.GeneralType;

import java.util.List;

public interface GeneralTypeService {

    List<GeneralType> getAllGeneralsType();
    List<GeneralType> getFilteredGeneralTypes(FilteredGeneralTypeDTO filteredGeneralTypeDTO);
}
