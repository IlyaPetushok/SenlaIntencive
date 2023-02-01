package project.vapeshop.mapper.impl.product;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.entity.product.Item;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class ItemFullInfoMapper implements Mapper<Item,ItemDTOFullInfo> {
    @Override
    public ItemDTOFullInfo toDTO(Item item) {
        return new ItemDTOFullInfo(item.getId(), item.getPhoto(), item.getName(), item.getIdCategory(), item.getPrice(), item.getQuantity());
    }

    @Override
    public List<ItemDTOFullInfo> toDTOs(List<Item> itemEntities) {
        return null;
    }

    @Override
    public Item toEntity(ItemDTOFullInfo itemDTOFullInfo) {
        return new Item(itemDTOFullInfo.getId(), itemDTOFullInfo.getPhoto(), itemDTOFullInfo.getName(), itemDTOFullInfo.getIdCategory(), itemDTOFullInfo.getPrice(), itemDTOFullInfo.getQuantity());
    }


    @Override
    public List<Item> toEntities(List<ItemDTOFullInfo> itemFullInfoMappers) {
        return itemFullInfoMappers.stream()
                .map(item->new Item(item.getId(), item.getPhoto(), item.getName(), item.getIdCategory(), item.getPrice(), item.getQuantity()))
                .toList();
    }
}
