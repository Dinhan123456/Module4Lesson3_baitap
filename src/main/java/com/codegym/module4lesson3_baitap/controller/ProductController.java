
package com.codegym.module4lesson3_baitap.controller;

import com.codegym.module4lesson3_baitap.model.Product;
import com.codegym.module4lesson3_baitap.service.IProductService;
import com.codegym.module4lesson3_baitap.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products", products);
        return "/index";
    }



    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }


}
