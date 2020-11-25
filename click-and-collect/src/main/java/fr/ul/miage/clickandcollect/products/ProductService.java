package fr.ul.miage.clickandcollect.products;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public Iterable<Product> findPaged(int page, int size) {
        validatePage(page, size);

        return repo
                .findAll(PageRequest.of(page, size))
                .getContent();
    }

    private void validatePage(int page, int size) {
        if(page < 0) {
            throw new BadPageException(page);
        }
    }
}
