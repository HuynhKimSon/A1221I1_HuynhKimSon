package FinalExam.service;

import FinalExam.exception.NotFoundException;
import FinalExam.model.Export;
import FinalExam.model.Import;
import FinalExam.model.Product;
import FinalExam.utils.ConstantUtil;
import FinalExam.utils.FileCSVHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private final FileCSVHelper fileCSVHelper = new FileCSVHelper();

    public ProductService() {
        products = mapToProducts();
    }

    public void delete(int code) throws NotFoundException {
        if (products.removeIf(e -> e.getCode() == code)) {
            fileCSVHelper.write(products, ConstantUtil.PATH.PRODUCTS, false);
        } else {
            throw new NotFoundException("Sản phẩm " + code + " không tồn tại!");
        }
    }

    public List<Product> searchByCode(int code) {
        List<Product> result = new ArrayList();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode() == code) {
                result.add(products.get(i));
            }
        }

        return result;
    }

    public void create(Product product) {
        int lastId = 0;
        if (products.size() > 0) {
            lastId = products.get(products.size() - 1).getId();
        }
        product.setId(lastId + 1);
        products.add(product);
        fileCSVHelper.write(Collections.singletonList(product), ConstantUtil.PATH.PRODUCTS, true);
    }

    private List<Product> mapToProducts() {
        List<Product> result = new ArrayList();

        List<String> lines = fileCSVHelper.read(ConstantUtil.PATH.PRODUCTS);
        for (String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            int code = Integer.parseInt(tmp[1]);
            String name = tmp[2];
            double price = Double.parseDouble(tmp[3]);
            int quality = Integer.parseInt(tmp[4]);
            String manufacturer = tmp[5];

            if (tmp.length == 3) {
                double priceImport = Double.parseDouble((tmp[6]));
                String countryImport = tmp[7];
                double rateImport = Double.parseDouble((tmp[8]));
                result.add(new Import(id, code, name, price, quality, manufacturer, priceImport, countryImport, rateImport));
            } else {
                double priceExport = Double.parseDouble((tmp[6]));
                String countryImportProduct = tmp[7];
                result.add(new Export(id, code, name, price, quality, manufacturer, priceExport, countryImportProduct));
            }
        }
        return result;
    }

    public List<Product> findAll() {
        return products;
    }
}
