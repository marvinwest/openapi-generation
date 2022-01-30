package de.delegateserver.spring.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-30T14:19:44.509599900+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.bookstorage.base-path:}")
public class BooksApiController implements BooksApi {

    private final BooksApiDelegate delegate;

    public BooksApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) BooksApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new BooksApiDelegate() {});
    }

    @Override
    public BooksApiDelegate getDelegate() {
        return delegate;
    }

}
