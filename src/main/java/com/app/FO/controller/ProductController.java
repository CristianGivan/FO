package com.app.FO.controller;

import com.app.FO.mapper.dto.product.ProductDTO;
import com.app.FO.mapper.mappers.ProductDTOMapper;
import com.app.FO.model.product.Product;
import com.app.FO.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;

    private ProductDTOMapper productDTOMapper;

    @Autowired
    public ProductController(ProductService productService, ProductDTOMapper productDTOMapper) {
        this.productService = productService;
        this.productDTOMapper = productDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewProduct")
    public ProductDTO postNewProduct(@RequestParam String name, @RequestParam String unit) {
        Product product = productService.postProduct(name, unit);
        return productDTOMapper.productToProductDTO(product);
    }


    //-- PutMapping

    @PutMapping("/putNameToProduct")
    public ProductDTO putNameToProduct(@RequestParam Long productId, @RequestParam String name) {
        Product product = productService.putNameToProduct(productId, name);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putUnitToProduct")
    public ProductDTO putUnitToProduct(@RequestParam Long productId, @RequestParam String unit) {
        Product product = productService.putUnitToProduct(productId, unit);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putCategoryToProduct")
    public ProductDTO putCategoryToProduct(@RequestParam Long productId, @RequestParam String category) {
        Product product = productService.putCategoryToProduct(productId, category);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putProducerToProduct")
    public ProductDTO putProducerToProduct(@RequestParam Long productId, @RequestParam String producer) {
        Product product = productService.putProducerToProduct(productId, producer);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putUserToProduct")
    public ProductDTO putUserToProduct(@RequestParam Long productId, @RequestParam Long userId) {
        Product product = productService.putUserToProduct(productId, userId);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putTagToProduct")
    public ProductDTO putTagToProduct(@RequestParam Long productId, @RequestParam Long tagId) {
        Product product = productService.putTagToProduct(productId, tagId);
        return productDTOMapper.productToProductDTO(product);
    }


    @PutMapping("/putReminderToProduct")
    public ProductDTO putReminderToProduct(@RequestParam Long productId, @RequestParam Long reminderId) {
        Product product = productService.putReminderToProduct(productId, reminderId);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putTopicToProduct")
    public ProductDTO putTopicToProduct(@RequestParam Long productId, @RequestParam Long topicId) {
        Product product = productService.putTopicToProduct(productId, topicId);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putTasksToProduct")
    public ProductDTO putTasksToProduct(@RequestParam Long productId, @RequestParam Long tasksId) {
        Product product = productService.putTasksToProduct(productId, tasksId);
        return productDTOMapper.productToProductDTO(product);
    }

    @PutMapping("/putExpenseToProduct")
    public ProductDTO putExpenseToProduct(@RequestParam Long productId, @RequestParam Long expenseId) {
        Product product = productService.putExpenseToProduct(productId, expenseId);
        return productDTOMapper.productToProductDTO(product);
    }

    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromProduct")
    public ProductDTO deleteRoleFromProduct(@RequestParam Long productId, @RequestParam Long userId) {
        Product product = productService.deleteUserFromProduct(productId, userId);
        return productDTOMapper.productToProductDTO(product);
    }

    @DeleteMapping("/deleteTagFromProduct")
    public ProductDTO deleteTagFromProduct(@RequestParam Long productId, @RequestParam Long tagId) {
        Product product = productService.deleteTagFromProduct(productId, tagId);
        return productDTOMapper.productToProductDTO(product);
    }

    @DeleteMapping("/deleteReminderFromProduct")
    public ProductDTO deleteReminderFromProduct(@RequestParam Long productId, @RequestParam Long reminderId) {
        Product product = productService.deleteReminderFromProduct(productId, reminderId);
        return productDTOMapper.productToProductDTO(product);
    }


    @DeleteMapping("/deleteTopicFromProduct")
    public ProductDTO deleteTopicFromProduct(@RequestParam Long productId, @RequestParam Long topicId) {
        Product product = productService.deleteTopicFromProduct(productId, topicId);
        return productDTOMapper.productToProductDTO(product);
    }

    @DeleteMapping("/deleteTasksFromProduct")
    public ProductDTO deleteTasksFromProduct(@RequestParam Long productId, @RequestParam Long tasksId) {
        Product product = productService.deleteTasksFromProduct(productId, tasksId);
        return productDTOMapper.productToProductDTO(product);
    }

    @DeleteMapping("/deleteExpenseFromProduct")
    public ProductDTO deleteExpenseFromProduct(@RequestParam Long productId, @RequestParam Long expenseId) {
        Product product = productService.deleteExpenseFromProduct(productId, expenseId);
        return productDTOMapper.productToProductDTO(product);
    }


    @DeleteMapping("/deleteProduct")
    public List<ProductDTO> deleteProduct(@RequestParam Long productId) {
        List<Product> productList = productService.deleteProduct(productId);
        return productDTOMapper.productListToProductDTOList(productList);
    }


    //---GetMapping

    @GetMapping("/getAllProduct")
    public List<ProductDTO> getAllProduct() {
        List<Product> productList = productService.getAllProduct();
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductById")
    public ProductDTO getProductById(@RequestParam Long productId) {
        Product product = productService.getProductByProductId(productId);
        return productDTOMapper.productToProductDTO(product);
    }

    @GetMapping("/getProductBySubject")
    public ProductDTO getProductBySubject(@RequestParam String subject) {
        Product product = productService.getProductBySubject(subject);
        return productDTOMapper.productToProductDTO(product);
    }

    @GetMapping("/getProductListBySubjectContains")
    public List<ProductDTO> getProductListBySubjectContains(@RequestParam String subjectContain) {
        List<Product> productList = productService.getProductListBySubjectContains(subjectContain);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductByName")
    public List<ProductDTO> getProductListByName(@RequestParam String name) {
        List<Product> productList = productService.getProductListByName(name);
        return productDTOMapper.productListToProductDTOList(productList);
    }


    @GetMapping("/getProductListByNameContains")
    public List<ProductDTO> getProductListByNameContains(@RequestParam String nameContain) {
        List<Product> productList = productService.getProductListByNameContains(nameContain);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByUnit")
    public List<ProductDTO> getProductListByUnit(@RequestParam String unit) {
        List<Product> productList = productService.getProductListByUnit(unit);
        return productDTOMapper.productListToProductDTOList(productList);
    }


    @GetMapping("/getProductListByUnitContains")
    public List<ProductDTO> getProductListByUnitContains(@RequestParam String unitContain) {
        List<Product> productList = productService.getProductListByUnitContains(unitContain);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductByCategory")
    public ProductDTO getProductByCategory(@RequestParam String category) {
        Product product = productService.getProductByCategory(category);
        return productDTOMapper.productToProductDTO(product);
    }

    @GetMapping("/getProductListByCategoryContains")
    public List<ProductDTO> getProductListByCategoryContains(@RequestParam String categoryContain) {
        List<Product> productList = productService.getProductListByCategoryContains(categoryContain);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductByProducer")
    public List<ProductDTO> getProductByProducer(@RequestParam String producer) {
        List<Product> productList = productService.getProductByProducer(producer);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByProducerContains")
    public List<ProductDTO> getProductListByProducerContains(@RequestParam String producerContain) {
        List<Product> productList = productService.getProductListByProducerContains(producerContain);
        return productDTOMapper.productListToProductDTOList(productList);
    }


    @GetMapping("/getProductListByNumberOfBuys")
    public List<ProductDTO> getProductListByNumberOfBuys(@RequestParam Integer numberOfBuys) {
        List<Product> productList = productService.getProductListByNumberOfBuys(numberOfBuys);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByNumberOfBuysBetween")
    public List<ProductDTO> getProductListByNumberOfBuysBetween(@RequestParam Integer numberOfBuysMin, @RequestParam Integer numberOfBuysMax) {
        List<Product> productList = productService.getProductListByNumberOfBuysBetween(numberOfBuysMin, numberOfBuysMax);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByNumberForMeanQuantity")
    public List<ProductDTO> getProductListByNumberForMeanQuantity(@RequestParam Integer numberForMeanQuantity) {
        List<Product> productList = productService.getProductListByNumberForMeanQuantity(numberForMeanQuantity);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByNumberForMeanQuantityBetween")
    public List<ProductDTO> getProductListByNumberForMeanQuantityBetween(@RequestParam Integer numberForMeanQuantityMin, @RequestParam Integer numberForMeanQuantityMax) {
        List<Product> productList = productService.getProductListByNumberForMeanQuantityBetween(numberForMeanQuantityMin, numberForMeanQuantityMax);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByNumberForMeanPrice")
    public List<ProductDTO> getProductListByNumberForMeanPrice(@RequestParam Integer numberForMeanPrice) {
        List<Product> productList = productService.getProductListByNumberForMeanPrice(numberForMeanPrice);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByNumberForMeanPriceBetween")
    public List<ProductDTO> getProductListByNumberForMeanPriceBetween(@RequestParam Integer numberForMeanPriceMin, @RequestParam Integer numberForMeanPriceMax) {
        List<Product> productList = productService.getProductListByNumberForMeanPriceBetween(numberForMeanPriceMin, numberForMeanPriceMax);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByMeanQuantity")
    public List<ProductDTO> getProductListByMeanQuantity(@RequestParam Double meanQuantity) {
        List<Product> productList = productService.getProductListByMeanQuantity(meanQuantity);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByMeanQuantityBetween")
    public List<ProductDTO> getProductListByMeanQuantityBetween(@RequestParam Double meanQuantityMin, @RequestParam Double meanQuantityMax) {
        List<Product> productList = productService.getProductListByMeanQuantityBetween(meanQuantityMin, meanQuantityMax);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByMeanUnitPrice")
    public List<ProductDTO> getProductListByMeanUnitPrice(@RequestParam Double meanUnitPrice) {
        List<Product> productList = productService.getProductListByMeanUnitPrice(meanUnitPrice);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByMeanUnitPriceBetween")
    public List<ProductDTO> getProductListByMeanUnitPriceBetween(@RequestParam Double meanUnitPriceMin, @RequestParam Double meanUnitPriceMax) {
        List<Product> productList = productService.getProductListByMeanUnitPriceBetween(meanUnitPriceMin, meanUnitPriceMax);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductByCreatedDate")
    public ProductDTO getProductByCreatedDate(@RequestParam String createdDate) {
        Product product = productService.getProductByCreatedDate(createdDate);
        return productDTOMapper.productToProductDTO(product);
    }

    @GetMapping("/getProductListByCreatedDateBetween")
    public List<ProductDTO> getProductListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Product> productList = productService.getProductListByCreatedDateBetween(createdDateMin, createdDateMax);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByUserId")
    public List<ProductDTO> getProductListByUserId(@RequestParam Long userId) {
        List<Product> productList = productService.getProductListByUserId(userId);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByTagId")
    public List<ProductDTO> getProductListByTagId(@RequestParam Long tagId) {
        List<Product> productList = productService.getProductListByTagId(tagId);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByReminderId")
    public List<ProductDTO> getProductListByReminderId(@RequestParam Long reminderId) {
        List<Product> productList = productService.getProductListByReminderId(reminderId);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByTopicId")
    public List<ProductDTO> getProductListByTopicId(@RequestParam Long topicId) {
        List<Product> productList = productService.getProductListByTopicId(topicId);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByTasksId")
    public List<ProductDTO> getProductListByTasksId(@RequestParam Long tasksId) {
        List<Product> productList = productService.getProductListByTasksId(tasksId);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    @GetMapping("/getProductListByExpenseId")
    public List<ProductDTO> getProductListByExpenseId(@RequestParam Long expenseId) {
        List<Product> productList = productService.getProductListByExpenseId(expenseId);
        return productDTOMapper.productListToProductDTOList(productList);
    }

    //--- Other


}
