package com.app.FO.controller;

import com.app.FO.mapper.dto.address.AddressDTO;
import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.mappers.AddressDTOMapper;
import com.app.FO.model.address.Address;
import com.app.FO.service.address.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    private AddressService addressService;

    private AddressDTOMapper addressDTOMapper;

    @Autowired
    public AddressController(AddressService addressService, AddressDTOMapper addressDTOMapper) {
        this.addressService = addressService;
        this.addressDTOMapper = addressDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewAddress")
    public AddressDTO postNewAddress(@RequestBody TextDTO noteText) {
        Address address = addressService.postAddress(noteText.getText());
        return addressDTOMapper.addressToAddressDTO(address);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToAddress")
    public AddressDTO putSubjectToAddress(@RequestParam Long addressId, @RequestParam String subject) {
        Address address = addressService.putSubjectToAddress(addressId, subject);
        return addressDTOMapper.addressToAddressDTO(address);
    }


    //-- PutMapping
    @PutMapping("/putGoogleLocationToAddress")
    public AddressDTO putGoogleLocationToAddress(@RequestParam Long addressId, @RequestParam String googleLocation) {
        Address address = addressService.putGoogleLocationToAddress(addressId, googleLocation);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @PutMapping("/putUserToAddress")
    public AddressDTO putUserToAddress(@RequestParam Long addressId, @RequestParam Long userId) {
        Address address = addressService.putUserToAddress(addressId, userId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @PutMapping("/putTagToAddress")
    public AddressDTO putTagToAddress(@RequestParam Long addressId, @RequestParam Long tagId) {
        Address address = addressService.putTagToAddress(addressId, tagId);
        return addressDTOMapper.addressToAddressDTO(address);
    }


    @PutMapping("/putReminderToAddress")
    public AddressDTO putReminderToAddress(@RequestParam Long addressId, @RequestParam Long reminderId) {
        Address address = addressService.putReminderToAddress(addressId, reminderId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @PutMapping("/putTopicToAddress")
    public AddressDTO putTopicToAddress(@RequestParam Long addressId, @RequestParam Long topicId) {
        Address address = addressService.putTopicToAddress(addressId, topicId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @PutMapping("/putTasksToAddress")
    public AddressDTO putTasksToAddress(@RequestParam Long addressId, @RequestParam Long tasksId) {
        Address address = addressService.putTasksToAddress(addressId, tasksId);
        return addressDTOMapper.addressToAddressDTO(address);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromAddress")
    public AddressDTO deleteRoleFromAddress(@RequestParam Long addressId, @RequestParam Long userId) {
        Address address = addressService.deleteUserFromAddress(addressId, userId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @DeleteMapping("/deleteTagFromAddress")
    public AddressDTO deleteTagFromAddress(@RequestParam Long addressId, @RequestParam Long tagId) {
        Address address = addressService.deleteTagFromAddress(addressId, tagId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @DeleteMapping("/deleteReminderFromAddress")
    public AddressDTO deleteReminderFromAddress(@RequestParam Long addressId, @RequestParam Long reminderId) {
        Address address = addressService.deleteReminderFromAddress(addressId, reminderId);
        return addressDTOMapper.addressToAddressDTO(address);
    }


    @DeleteMapping("/deleteTopicFromAddress")
    public AddressDTO deleteTopicFromAddress(@RequestParam Long addressId, @RequestParam Long topicId) {
        Address address = addressService.deleteTopicFromAddress(addressId, topicId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @DeleteMapping("/deleteTasksFromAddress")
    public AddressDTO deleteTasksFromAddress(@RequestParam Long addressId, @RequestParam Long tasksId) {
        Address address = addressService.deleteTasksFromAddress(addressId, tasksId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @DeleteMapping("/deleteAddress")
    public List<AddressDTO> deleteAddress(@RequestParam Long addressId) {
        List<Address> addressList = addressService.deleteAddress(addressId);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }


    //---GetMapping

    @GetMapping("/getAllAddress")
    public List<AddressDTO> getAllAddress() {
        List<Address> addressList = addressService.getAllAddress();
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressById")
    public AddressDTO getAddressById(@RequestParam Long addressId) {
        Address address = addressService.getAddressByAddressId(addressId);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @GetMapping("/getAddressBySubject")
    public AddressDTO getAddressBySubject(@RequestParam String subject) {
        Address address = addressService.getAddressBySubject(subject);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @GetMapping("/getAddressListBySubjectContains")
    public List<AddressDTO> getAddressListBySubjectContains(@RequestParam String subjectContain) {
        List<Address> addressList = addressService.getAddressListBySubjectContains(subjectContain);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressByGoogleLocation")
    public AddressDTO getAddressByGoogleLocation(@RequestParam String googleLocation) {
        Address address = addressService.getAddressByGoogleLocation(googleLocation);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @GetMapping("/getAddressListByGoogleLocationContains")
    public List<AddressDTO> getAddressListByGoogleLocationContains(@RequestParam String googleLocationContain) {
        List<Address> addressList = addressService.getAddressListByGoogleLocationContains(googleLocationContain);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public AddressDTO getAddressByCreatedDate(@RequestParam String createdDate) {
        Address address = addressService.getAddressByCreatedDate(createdDate);
        return addressDTOMapper.addressToAddressDTO(address);
    }

    @GetMapping("/getAddressListByCreatedDateBetween")
    public List<AddressDTO> getAddressListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Address> addressList = addressService.getAddressListByCreatedDateBetween(createdDateMin, createdDateMax);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressListByUserId")
    public List<AddressDTO> getAddressListByUserId(@RequestParam Long userId) {
        List<Address> addressList = addressService.getAddressListByUserId(userId);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressListByTagId")
    public List<AddressDTO> getAddressListByTagId(@RequestParam Long tagId) {
        List<Address> addressList = addressService.getAddressListByTagId(tagId);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressListByReminderId")
    public List<AddressDTO> getAddressListByReminderId(@RequestParam Long reminderId) {
        List<Address> addressList = addressService.getAddressListByReminderId(reminderId);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressListByTopicId")
    public List<AddressDTO> getAddressListByTopicId(@RequestParam Long topicId) {
        List<Address> addressList = addressService.getAddressListByTopicId(topicId);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }

    @GetMapping("/getAddressListByTasksId")
    public List<AddressDTO> getAddressListByTasksId(@RequestParam Long tasksId) {
        List<Address> addressList = addressService.getAddressListByTasksId(tasksId);
        return addressDTOMapper.addressListToAddressDTOList(addressList);
    }


    //--- Other


}
