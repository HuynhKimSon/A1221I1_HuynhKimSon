package vn.codegym.dto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CartDto {

    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1); // update
        } else {
            productMap.put(productDto, 1); // add
        }
    }

    public int totalQuantity() {
        int result = 0;
        Set set = productMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry item = (Map.Entry) i.next();
            result += Integer.parseInt(item.getValue().toString());
        }

        return result;
    }

    public double totalAmount() {
        double result = 0.0;
        Set set = productMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry item = (Map.Entry) i.next();
            ProductDto productDto = (ProductDto) item.getKey();
            double price = productDto.getPrice();
            int quantity = Integer.parseInt(item.getValue().toString());
            result += price * quantity;
        }
        return result;
    }
}
