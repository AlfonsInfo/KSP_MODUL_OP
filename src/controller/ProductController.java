package controller;

import dao.ProductDao;
import java.util.List;
import model.Product;

public class ProductController {
        private final ProductDao productDao = new ProductDao();
    
 
    
    public void create(Product  product){
        productDao.create(product);
    }
    
    public List<Product> read(String searchKey){
        return productDao.read(searchKey);
    }
    
    public void update(Integer id, Product product){
        productDao.update(id, product);
    }
    
    public void delete(String id){
        productDao.delete(id);
    }
}
