package fr.ul.miage.clickandcollect.products;

import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class ProductsControllerTest {

    public void test() {
        var pc = new ProductsController(mock(ProductRepository.class));
        pc.getAllProducts();
    }

}