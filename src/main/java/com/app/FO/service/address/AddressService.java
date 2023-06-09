package com.app.FO.service.address;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.address.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.address.AddressRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    private ServiceAll serviceAll;

    @Autowired
    public AddressService(AddressRepository addressRepository, ServiceAll serviceAll) {
        this.addressRepository = addressRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Address postAddress(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdBySubject(logInUser.getId(), subject);
        if (address != null) {
            throw new AddressAlreadyExistException("Address with this subject already exist");
        }

        address = addressRepository.save(new Address(subject, logInUser));

        AddressUser addressUser = new AddressUser(address, logInUser);
        address.getAddressUserList().add(addressUser);

        return addressRepository.save(address);
    }

    //-- Put
    public Address putSubjectToAddress(Long addressId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        if (address.getSubject().equals(subject)) {
            throw new AddressAlreadyExistException("Address has already the same subject");
        }

        address.setSubject(subject);

        return addressRepository.save(address);
    }

    public Address putReferenceToAddress(Long addressId, String reference) {
        User logInUser = serviceAll.getLogInUser();
        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        if (address.getReference().equals(reference)) {
            throw new AddressAlreadyExistException("Address has already the same reference");
        }

        address.setReference(reference);

        return addressRepository.save(address);
    }

    public Address putUserToAddress(Long addressId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        AddressUser addressUser = serviceAll.getAddressUser(addressId, userId);
        if (addressUser != null) {
            throw new AddressUserAlreadyExistException("The address already has the user");
        }

        addressUser = new AddressUser(address, user);
        address.getAddressUserList().add(addressUser);

        return addressRepository.save(address);
    }

    public Address putTagToAddress(Long addressId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        AddressTag addressTag = serviceAll.getAddressTag(addressId, tagId);
        if (addressTag != null) {
            throw new AddressTagAlreadyExistException("The address already has the tag");
        }

        addressTag = new AddressTag(address, tag);
        address.getAddressTagList().add(addressTag);

        return addressRepository.save(address);
    }


    public Address putReminderToAddress(Long addressId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        AddressReminder addressReminder = serviceAll.getAddressReminder(addressId, reminderId);
        if (addressReminder != null) {
            throw new AddressReminderAlreadyExistException("The address already has the reminder");
        }

        addressReminder = new AddressReminder(address, reminder);
        address.getAddressReminderList().add(addressReminder);

        return addressRepository.save(address);
    }

    public Address putTopicToAddress(Long addressId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        AddressTopic addressTopic = serviceAll.getAddressTopic(addressId, topicId);
        if (addressTopic != null) {
            throw new AddressTopicAlreadyExistException("The address already has the topic");
        }

        addressTopic = new AddressTopic(address, topic);
        address.getAddressTopicList().add(addressTopic);
        return addressRepository.save(address);
    }

    public Address putTasksToAddress(Long addressId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        AddressTasks addressTasks = serviceAll.getAddressTasks(addressId, tasksId);
        if (addressTasks != null) {
            throw new AddressTasksAlreadyExistException("The address already has the tasks");
        }

        addressTasks = new AddressTasks(address, tasks);
        address.getAddressTasksList().add(addressTasks);
        return addressRepository.save(address);
    }


    //--Delete


    public Address deleteUserFromAddress(Long addressId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        AddressUser addressUser = serviceAll.getAddressUser(addressId, userId);
        if (addressUser == null) {
            throw new AddressUserNotFoundException("The address don't has the user");
        }
        address.getAddressUserList().remove(addressUser);

        return addressRepository.save(address);
    }

    public Address deleteTagFromAddress(Long addressId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        AddressTag addressTag = serviceAll.getAddressTag(addressId, tagId);
        if (addressTag == null) {
            throw new AddressTagNotFoundException("The address don't has the tag");
        }

        address.getAddressTagList().remove(addressTag);

        return addressRepository.save(address);
    }

    public Address deleteReminderFromAddress(Long addressId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        AddressReminder addressReminder = serviceAll.getAddressReminder(addressId, reminderId);
        if (addressReminder == null) {
            throw new AddressReminderNotFoundException("The address don't has the reminder");
        }

        address.getAddressReminderList().remove(addressReminder);

        return addressRepository.save(address);
    }

    public Address deleteTopicFromAddress(Long addressId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        AddressTopic addressTopic = serviceAll.getAddressTopic(addressId, topicId);
        if (addressTopic == null) {
            throw new AddressTasksNotFoundException("The address don't has the topic");
        }

        address.getAddressTopicList().remove(addressTopic);

        return addressRepository.save(address);
    }

    public Address deleteTasksFromAddress(Long addressId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        AddressTasks addressTasks = serviceAll.getAddressTasks(addressId, tasksId);
        if (addressTasks == null) {
            throw new AddressTasksNotFoundException("The address don't has the tasks");
        }

        address.getAddressTasksList().remove(addressTasks);

        return addressRepository.save(address);
    }

    public List<Address> deleteAddress(Long addressId) {
        User logInUser = serviceAll.getLogInUser();

        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found in your list");
        }
        addressRepository.delete(address);
        return getAllAddress();
    }
    //-- GET


    public List<Address> getAllAddress() {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserId(logInUser.getId());
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public Address getAddressByAddressId(Long addressId) {
        User logInUser = serviceAll.getLogInUser();
        Address address = addressRepository.getAddressFromUserIdByAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("No address found");
        }
        return address;
    }

    public Address getAddressBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Address address = addressRepository.getAddressFromUserIdBySubject(logInUser.getId(), subject);
        if (address == null) {
            throw new AddressNotFoundException("No address found");
        }
        return address;
    }

    public List<Address> getAddressListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListBySubjectContains(logInUser.getId(), subjectContains);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public Address getAddressByReference(String reference) {
        User logInUser = serviceAll.getLogInUser();
        Address address = addressRepository.getAddressFromUserIdByReference(logInUser.getId(), reference);
        if (address == null) {
            throw new AddressNotFoundException("No address found");
        }
        return address;
    }

    public List<Address> getAddressListByReferenceContains(String referenceContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListByReferenceContains(logInUser.getId(), referenceContains);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public Address getAddressByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Address address = addressRepository.getAddressFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (address == null) {
            throw new AddressNotFoundException("No address found");
        }
        return address;
    }

    public List<Address> getAddressListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public List<Address> getAddressListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserIdByUserId(logInUser.getId(), userId);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public List<Address> getAddressListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserIdByTagId(logInUser.getId(), tagId);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public List<Address> getAddressListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public List<Address> getAddressListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    public List<Address> getAddressListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Address> addressList = addressRepository.getAddressListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (addressList.isEmpty()) {
            throw new AddressNotFoundException("No address found");
        }
        return addressList;
    }

    //-- Other


}
