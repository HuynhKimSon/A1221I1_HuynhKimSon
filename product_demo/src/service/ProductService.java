package service;

import model.AuthenticProduct;
import model.HandProduct;
import model.Product;
import util.ConstantUtil;
import util.FileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private FileHelper fileHelper = new FileHelper();

    public ProductService() {
        products = mapToProducts();
    }

    public void create(Product product){

        //region get lastId
        int lastId = 0;
        if(products.size() > 0){
            lastId = products.get(products.size() - 1).getId();
        }
        //endregion

        product.setId(lastId + 1);
        products.add(product);
        fileHelper.write(ConstantUtil.path, Collections.singletonList(product), true);
    }

    public List findAll(){
        return products;
    }

    public void delete(int id){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getId() == id){
                products.remove(i);
                fileHelper.write(ConstantUtil.path, products, false);
                return;
            }
        }
    }

    public List searchByName(String name){
        List result = new ArrayList();

        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().contains(name)){
                result.add(products.get(i));
            }
        }

        return result;
    }

    private List mapToProducts(){
        List result = new ArrayList();

        List<String> lines = fileHelper.read(ConstantUtil.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            Double price = Double.parseDouble(tmp[2]);
            String manufacturer = tmp[3];

            if(tmp.length == 5){
                int year = Integer.parseInt(tmp[4]);
                result.add(new AuthenticProduct(id, name, price, manufacturer, year));
            }
            else {
                String country = tmp[4];
                String status = tmp[5];
                result.add(new HandProduct(id, name, price, manufacturer, country, status));
            }
        }

        return result;
    }
}
