package com.app.FO.service.shop;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.shop.*;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.shop.ShopRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShopService {
    private ShopRepository shopRepository;

    private ServiceAll serviceAll;

    @Autowired
    public ShopService(ShopRepository shopRepository, ServiceAll serviceAll) {
        this.shopRepository = shopRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Shop postShop(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdBySubject(logInUser.getId(), subject);
        if (shop != null) {
            throw new ShopAlreadyExistException("Shop with this subject already exist");
        }

        shop = shopRepository.save(new Shop(subject, logInUser));

        ShopUser shopUser = new ShopUser(shop, logInUser);
        shop.getShopUserList().add(shopUser);

        return shopRepository.save(shop);
    }

    //-- Put
    public Shop putSubjectToShop(Long shopId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        if (shop.getSubject().equals(subject)) {
            throw new ShopAlreadyExistException("Shop has already the same subject");
        }

        shop.setSubject(subject);

        return shopRepository.save(shop);
    }

    public Shop putNameToShop(Long shopId, String name) {
        User logInUser = serviceAll.getLogInUser();
        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        if (shop.getName().equals(name)) {
            throw new ShopAlreadyExistException("Shop has already the same name");
        }

        shop.setName(name);

        return shopRepository.save(shop);
    }

    public Shop putUserToShop(Long shopId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ShopUser shopUser = serviceAll.getShopUser(shopId, userId);
        if (shopUser != null) {
            throw new ShopUserAlreadyExistException("The shop already has the user");
        }

        shopUser = new ShopUser(shop, user);
        shop.getShopUserList().add(shopUser);

        return shopRepository.save(shop);
    }

    public Shop putTagToShop(Long shopId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ShopTag shopTag = serviceAll.getShopTag(shopId, tagId);
        if (shopTag != null) {
            throw new ShopTagAlreadyExistException("The shop already has the tag");
        }

        shopTag = new ShopTag(shop, tag);
        shop.getShopTagList().add(shopTag);

        return shopRepository.save(shop);
    }


    public Shop putReminderToShop(Long shopId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ShopReminder shopReminder = serviceAll.getShopReminder(shopId, reminderId);
        if (shopReminder != null) {
            throw new ShopReminderAlreadyExistException("The shop already has the reminder");
        }

        shopReminder = new ShopReminder(shop, reminder);
        shop.getShopReminderList().add(shopReminder);

        return shopRepository.save(shop);
    }

    public Shop putTopicToShop(Long shopId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ShopTopic shopTopic = serviceAll.getShopTopic(shopId, topicId);
        if (shopTopic != null) {
            throw new ShopTopicAlreadyExistException("The shop already has the topic");
        }

        shopTopic = new ShopTopic(shop, topic);
        shop.getShopTopicList().add(shopTopic);
        return shopRepository.save(shop);
    }

    public Shop putTasksToShop(Long shopId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ShopTasks shopTasks = serviceAll.getShopTasks(shopId, tasksId);
        if (shopTasks != null) {
            throw new ShopTasksAlreadyExistException("The shop already has the tasks");
        }

        shopTasks = new ShopTasks(shop, tasks);
        shop.getShopTasksList().add(shopTasks);
        return shopRepository.save(shop);
    }


    //--Delete


    public Shop deleteUserFromShop(Long shopId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ShopUser shopUser = serviceAll.getShopUser(shopId, userId);
        if (shopUser == null) {
            throw new ShopUserNotFoundException("The shop don't has the user");
        }
        shop.getShopUserList().remove(shopUser);

        return shopRepository.save(shop);
    }

    public Shop deleteTagFromShop(Long shopId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ShopTag shopTag = serviceAll.getShopTag(shopId, tagId);
        if (shopTag == null) {
            throw new ShopTagNotFoundException("The shop don't has the tag");
        }

        shop.getShopTagList().remove(shopTag);

        return shopRepository.save(shop);
    }

    public Shop deleteReminderFromShop(Long shopId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ShopReminder shopReminder = serviceAll.getShopReminder(shopId, reminderId);
        if (shopReminder == null) {
            throw new ShopReminderNotFoundException("The shop don't has the reminder");
        }

        shop.getShopReminderList().remove(shopReminder);

        return shopRepository.save(shop);
    }

    public Shop deleteTopicFromShop(Long shopId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ShopTopic shopTopic = serviceAll.getShopTopic(shopId, topicId);
        if (shopTopic == null) {
            throw new ShopTasksNotFoundException("The shop don't has the topic");
        }

        shop.getShopTopicList().remove(shopTopic);

        return shopRepository.save(shop);
    }

    public Shop deleteTasksFromShop(Long shopId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ShopTasks shopTasks = serviceAll.getShopTasks(shopId, tasksId);
        if (shopTasks == null) {
            throw new ShopTasksNotFoundException("The shop don't has the tasks");
        }

        shop.getShopTasksList().remove(shopTasks);

        return shopRepository.save(shop);
    }

    public List<Shop> deleteShop(Long shopId) {
        User logInUser = serviceAll.getLogInUser();

        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found in your list");
        }
        shopRepository.delete(shop);
        return getAllShop();
    }
    //-- GET


    public List<Shop> getAllShop() {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserId(logInUser.getId());
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public Shop getShopByShopId(Long shopId) {
        User logInUser = serviceAll.getLogInUser();
        Shop shop = shopRepository.getShopFromUserIdByShopId(logInUser.getId(), shopId);
        if (shop == null) {
            throw new ShopNotFoundException("No shop found");
        }
        return shop;
    }

    public Shop getShopBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Shop shop = shopRepository.getShopFromUserIdBySubject(logInUser.getId(), subject);
        if (shop == null) {
            throw new ShopNotFoundException("No shop found");
        }
        return shop;
    }

    public List<Shop> getShopListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListBySubjectContains(logInUser.getId(), subjectContains);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public Shop getShopByName(String name) {
        User logInUser = serviceAll.getLogInUser();
        Shop shop = shopRepository.getShopFromUserIdByName(logInUser.getId(), name);
        if (shop == null) {
            throw new ShopNotFoundException("No shop found");
        }
        return shop;
    }

    public List<Shop> getShopListByNameContains(String nameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListByNameContains(logInUser.getId(), nameContains);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public Shop getShopByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Shop shop = shopRepository.getShopFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (shop == null) {
            throw new ShopNotFoundException("No shop found");
        }
        return shop;
    }

    public List<Shop> getShopListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public List<Shop> getShopListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserIdByUserId(logInUser.getId(), userId);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public List<Shop> getShopListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserIdByTagId(logInUser.getId(), tagId);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public List<Shop> getShopListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public List<Shop> getShopListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    public List<Shop> getShopListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Shop> shopList = shopRepository.getShopListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (shopList.isEmpty()) {
            throw new ShopNotFoundException("No shop found");
        }
        return shopList;
    }

    //-- Other


}
