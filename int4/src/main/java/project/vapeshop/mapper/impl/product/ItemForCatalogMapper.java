package project.vapeshop.mapper.impl.product;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.entity.product.Item;
import project.vapeshop.mapper.Mapper;

import java.util.List;
import java.util.Objects;

@Component
public class ItemForCatalogMapper implements Mapper<Item, ItemDTOInfoForCatalog> {
    @Override
    public ItemDTOInfoForCatalog toDTO(Item item) {
        return null;
    }

    @Override
    public List<ItemDTOInfoForCatalog> toDTOs(List<Item> itemEntities) {
        return itemEntities.stream()
                .filter(Objects::nonNull)
                .map(item->new ItemDTOInfoForCatalog(item.getId(), item.getPhoto(), item.getName())).toList();
    }

    @Override
    public Item toEntity(ItemDTOInfoForCatalog itemDTOInfoForCatalog) {
        return null;
    }

    @Override
    public List<Item> toEntities(List<ItemDTOInfoForCatalog> itemDTOInfoForCatalogs) {
        return null;
    }
}
