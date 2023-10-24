package f5.software.ecomm.appication.service;

import f5.software.ecomm.domain.ItemCar;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarService {

    private List<ItemCar> itemCarList;
    private HashMap<Integer, ItemCar> itemCarHP;

    public CarService() {
        this.itemCarHP = new HashMap<>();
        this.itemCarList = new ArrayList<>();
    }

    public void addItemCar(Integer qty, Integer idProduct, String nameProduct, BigDecimal price){
        ItemCar itemCar = new ItemCar(idProduct, nameProduct, qty, price);
        itemCarHP.put(itemCar.getIdProduct(), itemCar);
        _fillList();
    }

    public BigDecimal getTotalCar(){
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCar item : itemCarList){
            total = total.add(item.getTotalPriceItem());
        }
        return total;
    }

    public void removeItemCar(Integer idProduct){
        itemCarHP.remove(idProduct);
        _fillList();
    }

    public void removeAllItemCar(){
        itemCarHP.clear();
        itemCarList.clear();
    }

    private void _fillList(){
        itemCarList.clear();
        itemCarHP.forEach(((integer, itemCar) -> itemCarList.add(itemCar)));
    }

    //
    public List<ItemCar> list(){
      return itemCarList;
    }

}
