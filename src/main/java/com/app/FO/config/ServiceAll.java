package com.app.FO.config;

import com.app.FO.model.account.*;
import com.app.FO.model.address.*;
import com.app.FO.model.dates.*;
import com.app.FO.model.document.*;
import com.app.FO.model.email.*;
import com.app.FO.model.event.*;
import com.app.FO.model.expense.*;
import com.app.FO.model.expenses.*;
import com.app.FO.model.link.*;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteReminder;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.NoteUser;
import com.app.FO.model.person.*;
import com.app.FO.model.phoneNumber.*;
import com.app.FO.model.product.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.reminder.ReminderReminder;
import com.app.FO.model.reminder.ReminderSnooze;
import com.app.FO.model.reminder.ReminderUser;
import com.app.FO.model.shop.*;
import com.app.FO.model.snooze.Snooze;
import com.app.FO.model.snooze.SnoozeUser;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tag.TagUser;
import com.app.FO.model.task.*;
import com.app.FO.model.tasks.*;
import com.app.FO.model.topic.*;
import com.app.FO.model.transaction.*;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.model.user.UserUser;
import com.app.FO.model.work.*;
import com.app.FO.repository.account.*;
import com.app.FO.repository.address.*;
import com.app.FO.repository.dates.*;
import com.app.FO.repository.document.*;
import com.app.FO.repository.email.*;
import com.app.FO.repository.event.*;
import com.app.FO.repository.expense.*;
import com.app.FO.repository.expenses.*;
import com.app.FO.repository.link.*;
import com.app.FO.repository.note.NoteReminderRepository;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.repository.note.NoteTagRepository;
import com.app.FO.repository.note.NoteUserRepository;
import com.app.FO.repository.person.*;
import com.app.FO.repository.phoneNumber.*;
import com.app.FO.repository.product.*;
import com.app.FO.repository.reminder.ReminderReminderRepository;
import com.app.FO.repository.reminder.ReminderRepository;
import com.app.FO.repository.reminder.ReminderSnoozeRepository;
import com.app.FO.repository.reminder.ReminderUserRepository;
import com.app.FO.repository.shop.*;
import com.app.FO.repository.snooze.SnoozeRepository;
import com.app.FO.repository.snooze.SnoozeUserRepository;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.repository.tag.TagUserRepository;
import com.app.FO.repository.task.*;
import com.app.FO.repository.tasks.*;
import com.app.FO.repository.topic.*;
import com.app.FO.repository.transaction.*;
import com.app.FO.repository.user.RoleRepository;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.repository.user.UserRoleRepository;
import com.app.FO.repository.user.UserUserRepository;
import com.app.FO.repository.work.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Configuration
public class ServiceAll {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserUserRepository userUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    private TagRepository tagRepository;

    @Autowired
    private TagUserRepository tagUserRepository;


    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private ReminderUserRepository reminderUserRepository;

    @Autowired
    private ReminderSnoozeRepository reminderSnoozeRepository;
    @Autowired
    private ReminderReminderRepository reminderReminderRepository;
    @Autowired
    private SnoozeRepository snoozeRepository;
    @Autowired
    private SnoozeUserRepository snoozeUserRepository;

    private NoteRepository noteRepository;
    @Autowired
    private NoteUserRepository noteUserRepository;

    @Autowired
    private NoteTagRepository noteTagRepository;

    @Autowired
    private NoteReminderRepository noteReminderRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicUserRepository topicUserRepository;
    @Autowired
    private TopicTagRepository topicTagRepository;

    @Autowired
    private TopicReminderRepository topicReminderRepository;

    @Autowired
    private TopicLinkRepository topicLinkRepository;

    @Autowired
    private TopicNoteRepository topicNoteRepository;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskUserRepository taskUserRepository;
    @Autowired
    private TaskTagRepository taskTagRepository;

    @Autowired
    private TaskReminderRepository taskReminderRepository;

    @Autowired
    private TaskTopicRepository taskTopicRepository;

    @Autowired
    private TaskWorkRepository taskWorkRepository;

    @Autowired
    private WorkRepository workRepository;

    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private TasksUserRepository tasksUserRepository;
    @Autowired
    private TasksTagRepository tasksTagRepository;

    @Autowired
    private TasksReminderRepository tasksReminderRepository;

    @Autowired
    private TasksTopicRepository tasksTopicRepository;

    @Autowired
    private TasksTaskRepository tasksTaskRepository;

    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private LinkUserRepository linkUserRepository;
    @Autowired
    private LinkTagRepository linkTagRepository;

    @Autowired
    private LinkReminderRepository linkReminderRepository;

    @Autowired
    private LinkTopicRepository linkTopicRepository;

    @Autowired
    private LinkTasksRepository linkTasksRepository;


    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressUserRepository addressUserRepository;
    @Autowired
    private AddressTagRepository addressTagRepository;

    @Autowired
    private AddressReminderRepository addressReminderRepository;

    @Autowired
    private AddressTopicRepository addressTopicRepository;

    @Autowired
    private AddressTasksRepository addressTasksRepository;


    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopUserRepository shopUserRepository;
    @Autowired
    private ShopTagRepository shopTagRepository;

    @Autowired
    private ShopReminderRepository shopReminderRepository;

    @Autowired
    private ShopTopicRepository shopTopicRepository;

    @Autowired
    private ShopTasksRepository shopTasksRepository;


    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentUserRepository documentUserRepository;
    @Autowired
    private DocumentTagRepository documentTagRepository;

    @Autowired
    private DocumentReminderRepository documentReminderRepository;

    @Autowired
    private DocumentTopicRepository documentTopicRepository;

    @Autowired
    private DocumentTasksRepository documentTasksRepository;


    @Autowired
    private WorkUserRepository workUserRepository;
    @Autowired
    private WorkTagRepository workTagRepository;

    @Autowired
    private WorkReminderRepository workReminderRepository;

    @Autowired
    private WorkTopicRepository workTopicRepository;


    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonUserRepository personUserRepository;
    @Autowired
    private PersonTagRepository personTagRepository;

    @Autowired
    private PersonReminderRepository personReminderRepository;

    @Autowired
    private PersonTopicRepository personTopicRepository;

    @Autowired
    private PersonTasksRepository personTasksRepository;

    @Autowired
    private PersonDocumentRepository personDocumentRepository;

    @Autowired
    private PersonAddressRepository personAddressRepository;

    @Autowired
    private PersonEmailRepository personEmailRepository;

    @Autowired
    private PersonPhoneNumberRepository personPhoneNumberRepository;

    @Autowired
    private PersonDatesRepository personDatesRepository;

    @Autowired
    private PersonPersonRepository personPersonRepository;


    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventUserRepository eventUserRepository;
    @Autowired
    private EventTagRepository eventTagRepository;

    @Autowired
    private EventReminderRepository eventReminderRepository;

    @Autowired
    private EventTopicRepository eventTopicRepository;

    @Autowired
    private EventTasksRepository eventTasksRepository;

    @Autowired
    private EventExpensesRepository eventExpensesRepository;

    @Autowired
    private EventPersonRepository eventPersonRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductUserRepository productUserRepository;
    @Autowired
    private ProductTagRepository productTagRepository;

    @Autowired
    private ProductReminderRepository productReminderRepository;

    @Autowired
    private ProductTopicRepository productTopicRepository;

    @Autowired
    private ProductTasksRepository productTasksRepository;

    @Autowired
    private ProductExpenseRepository productExpenseRepository;

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    private ExpenseTagRepository expenseTagRepository;

    @Autowired
    private ExpenseReminderRepository expenseReminderRepository;

    @Autowired
    private ExpenseTopicRepository expenseTopicRepository;

    @Autowired
    private ExpenseTasksRepository expenseTasksRepository;


    @Autowired
    private ExpensesRepository expensesRepository;
    @Autowired
    private ExpensesUserRepository expensesUserRepository;
    @Autowired
    private ExpensesTagRepository expensesTagRepository;

    @Autowired
    private ExpensesReminderRepository expensesReminderRepository;

    @Autowired
    private ExpensesTopicRepository expensesTopicRepository;

    @Autowired
    private ExpensesTasksRepository expensesTasksRepository;

    @Autowired
    private ExpensesExpenseRepository expensesExpenseRepository;

    @Autowired
    private ExpensesPersonRepository expensesPersonRepository;

    @Autowired
    private ExpensesShopRepository expensesShopRepository;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionUserRepository transactionUserRepository;
    @Autowired
    private TransactionTagRepository transactionTagRepository;

    @Autowired
    private TransactionReminderRepository transactionReminderRepository;

    @Autowired
    private TransactionTopicRepository transactionTopicRepository;

    @Autowired
    private TransactionTasksRepository transactionTasksRepository;

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private EmailUserRepository emailUserRepository;
    @Autowired
    private EmailTagRepository emailTagRepository;

    @Autowired
    private EmailReminderRepository emailReminderRepository;

    @Autowired
    private EmailTopicRepository emailTopicRepository;

    @Autowired
    private EmailTasksRepository emailTasksRepository;

    @Autowired
    private DatesRepository datesRepository;
    @Autowired
    private DatesUserRepository datesUserRepository;
    @Autowired
    private DatesTagRepository datesTagRepository;

    @Autowired
    private DatesReminderRepository datesReminderRepository;

    @Autowired
    private DatesTopicRepository datesTopicRepository;

    @Autowired
    private DatesTasksRepository datesTasksRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;
    @Autowired
    private PhoneNumberUserRepository phoneNumberUserRepository;
    @Autowired
    private PhoneNumberTagRepository phoneNumberTagRepository;

    @Autowired
    private PhoneNumberReminderRepository phoneNumberReminderRepository;

    @Autowired
    private PhoneNumberTopicRepository phoneNumberTopicRepository;

    @Autowired
    private PhoneNumberTasksRepository phoneNumberTasksRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountUserRepository accountUserRepository;
    @Autowired
    private AccountTagRepository accountTagRepository;

    @Autowired
    private AccountReminderRepository accountReminderRepository;

    @Autowired
    private AccountTopicRepository accountTopicRepository;

    @Autowired
    private AccountTasksRepository accountTasksRepository;

    @Autowired
    private AccountExpensesRepository accountExpensesRepository;
    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public ServiceAll(NoteRepository noteRepository, TagRepository tagRepository) {
        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
    }

    //-- getUserAnd

    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getUserByUserName(userDetails.getUsername());
    }

    public User getUserByUserId(Long userId) {
        return userRepository.getUserByUserId(userId);
    }

    public UserUser getUserUserByUserIdAndUserId(Long userId, Long userLinkedId) {
        return userUserRepository.getUserUserByUserIdAndUserId(userId, userLinkedId);
    }

    public UserRole getUserRoleByUserIdAndRoleId(Long userId, Long roleId) {
        return userRoleRepository.getUserRoleByUserIdAndRoleId(userId, roleId);
    }

    //-- getTagAnd

    public Tag getTagFromUserIdByTagId(Long userId, Long tagId) {
        return tagRepository.getTagFromUserIdByTagId(userId, tagId);

    }

    public TagUser getTagUser(Long tagId, Long userId) {
        return tagUserRepository.getTagUserByTagIdAndUserId(tagId, userId);
    }

    //-- getReminderAnd
    public Reminder getReminderFromUserIdByReminderId(Long userId, Long reminderId) {
        return reminderRepository.getReminderFromUserIdByReminderId(userId, reminderId);
    }

    public ReminderUser getReminderUser(Long reminderId, Long userId) {
        return reminderUserRepository.getReminderUserByReminderIdAndUserId(reminderId, userId);
    }


    public ReminderSnooze getReminderSnooze(Long reminderId, Long snoozeId) {
        return reminderSnoozeRepository.getReminderSnoozeByReminderIdAndSnoozeId(reminderId, snoozeId);
    }

    public ReminderReminder getReminderReminder(Long reminderId, Long repeatedReminderId) {
        return reminderReminderRepository.getReminderReminderByReminderIdAndReminderId(reminderId, repeatedReminderId);
    }

    //-- getSnoozeAnd
    public Snooze getSnoozeFromUserIdBySnoozeId(Long userId, Long snoozeId) {
        return snoozeRepository.getSnoozeFromUserIdBySnoozeId(userId, snoozeId);
    }

    public SnoozeUser getSnoozeUser(Long snoozeId, Long userId) {
        return snoozeUserRepository.getSnoozeUserBySnoozeIdAndUserId(snoozeId, userId);
    }

    //-- getNoteAnd
    public Note getNoteByIdAndUserId(Long noteId, Long userId) {
        return noteRepository.getNoteFromUserIdByNoteId(userId, noteId);
    }

    public NoteUser getNoteUser(Long noteId, Long userId) {
        return noteUserRepository.getNoteUserByNoteIdAndUserId(noteId, userId);
    }

    public NoteTag getNoteTag(Long noteId, Long tagId) {
        return noteTagRepository.getNoteTagByNoteIdAndTagId(noteId, tagId);
    }

    public NoteReminder getNoteReminder(Long noteId, Long reminderId) {
        return noteReminderRepository.getNoteReminderByNoteIdAndReminderId(noteId, reminderId);
    }

    //-- getTopicAnd

    public TopicUser getTopicUser(Long topicId, Long userId) {
        return topicUserRepository.getTopicUserByTopicIdAndUserId(topicId, userId);
    }

    public TopicTag getTopicTag(Long topicId, Long tagId) {
        return topicTagRepository.getTopicTagByTopicIdAndTagId(topicId, tagId);
    }


    public TopicReminder getTopicReminder(Long topicId, Long reminderId) {
        return topicReminderRepository.getTopicReminderByTopicIdAndReminderId(topicId, reminderId);
    }

    public TopicNote getTopicNote(Long topicId, Long NoteId) {
        return topicNoteRepository.getTopicNoteByTopicIdAndNoteId(topicId, NoteId);
    }

    public TopicLink getTopicLink(Long topicId, Long linkId) {
        return topicLinkRepository.getTopicLinkByTopicIdAndLinkId(topicId, linkId);
    }

    //-- getTaskAnd


    public Task getTaskFromUserIdAndTaskId(Long userId, Long taskId) {
        return taskRepository.getTaskFromUserIdByTaskId(userId, taskId);
    }

    public TaskUser getTaskUser(Long taskId, Long userId) {
        return taskUserRepository.getTaskUserByTaskIdAndUserId(taskId, userId);
    }

    public TaskTag getTaskTag(Long taskId, Long tagId) {
        return taskTagRepository.getTaskTagByTaskIdAndTagId(taskId, tagId);
    }

    public TaskReminder getTaskReminder(Long taskId, Long reminderId) {
        return taskReminderRepository.getTaskReminderByTaskIdAndReminderId(taskId, reminderId);
    }

    public TaskTopic getTaskTopic(Long taskId, Long topicId) {
        return taskTopicRepository.getTaskTopicByTaskIdAndTopicId(taskId, topicId);
    }

    public TaskWork getTaskWork(Long taskId, Long topicId) {
        return taskWorkRepository.getTaskWorkByTaskIdAndWorkId(taskId, topicId);
    }

    //-- getTasksAnd

    public Tasks getTasksFromUserIdAndTasksId(Long userId, Long tasksId) {
        return tasksRepository.getTasksFromUserIdByTasksId(userId, tasksId);
    }

    public TasksUser getTasksUser(Long tasksId, Long userId) {
        return tasksUserRepository.getTasksUserByTasksIdAndUserId(tasksId, userId);
    }

    public TasksTag getTasksTag(Long tasksId, Long tagId) {
        return tasksTagRepository.getTasksTagByTasksIdAndTagId(tasksId, tagId);
    }

    public TasksReminder getTasksReminder(Long tasksId, Long reminderId) {
        return tasksReminderRepository.getTasksReminderByTasksIdAndReminderId(tasksId, reminderId);
    }

    public TasksTopic getTasksTopic(Long tasksId, Long topicId) {
        return tasksTopicRepository.getTasksTopicByTasksIdAndTopicId(tasksId, topicId);
    }

    public TasksTask getTasksTask(Long tasksId, Long taskId) {
        return tasksTaskRepository.getTasksTaskByTasksIdAndTaskId(tasksId, taskId);
    }

    //-- getLinkAnd


    public Link getLinkFromUserIdAndLinkId(Long userId, Long linkId) {
        return linkRepository.getLinkFromUserIdByLinkId(userId, linkId);
    }

    public LinkUser getLinkUser(Long linkId, Long userId) {
        return linkUserRepository.getLinkUserByLinkIdAndUserId(linkId, userId);
    }

    public LinkTag getLinkTag(Long linkId, Long tagId) {
        return linkTagRepository.getLinkTagByLinkIdAndTagId(linkId, tagId);
    }

    public LinkReminder getLinkReminder(Long linkId, Long reminderId) {
        return linkReminderRepository.getLinkReminderByLinkIdAndReminderId(linkId, reminderId);
    }

    public LinkTopic getLinkTopic(Long linkId, Long topicId) {
        return linkTopicRepository.getLinkTopicByLinkIdAndTopicId(linkId, topicId);
    }

    public LinkTasks getLinkTasks(Long linkId, Long tasksId) {
        return linkTasksRepository.getLinkTasksByLinkIdAndTasksId(linkId, tasksId);
    }

    //-- getAddressAnd


    public Address getAddressFromUserIdAndAddressId(Long userId, Long addressId) {
        return addressRepository.getAddressFromUserIdByAddressId(userId, addressId);
    }

    public AddressUser getAddressUser(Long addressId, Long userId) {
        return addressUserRepository.getAddressUserByAddressIdAndUserId(addressId, userId);
    }

    public AddressTag getAddressTag(Long addressId, Long tagId) {
        return addressTagRepository.getAddressTagByAddressIdAndTagId(addressId, tagId);
    }

    public AddressReminder getAddressReminder(Long addressId, Long reminderId) {
        return addressReminderRepository.getAddressReminderByAddressIdAndReminderId(addressId, reminderId);
    }

    public AddressTopic getAddressTopic(Long addressId, Long topicId) {
        return addressTopicRepository.getAddressTopicByAddressIdAndTopicId(addressId, topicId);
    }

    public AddressTasks getAddressTasks(Long addressId, Long tasksId) {
        return addressTasksRepository.getAddressTasksByAddressIdAndTasksId(addressId, tasksId);
    }

    //-- getShopAnd


    public Shop getShopFromUserIdAndShopId(Long userId, Long shopId) {
        return shopRepository.getShopFromUserIdByShopId(userId, shopId);
    }

    public ShopUser getShopUser(Long shopId, Long userId) {
        return shopUserRepository.getShopUserByShopIdAndUserId(shopId, userId);
    }

    public ShopTag getShopTag(Long shopId, Long tagId) {
        return shopTagRepository.getShopTagByShopIdAndTagId(shopId, tagId);
    }

    public ShopReminder getShopReminder(Long shopId, Long reminderId) {
        return shopReminderRepository.getShopReminderByShopIdAndReminderId(shopId, reminderId);
    }

    public ShopTopic getShopTopic(Long shopId, Long topicId) {
        return shopTopicRepository.getShopTopicByShopIdAndTopicId(shopId, topicId);
    }

    public ShopTasks getShopTasks(Long shopId, Long tasksId) {
        return shopTasksRepository.getShopTasksByShopIdAndTasksId(shopId, tasksId);
    }

    //-- getDocumentAnd


    public Document getDocumentFromUserIdAndDocumentId(Long userId, Long documentId) {
        return documentRepository.getDocumentFromUserIdByDocumentId(userId, documentId);
    }

    public DocumentUser getDocumentUser(Long documentId, Long userId) {
        return documentUserRepository.getDocumentUserByDocumentIdAndUserId(documentId, userId);
    }

    public DocumentTag getDocumentTag(Long documentId, Long tagId) {
        return documentTagRepository.getDocumentTagByDocumentIdAndTagId(documentId, tagId);
    }

    public DocumentReminder getDocumentReminder(Long documentId, Long reminderId) {
        return documentReminderRepository.getDocumentReminderByDocumentIdAndReminderId(documentId, reminderId);
    }

    public DocumentTopic getDocumentTopic(Long documentId, Long topicId) {
        return documentTopicRepository.getDocumentTopicByDocumentIdAndTopicId(documentId, topicId);
    }

    public DocumentTasks getDocumentTasks(Long documentId, Long tasksId) {
        return documentTasksRepository.getDocumentTasksByDocumentIdAndTasksId(documentId, tasksId);
    }


//-- getWorkAnd

    public Work getWorkFromUserIdAndWorkId(Long userId, Long workId) {
        return workRepository.getWorkFromUserIdByWorkId(userId, workId);
    }

    public WorkUser getWorkUser(Long workId, Long userId) {
        return workUserRepository.getWorkUserByWorkIdAndUserId(workId, userId);
    }

    public WorkTag getWorkTag(Long workId, Long tagId) {
        return workTagRepository.getWorkTagByWorkIdAndTagId(workId, tagId);
    }

    public WorkReminder getWorkReminder(Long workId, Long reminderId) {
        return workReminderRepository.getWorkReminderByWorkIdAndReminderId(workId, reminderId);
    }

    public WorkTopic getWorkTopic(Long workId, Long topicId) {
        return workTopicRepository.getWorkTopicByWorkIdAndTopicId(workId, topicId);
    }

    //-- getPersonAnd


    public Person getPersonFromUserIdAndPersonId(Long userId, Long personId) {
        return personRepository.getPersonFromUserIdByPersonId(userId, personId);
    }

    public PersonUser getPersonUser(Long personId, Long userId) {
        return personUserRepository.getPersonUserByPersonIdAndUserId(personId, userId);
    }

    public PersonTag getPersonTag(Long personId, Long tagId) {
        return personTagRepository.getPersonTagByPersonIdAndTagId(personId, tagId);
    }

    public PersonReminder getPersonReminder(Long personId, Long reminderId) {
        return personReminderRepository.getPersonReminderByPersonIdAndReminderId(personId, reminderId);
    }

    public PersonTopic getPersonTopic(Long personId, Long topicId) {
        return personTopicRepository.getPersonTopicByPersonIdAndTopicId(personId, topicId);
    }

    public PersonTasks getPersonTasks(Long personId, Long tasksId) {
        return personTasksRepository.getPersonTasksByPersonIdAndTasksId(personId, tasksId);
    }

    public PersonDocument getPersonDocument(Long personId, Long documentId) {
        return personDocumentRepository.getPersonDocumentByPersonIdAndDocumentId(personId, documentId);
    }

    public PersonAddress getPersonAddress(Long personId, Long addressId) {
        return personAddressRepository.getPersonAddressByPersonIdAndAddressId(personId, addressId);
    }

    public PersonEmail getPersonEmail(Long personId, Long emailId) {
        return personEmailRepository.getPersonEmailByPersonIdAndEmailId(personId, emailId);
    }

    public PersonPhoneNumber getPersonPhoneNumber(Long personId, Long phoneNumberId) {
        return personPhoneNumberRepository.getPersonPhoneNumberByPersonIdAndPhoneNumberId(personId, phoneNumberId);
    }

    public PersonDates getPersonDates(Long personId, Long datesId) {
        return personDatesRepository.getPersonDatesByPersonIdAndDatesId(personId, datesId);
    }

    public PersonPerson getPersonPerson(Long personId, Long reletedPersonId) {
        return personPersonRepository.getPersonPersonByPersonIdAndPersonId(personId, reletedPersonId);
    }
    //-- getEventAnd


    public Event getEventFromUserIdAndEventId(Long userId, Long eventId) {
        return eventRepository.getEventFromUserIdByEventId(userId, eventId);
    }

    public EventUser getEventUser(Long eventId, Long userId) {
        return eventUserRepository.getEventUserByEventIdAndUserId(eventId, userId);
    }

    public EventTag getEventTag(Long eventId, Long tagId) {
        return eventTagRepository.getEventTagByEventIdAndTagId(eventId, tagId);
    }

    public EventReminder getEventReminder(Long eventId, Long reminderId) {
        return eventReminderRepository.getEventReminderByEventIdAndReminderId(eventId, reminderId);
    }

    public EventTopic getEventTopic(Long eventId, Long topicId) {
        return eventTopicRepository.getEventTopicByEventIdAndTopicId(eventId, topicId);
    }

    public EventTasks getEventTasks(Long eventId, Long tasksId) {
        return eventTasksRepository.getEventTasksByEventIdAndTasksId(eventId, tasksId);
    }

    public EventExpenses getEventExpenses(Long eventId, Long expensesId) {
        return eventExpensesRepository.getEventExpensesByEventIdAndExpensesId(eventId, expensesId);
    }

    public EventPerson getEventPerson(Long eventId, Long personId) {
        return eventPersonRepository.getEventPersonByEventIdAndPersonId(eventId, personId);
    }

    //-- getProductAnd


    public Product getProductFromUserIdAndProductId(Long userId, Long productId) {
        return productRepository.getProductFromUserIdByProductId(userId, productId);
    }

    public ProductUser getProductUser(Long productId, Long userId) {
        return productUserRepository.getProductUserByProductIdAndUserId(productId, userId);
    }

    public ProductTag getProductTag(Long productId, Long tagId) {
        return productTagRepository.getProductTagByProductIdAndTagId(productId, tagId);
    }

    public ProductReminder getProductReminder(Long productId, Long reminderId) {
        return productReminderRepository.getProductReminderByProductIdAndReminderId(productId, reminderId);
    }

    public ProductTopic getProductTopic(Long productId, Long topicId) {
        return productTopicRepository.getProductTopicByProductIdAndTopicId(productId, topicId);
    }

    public ProductTasks getProductTasks(Long productId, Long tasksId) {
        return productTasksRepository.getProductTasksByProductIdAndTasksId(productId, tasksId);
    }

    public ProductExpense getProductExpense(Long productId, Long expenseId) {
        return productExpenseRepository.getProductExpenseByProductIdAndExpenseId(productId, expenseId);
    }
    //-- getExpenseAnd

    public Expense getExpenseFromUserIdAndExpenseId(Long userId, Long expenseId) {
        return expenseRepository.getExpenseFromUserIdByExpenseId(userId, expenseId);
    }

    public Expense getExpenseFromUserIdAndExpenseIdAndProductId(Long userId, Long expenseId, Long productId) {
        return expenseRepository.getExpenseFromUserIdByExpensesIdProductId(userId, expenseId, productId);
    }

    public ExpenseUser getExpenseUser(Long expenseId, Long userId) {
        return expenseUserRepository.getExpenseUserByExpenseIdAndUserId(expenseId, userId);
    }

    public ExpenseTag getExpenseTag(Long expenseId, Long tagId) {
        return expenseTagRepository.getExpenseTagByExpenseIdAndTagId(expenseId, tagId);
    }

    public ExpenseReminder getExpenseReminder(Long expenseId, Long reminderId) {
        return expenseReminderRepository.getExpenseReminderByExpenseIdAndReminderId(expenseId, reminderId);
    }

    public ExpenseTopic getExpenseTopic(Long expenseId, Long topicId) {
        return expenseTopicRepository.getExpenseTopicByExpenseIdAndTopicId(expenseId, topicId);
    }

    public ExpenseTasks getExpenseTasks(Long expenseId, Long tasksId) {
        return expenseTasksRepository.getExpenseTasksByExpenseIdAndTasksId(expenseId, tasksId);
    }


    //-- getExpensesAnd


    public Expenses getExpensesFromUserIdAndExpensesId(Long userId, Long expensesId) {
        return expensesRepository.getExpensesFromUserIdByExpensesId(userId, expensesId);
    }

    public ExpensesUser getExpensesUser(Long expensesId, Long userId) {
        return expensesUserRepository.getExpensesUserByExpensesIdAndUserId(expensesId, userId);
    }

    public ExpensesTag getExpensesTag(Long expensesId, Long tagId) {
        return expensesTagRepository.getExpensesTagByExpensesIdAndTagId(expensesId, tagId);
    }

    public ExpensesReminder getExpensesReminder(Long expensesId, Long reminderId) {
        return expensesReminderRepository.getExpensesReminderByExpensesIdAndReminderId(expensesId, reminderId);
    }

    public ExpensesTopic getExpensesTopic(Long expensesId, Long topicId) {
        return expensesTopicRepository.getExpensesTopicByExpensesIdAndTopicId(expensesId, topicId);
    }

    public ExpensesTasks getExpensesTasks(Long expensesId, Long tasksId) {
        return expensesTasksRepository.getExpensesTasksByExpensesIdAndTasksId(expensesId, tasksId);
    }

    public ExpensesExpense getExpensesExpense(Long expensesId, Long expenseId) {
        return expensesExpenseRepository.getExpensesExpenseByExpensesIdAndExpenseId(expensesId, expenseId);
    }

    public ExpensesPerson getExpensesPerson(Long expensesId, Long personId) {
        return expensesPersonRepository.getExpensesPersonByExpensesIdAndPersonId(expensesId, personId);
    }

    public ExpensesShop getExpensesShop(Long expensesId, Long shopId) {
        return expensesShopRepository.getExpensesShopByExpensesIdAndShopId(expensesId, shopId);
    }

    //-- getTransactionAnd


    public Transaction getTransactionFromUserIdAndTransactionId(Long userId, Long transactionId) {
        return transactionRepository.getTransactionFromUserIdByTransactionId(userId, transactionId);
    }

    public TransactionUser getTransactionUser(Long transactionId, Long userId) {
        return transactionUserRepository.getTransactionUserByTransactionIdAndUserId(transactionId, userId);
    }

    public TransactionTag getTransactionTag(Long transactionId, Long tagId) {
        return transactionTagRepository.getTransactionTagByTransactionIdAndTagId(transactionId, tagId);
    }

    public TransactionReminder getTransactionReminder(Long transactionId, Long reminderId) {
        return transactionReminderRepository.getTransactionReminderByTransactionIdAndReminderId(transactionId, reminderId);
    }

    public TransactionTopic getTransactionTopic(Long transactionId, Long topicId) {
        return transactionTopicRepository.getTransactionTopicByTransactionIdAndTopicId(transactionId, topicId);
    }

    public TransactionTasks getTransactionTasks(Long transactionId, Long tasksId) {
        return transactionTasksRepository.getTransactionTasksByTransactionIdAndTasksId(transactionId, tasksId);
    }

    //-- getEmailAnd

    public List<Email> getEmailListFromUserId(Long userId) {
        return emailRepository.getEmailListFromUserId(userId);
    }

    public Email getEmailFromUserIdByEmailAddress(Long userId, String emailAddress) {
        return emailRepository.getEmailFromUserIdByEmailAddress(userId, emailAddress);
    }

    public Email getEmailFromUserIdAndEmailId(Long userId, Long emailId) {
        return emailRepository.getEmailFromUserIdByEmailId(userId, emailId);
    }

    public EmailUser getEmailUser(Long emailId, Long userId) {
        return emailUserRepository.getEmailUserByEmailIdAndUserId(emailId, userId);
    }

    public EmailTag getEmailTag(Long emailId, Long tagId) {
        return emailTagRepository.getEmailTagByEmailIdAndTagId(emailId, tagId);
    }

    public EmailReminder getEmailReminder(Long emailId, Long reminderId) {
        return emailReminderRepository.getEmailReminderByEmailIdAndReminderId(emailId, reminderId);
    }

    public EmailTopic getEmailTopic(Long emailId, Long topicId) {
        return emailTopicRepository.getEmailTopicByEmailIdAndTopicId(emailId, topicId);
    }

    public EmailTasks getEmailTasks(Long emailId, Long tasksId) {
        return emailTasksRepository.getEmailTasksByEmailIdAndTasksId(emailId, tasksId);
    }

    //-- getDatesAnd


    public Dates getDatesFromUserIdAndDatesId(Long userId, Long datesId) {
        return datesRepository.getDatesFromUserIdByDatesId(userId, datesId);
    }

    public DatesUser getDatesUser(Long datesId, Long userId) {
        return datesUserRepository.getDatesUserByDatesIdAndUserId(datesId, userId);
    }

    public DatesTag getDatesTag(Long datesId, Long tagId) {
        return datesTagRepository.getDatesTagByDatesIdAndTagId(datesId, tagId);
    }

    public DatesReminder getDatesReminder(Long datesId, Long reminderId) {
        return datesReminderRepository.getDatesReminderByDatesIdAndReminderId(datesId, reminderId);
    }

    public DatesTopic getDatesTopic(Long datesId, Long topicId) {
        return datesTopicRepository.getDatesTopicByDatesIdAndTopicId(datesId, topicId);
    }

    public DatesTasks getDatesTasks(Long datesId, Long tasksId) {
        return datesTasksRepository.getDatesTasksByDatesIdAndTasksId(datesId, tasksId);
    }


    //-- getPhoneNumberAnd


    public PhoneNumber getPhoneNumberFromUserIdAndPhoneNumberId(Long userId, Long phoneNumberId) {
        return phoneNumberRepository.getPhoneNumberFromUserIdByPhoneNumberId(userId, phoneNumberId);
    }

    public PhoneNumberUser getPhoneNumberUser(Long phoneNumberId, Long userId) {
        return phoneNumberUserRepository.getPhoneNumberUserByPhoneNumberIdAndUserId(phoneNumberId, userId);
    }

    public PhoneNumberTag getPhoneNumberTag(Long phoneNumberId, Long tagId) {
        return phoneNumberTagRepository.getPhoneNumberTagByPhoneNumberIdAndTagId(phoneNumberId, tagId);
    }

    public PhoneNumberReminder getPhoneNumberReminder(Long phoneNumberId, Long reminderId) {
        return phoneNumberReminderRepository.getPhoneNumberReminderByPhoneNumberIdAndReminderId(phoneNumberId, reminderId);
    }

    public PhoneNumberTopic getPhoneNumberTopic(Long phoneNumberId, Long topicId) {
        return phoneNumberTopicRepository.getPhoneNumberTopicByPhoneNumberIdAndTopicId(phoneNumberId, topicId);
    }

    public PhoneNumberTasks getPhoneNumberTasks(Long phoneNumberId, Long tasksId) {
        return phoneNumberTasksRepository.getPhoneNumberTasksByPhoneNumberIdAndTasksId(phoneNumberId, tasksId);
    }

    //-- getAccountAnd


    public Account getAccountFromUserIdAndAccountId(Long userId, Long accountId) {
        return accountRepository.getAccountFromUserIdByAccountId(userId, accountId);
    }

    public AccountUser getAccountUser(Long accountId, Long userId) {
        return accountUserRepository.getAccountUserByAccountIdAndUserId(accountId, userId);
    }

    public AccountTag getAccountTag(Long accountId, Long tagId) {
        return accountTagRepository.getAccountTagByAccountIdAndTagId(accountId, tagId);
    }

    public AccountReminder getAccountReminder(Long accountId, Long reminderId) {
        return accountReminderRepository.getAccountReminderByAccountIdAndReminderId(accountId, reminderId);
    }

    public AccountTopic getAccountTopic(Long accountId, Long topicId) {
        return accountTopicRepository.getAccountTopicByAccountIdAndTopicId(accountId, topicId);
    }

    public AccountTasks getAccountTasks(Long accountId, Long tasksId) {
        return accountTasksRepository.getAccountTasksByAccountIdAndTasksId(accountId, tasksId);
    }

    public AccountExpenses getAccountExpenses(Long accountId, Long expensesId) {
        return accountExpensesRepository.getAccountExpensesByAccountIdAndExpensesId(accountId, expensesId);
    }

    public AccountTransaction getAccountTransaction(Long accountId, Long transactionId) {
        return accountTransactionRepository.getAccountTransactionByAccountIdAndTransactionId(accountId, transactionId);
    }

    public AccountTransaction getAccountTransactionByDirection(String direction, Long transactionId) {
        return accountTransactionRepository.getAccountTransactionByDirectionAndTransactionId(direction, transactionId);
    }

    //--------------------------


    //-- getTopic
    public Topic getTopicFromUserIdByTopicId(Long userId, Long topicId) {
        return topicRepository.getTopicFromUserIdByTopicId(userId, topicId);
    }

    //-- getWork

    public Work getWorkByUserIdAndWorkId(Long userId, Long workId) {
        return workRepository.getWorkFromUserIdByWorkId(userId, workId);
    }

    //-- Converter

    public TaskStatus convertTaskStatusTextToTaskStatus(String taskStatusText) {
        TaskStatus taskStatus;
        switch (taskStatusText) {
            case "STARTED":
                taskStatus = TaskStatus.STARTED;
                break;
            case "WORKING":
                taskStatus = TaskStatus.WORKING;
                break;
            case "PENDING":
                taskStatus = TaskStatus.PENDING;
                break;
            case "COMPLETED":
                taskStatus = TaskStatus.COMPLETED;
                break;
            default:
                taskStatus = TaskStatus.UNDEFINE;
                break;
        }
        return taskStatus;
    }

    public TransactionStatus convertTransactionStatusTextToTransactionStatus(String transactionStatusText) {
        TransactionStatus transactionStatus;
        switch (transactionStatusText) {
            case "CREATED":
                transactionStatus = TransactionStatus.CREATED;
                break;
            case "PLANED":
                transactionStatus = TransactionStatus.PLANED;
                break;
            case "PENDING":
                transactionStatus = TransactionStatus.PENDING;
                break;
            case "COMPLETED":
                transactionStatus = TransactionStatus.COMPLETED;
                break;
            default:
                transactionStatus = TransactionStatus.UNDEFINE;
                break;
        }
        return transactionStatus;
    }

    public ExpensesStatus convertExpensesStatusTextToExpensesStatus(String expensesStatusText) {
        ExpensesStatus expensesStatus;
        switch (expensesStatusText) {
            case "CREATED":
                expensesStatus = ExpensesStatus.CREATED;
                break;
            case "PLANED":
                expensesStatus = ExpensesStatus.PLANED;
                break;
            case "PENDING":
                expensesStatus = ExpensesStatus.PENDING;
                break;
            case "COMPLETED":
                expensesStatus = ExpensesStatus.COMPLETED;
                break;
            default:
                expensesStatus = ExpensesStatus.UNDEFINE;
                break;
        }
        return expensesStatus;
    }
}
