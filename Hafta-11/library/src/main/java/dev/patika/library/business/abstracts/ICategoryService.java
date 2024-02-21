package dev.patika.library.business.abstracts;

import dev.patika.library.dto.response.category.CategoryResultResponse;
import dev.patika.library.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {

    Category save(Category category);

    Category get(Long id);

    Page<Category> cursor(int page, int pageSize);

    Category update(Category category);

    CategoryResultResponse delete(Long id);
}
