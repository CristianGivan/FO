package com.app.FO.service.product;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.product.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    private ServiceAll serviceAll;

    @Autowired
    public ProductService(ProductRepository productRepository, ServiceAll serviceAll) {
        this.productRepository = productRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Product postProduct(String name, String unit) {
        User logInUser = serviceAll.getLogInUser();
        String subject = name + " from " + unit;
        Product product = productRepository.getProductFromUserIdBySubject(logInUser.getId(), subject);
        if (product != null) {
            throw new ProductAlreadyExistException("Product with this subject already exist");
        }

        product = productRepository.save(new Product(name, unit, logInUser));

        ProductUser productUser = new ProductUser(product, logInUser);
        product.getProductUserList().add(productUser);

        return productRepository.save(product);
    }

    //-- Put
    public Product putNameToProduct(Long productId, String name) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        String subject = name + " from " + product.getProducer();
        if (product.getSubject().equals(subject)) {
            throw new ProductAlreadyExistException("Product has already the same subject");
        }

        product.setName(name);
        product.setSubject(subject);

        return productRepository.save(product);
    }

    public Product putUnitToProduct(Long productId, String unit) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        String subject = unit + " from " + product.getProducer();
        if (product.getSubject().equals(subject)) {
            throw new ProductAlreadyExistException("Product has already the same subject");
        }

        product.setUnit(unit);
        product.setSubject(subject);

        return productRepository.save(product);
    }

    public Product putProducerToProduct(Long productId, String producer) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        String subject = product.getName() + " from " + producer;
        if (product.getSubject().equals(subject)) {
            throw new ProductAlreadyExistException("Product has already the same subject");
        }

        product.setProducer(producer);
        product.setSubject(subject);

        return productRepository.save(product);
    }

    public Product putCategoryToProduct(Long productId, String category) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        product.setCategory(category);

        return productRepository.save(product);
    }


    public Product putUserToProduct(Long productId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ProductUser productUser = serviceAll.getProductUser(productId, userId);
        if (productUser != null) {
            throw new ProductUserAlreadyExistException("The product already has the user");
        }

        productUser = new ProductUser(product, user);
        product.getProductUserList().add(productUser);

        return productRepository.save(product);
    }

    public Product putTagToProduct(Long productId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ProductTag productTag = serviceAll.getProductTag(productId, tagId);
        if (productTag != null) {
            throw new ProductTagAlreadyExistException("The product already has the tag");
        }

        productTag = new ProductTag(product, tag);
        product.getProductTagList().add(productTag);

        return productRepository.save(product);
    }


    public Product putReminderToProduct(Long productId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ProductReminder productReminder = serviceAll.getProductReminder(productId, reminderId);
        if (productReminder != null) {
            throw new ProductReminderAlreadyExistException("The product already has the reminder");
        }

        productReminder = new ProductReminder(product, reminder);
        product.getProductReminderList().add(productReminder);

        return productRepository.save(product);
    }

    public Product putTopicToProduct(Long productId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ProductTopic productTopic = serviceAll.getProductTopic(productId, topicId);
        if (productTopic != null) {
            throw new ProductTopicAlreadyExistException("The product already has the topic");
        }

        productTopic = new ProductTopic(product, topic);
        product.getProductTopicList().add(productTopic);
        return productRepository.save(product);
    }

    public Product putTasksToProduct(Long productId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ProductTasks productTasks = serviceAll.getProductTasks(productId, tasksId);
        if (productTasks != null) {
            throw new ProductTasksAlreadyExistException("The product already has the tasks");
        }

        productTasks = new ProductTasks(product, tasks);
        product.getProductTasksList().add(productTasks);
        return productRepository.save(product);
    }

    public Product putExpenseToProduct(Long productId, Long expenseId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Expense expense = serviceAll.getExpenseFromUserIdAndExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found");
        }

        product.getExpenseList().add(expense);
        return productRepository.save(product);
    }


    //--Delete


    public Product deleteUserFromProduct(Long productId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ProductUser productUser = serviceAll.getProductUser(productId, userId);
        if (productUser == null) {
            throw new ProductUserNotFoundException("The product don't has the user");
        }
        product.getProductUserList().remove(productUser);

        return productRepository.save(product);
    }

    public Product deleteTagFromProduct(Long productId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ProductTag productTag = serviceAll.getProductTag(productId, tagId);
        if (productTag == null) {
            throw new ProductTagNotFoundException("The product don't has the tag");
        }

        product.getProductTagList().remove(productTag);

        return productRepository.save(product);
    }

    public Product deleteReminderFromProduct(Long productId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ProductReminder productReminder = serviceAll.getProductReminder(productId, reminderId);
        if (productReminder == null) {
            throw new ProductReminderNotFoundException("The product don't has the reminder");
        }

        product.getProductReminderList().remove(productReminder);

        return productRepository.save(product);
    }

    public Product deleteTopicFromProduct(Long productId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ProductTopic productTopic = serviceAll.getProductTopic(productId, topicId);
        if (productTopic == null) {
            throw new ProductTasksNotFoundException("The product don't has the topic");
        }

        product.getProductTopicList().remove(productTopic);

        return productRepository.save(product);
    }

    public Product deleteTasksFromProduct(Long productId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ProductTasks productTasks = serviceAll.getProductTasks(productId, tasksId);
        if (productTasks == null) {
            throw new ProductTasksNotFoundException("The product don't has the tasks");
        }

        product.getProductTasksList().remove(productTasks);

        return productRepository.save(product);
    }

    public Product deleteExpenseFromProduct(Long productId, Long expenseId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }

        Expense expense = serviceAll.getExpenseFromUserIdAndExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found");
        }

        product.getExpenseList().remove(expense);

        return productRepository.save(product);
    }

    public List<Product> deleteProduct(Long productId) {
        User logInUser = serviceAll.getLogInUser();

        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found in your list");
        }
        productRepository.delete(product);
        return getAllProduct();
    }
    //-- GET


    public List<Product> getAllProduct() {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserId(logInUser.getId());
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public Product getProductByProductId(Long productId) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }


    public Product getProductByName(String name) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByName(logInUser.getId(), name);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByNameContains(String nameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListByNameContains(logInUser.getId(), nameContains);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public Product getProductByUnit(String unit) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByUnit(logInUser.getId(), unit);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByUnitContains(String unitContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListByUnitContains(logInUser.getId(), unitContains);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public Product getProductByProducer(String producer) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByProducer(logInUser.getId(), producer);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByProducerContains(String producerContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListByProducerContains(logInUser.getId(), producerContains);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public Product getProductBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdBySubject(logInUser.getId(), subject);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListBySubjectContains(logInUser.getId(), subjectContains);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }


    public Product getProductByCategory(String category) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByCategory(logInUser.getId(), category);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByCategoryContains(String categoryContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListByCategoryContains(logInUser.getId(), categoryContains);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public Product getProductByNumberOfBuys(Integer numberOfBuys) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByNumberOfBuys(logInUser.getId(), numberOfBuys);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByNumberOfBuysBetween(Integer numberOfBuysMin, Integer numberOfBuysMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByNumberOfBuysBetween(logInUser.getId(), numberOfBuysMin, numberOfBuysMax);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }


    public Product getProductByNumberForMeanQuantity(Integer numberForMeanQuantity) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByNumberForMeanQuantity(logInUser.getId(), numberForMeanQuantity);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByNumberForMeanQuantityBetween(Integer numberForMeanQuantityMin, Integer numberForMeanQuantityMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByNumberForMeanQuantityBetween(logInUser.getId(), numberForMeanQuantityMin, numberForMeanQuantityMax);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public Product getProductByNumberForMeanPrice(Integer numberForMeanPrice) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByNumberForMeanPrice(logInUser.getId(), numberForMeanPrice);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByNumberForMeanPriceBetween(Integer numberForMeanPriceMin, Integer numberForMeanPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByNumberForMeanPriceBetween(logInUser.getId(), numberForMeanPriceMin, numberForMeanPriceMax);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }


    public Product getProductByMeanQuantity(Double meanQuantity) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByMeanQuantity(logInUser.getId(), meanQuantity);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByMeanQuantityBetween(Double meanQuantityMin, Double meanQuantityMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByMeanQuantityBetween(logInUser.getId(), meanQuantityMin, meanQuantityMax);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }


    public Product getProductByMeanUnitPrice(Double meanUnitPrice) {
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByMeanUnitPrice(logInUser.getId(), meanUnitPrice);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByMeanUnitPriceBetween(Double meanUnitPriceMin, Double meanUnitPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByMeanUnitPriceBetween(logInUser.getId(), meanUnitPriceMin, meanUnitPriceMax);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }


    public Product getProductByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Product product = productRepository.getProductFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (product == null) {
            throw new ProductNotFoundException("No product found");
        }
        return product;
    }

    public List<Product> getProductListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }


    public List<Product> getProductListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByUserId(logInUser.getId(), userId);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public List<Product> getProductListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByTagId(logInUser.getId(), tagId);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public List<Product> getProductListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public List<Product> getProductListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public List<Product> getProductListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    public List<Product> getProductListByExpenseId(Long expenseId) {
        User logInUser = serviceAll.getLogInUser();
        List<Product> productList = productRepository.getProductListFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No product found");
        }
        return productList;
    }

    //-- Other


}
