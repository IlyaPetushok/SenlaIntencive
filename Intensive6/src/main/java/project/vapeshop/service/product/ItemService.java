package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemService {
    AbstractDao<Item, Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public ItemService(AbstractDao<Item,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public ItemDTOFullInfo showItem(int id) {
        return modelMapper.map(dao.selectObject(id), ItemDTOFullInfo.class);
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        return dao.selectObjects().stream()
                .map(item -> modelMapper.map(item, ItemDTOInfoForCatalog.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean addItem(ItemDTOFullInfo itemDTO) {
        return dao.insertObject(modelMapper.map(itemDTO, Item.class));
    }

    @Transactional
    public boolean addItems(List<ItemDTOFullInfo> itemDTO) {
        return dao.insertObjects((itemDTO.stream()
                .map(itemDTOFullInfo -> modelMapper.map(itemDTOFullInfo, Item.class)).collect(Collectors.toList())));
    }

    @Transactional
    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    @Transactional
    public ItemDTOInfoForCatalog updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(itemDTOFullInfo, Item.class)), ItemDTOInfoForCatalog.class);
    }
}
