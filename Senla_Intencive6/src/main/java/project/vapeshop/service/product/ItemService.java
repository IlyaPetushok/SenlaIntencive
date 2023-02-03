package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;
import java.util.List;

@Service
public class ItemService {
    Dao<Item> dao;
    ModelMapper modelMapper;

    @Autowired
    public ItemService(Dao<Item> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public ItemDTOFullInfo showItem(int id) {
        return modelMapper.map(dao.selectObject(id),ItemDTOFullInfo.class);
    }

    public List<ItemDTOInfoForCatalog> showItems() {
        return dao.selectObjects().stream()
                .map(item -> modelMapper.map(item,ItemDTOInfoForCatalog.class))
                .toList();
    }

    @Transactional
    public boolean addItem(ItemDTOFullInfo itemDTO) {
        return dao.insertObject(modelMapper.map(itemDTO,Item.class));
    }

    public boolean addItems(List<ItemDTOFullInfo> itemDTO) {
        return dao.insertObjects((itemDTO.stream().map(itemDTOFullInfo -> modelMapper.map(itemDTOFullInfo,Item.class)).toList()));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public ItemDTOInfoForCatalog updateItem(ItemDTOFullInfo itemDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(itemDTOFullInfo,Item.class)), ItemDTOInfoForCatalog.class);
    }
}
