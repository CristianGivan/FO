package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.shop.ShopDTO;
import com.app.FO.mapper.mappers.ShopDTOMapper;
import com.app.FO.model.shop.Shop;
import com.app.FO.service.shop.ShopService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {
    private ShopService shopService;

    private ShopDTOMapper shopDTOMapper;

    @Autowired
    public ShopController(ShopService shopService, ShopDTOMapper shopDTOMapper) {
        this.shopService = shopService;
        this.shopDTOMapper = shopDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewShop")
    public ShopDTO postNewShop(@RequestBody TextDTO noteText) {
        Shop shop = shopService.postShop(noteText.getText());
        return shopDTOMapper.shopToShopDTO(shop);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToShop")
    public ShopDTO putSubjectToShop(@RequestParam Long shopId, @RequestParam String subject) {
        Shop shop = shopService.putSubjectToShop(shopId, subject);
        return shopDTOMapper.shopToShopDTO(shop);
    }


    //-- PutMapping
    @PutMapping("/putNameToShop")
    public ShopDTO putNameToShop(@RequestParam Long shopId, @RequestParam String name) {
        Shop shop = shopService.putNameToShop(shopId, name);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @PutMapping("/putUserToShop")
    public ShopDTO putUserToShop(@RequestParam Long shopId, @RequestParam Long userId) {
        Shop shop = shopService.putUserToShop(shopId, userId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @PutMapping("/putTagToShop")
    public ShopDTO putTagToShop(@RequestParam Long shopId, @RequestParam Long tagId) {
        Shop shop = shopService.putTagToShop(shopId, tagId);
        return shopDTOMapper.shopToShopDTO(shop);
    }


    @PutMapping("/putReminderToShop")
    public ShopDTO putReminderToShop(@RequestParam Long shopId, @RequestParam Long reminderId) {
        Shop shop = shopService.putReminderToShop(shopId, reminderId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @PutMapping("/putTopicToShop")
    public ShopDTO putTopicToShop(@RequestParam Long shopId, @RequestParam Long topicId) {
        Shop shop = shopService.putTopicToShop(shopId, topicId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @PutMapping("/putTasksToShop")
    public ShopDTO putTasksToShop(@RequestParam Long shopId, @RequestParam Long tasksId) {
        Shop shop = shopService.putTasksToShop(shopId, tasksId);
        return shopDTOMapper.shopToShopDTO(shop);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromShop")
    public ShopDTO deleteRoleFromShop(@RequestParam Long shopId, @RequestParam Long userId) {
        Shop shop = shopService.deleteUserFromShop(shopId, userId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @DeleteMapping("/deleteTagFromShop")
    public ShopDTO deleteTagFromShop(@RequestParam Long shopId, @RequestParam Long tagId) {
        Shop shop = shopService.deleteTagFromShop(shopId, tagId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @DeleteMapping("/deleteReminderFromShop")
    public ShopDTO deleteReminderFromShop(@RequestParam Long shopId, @RequestParam Long reminderId) {
        Shop shop = shopService.deleteReminderFromShop(shopId, reminderId);
        return shopDTOMapper.shopToShopDTO(shop);
    }


    @DeleteMapping("/deleteTopicFromShop")
    public ShopDTO deleteTopicFromShop(@RequestParam Long shopId, @RequestParam Long topicId) {
        Shop shop = shopService.deleteTopicFromShop(shopId, topicId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @DeleteMapping("/deleteTasksFromShop")
    public ShopDTO deleteTasksFromShop(@RequestParam Long shopId, @RequestParam Long tasksId) {
        Shop shop = shopService.deleteTasksFromShop(shopId, tasksId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @DeleteMapping("/deleteShop")
    public List<ShopDTO> deleteShop(@RequestParam Long shopId) {
        List<Shop> shopList = shopService.deleteShop(shopId);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }


    //---GetMapping

    @GetMapping("/getAllShop")
    public List<ShopDTO> getAllShop() {
        List<Shop> shopList = shopService.getAllShop();
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopById")
    public ShopDTO getShopById(@RequestParam Long shopId) {
        Shop shop = shopService.getShopByShopId(shopId);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @GetMapping("/getShopBySubject")
    public ShopDTO getShopBySubject(@RequestParam String subject) {
        Shop shop = shopService.getShopBySubject(subject);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @GetMapping("/getShopListBySubjectContains")
    public List<ShopDTO> getShopListBySubjectContains(@RequestParam String subjectContain) {
        List<Shop> shopList = shopService.getShopListBySubjectContains(subjectContain);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopByName")
    public ShopDTO getShopByName(@RequestParam String name) {
        Shop shop = shopService.getShopByName(name);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @GetMapping("/getShopListByNameContains")
    public List<ShopDTO> getShopListByNameContains(@RequestParam String nameContain) {
        List<Shop> shopList = shopService.getShopListByNameContains(nameContain);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public ShopDTO getShopByCreatedDate(@RequestParam String createdDate) {
        Shop shop = shopService.getShopByCreatedDate(createdDate);
        return shopDTOMapper.shopToShopDTO(shop);
    }

    @GetMapping("/getShopListByCreatedDateBetween")
    public List<ShopDTO> getShopListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Shop> shopList = shopService.getShopListByCreatedDateBetween(createdDateMin, createdDateMax);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopListByUserId")
    public List<ShopDTO> getShopListByUserId(@RequestParam Long userId) {
        List<Shop> shopList = shopService.getShopListByUserId(userId);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopListByTagId")
    public List<ShopDTO> getShopListByTagId(@RequestParam Long tagId) {
        List<Shop> shopList = shopService.getShopListByTagId(tagId);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopListByReminderId")
    public List<ShopDTO> getShopListByReminderId(@RequestParam Long reminderId) {
        List<Shop> shopList = shopService.getShopListByReminderId(reminderId);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopListByTopicId")
    public List<ShopDTO> getShopListByTopicId(@RequestParam Long topicId) {
        List<Shop> shopList = shopService.getShopListByTopicId(topicId);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }

    @GetMapping("/getShopListByTasksId")
    public List<ShopDTO> getShopListByTasksId(@RequestParam Long tasksId) {
        List<Shop> shopList = shopService.getShopListByTasksId(tasksId);
        return shopDTOMapper.shopListToShopDTOList(shopList);
    }


    //--- Other


}
