package com.productapp.productapptask2.controller;

import com.productapp.productapptask2.entity.Category;
import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.model.ProductModel;
import com.productapp.productapptask2.repo.CategoryRepository;
import com.productapp.productapptask2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(path = "/home/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    //------------------------------------------------------------------------------------------------------------------//

    @GetMapping
    public String listProducts(Model model) {
        List<ProductModel> products = productService.getProducts();

        model.addAttribute("products", products);

        return "list";
    }

    @GetMapping(path = "/searchProduct")
    public String listProducts(Model model, @RequestParam("productName") String name) {
        List<ProductModel> products = productService.getProductsByIdOrName(name);

        model.addAttribute("products", products);

        return "list";
    }

//------------------------------------------------------------------------------------------------------------------//



    @GetMapping(path = "/addProduct")
    public String addProductView(Model model){

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);

        return "add";
    }

    @PostMapping(path = "/saveNewProduct")
    public String saveNewProduct(@RequestParam("productName") String name,
                                 @RequestParam("productPrice") double productPrice,
                                 @RequestParam("productCategory") int productCategory,
                                 @RequestParam("productQuantity") int productQuantity) {
        productService.addNewProduct(name,productPrice,productCategory,productQuantity);
        return "redirect:/home/products";
    }



//------------------------------------------------------------------------------------------------------------------//


    @PostMapping(path = "/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int productId) {
        productService.deleteProduct(productId);
        return "redirect:/home/products";
    }


//------------------------------------------------------------------------------------------------------------------//

    @GetMapping(path = "/updateProduct")
    public String updateProductView() {
        return "update";
    }

    @PostMapping (path = "/updateProduct")
    public String updateProduct(@RequestParam("productId") int productId,
                                @RequestParam("productName") String productName,
                                @RequestParam("productPrice") double productPrice,
                                @RequestParam("productQuantity") int productQuantity){
        productService.updateProduct(productId,productName,productPrice,productQuantity);
        return "redirect:/home/products";
    }

}