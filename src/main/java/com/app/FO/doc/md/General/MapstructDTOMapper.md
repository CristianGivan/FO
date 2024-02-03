Mapstruct DTO Mapper

- When adding a list to a FDTO
1. Update the FDTO with the list that is needed to be included and update constructor toString and geters seters
```java
    private List<TagDTO> tagDTOList;
```
2. Add @Mapping for this list
```java
    @Mapping(target = "tagDTOList", expression = "java(" +
            "tagDTOMapper.tagListToTagDTOList(allServices.getTagListDTOByUser(user))" +
            ")")
```
4. Add @Autowired AllServices to can query for the list. 
If is added services by services I will receive circula dependencies
```java
 @Autowired
    protected AllServices allServices;
```
2. Add @Autowired DTOMapper for the list is needed to be created
```java
 @Autowired
    protected TagDTOMapper tagDTOMapper;
```
3. Add in uses the mappers needed
```java
@Mapper(componentModel = "spring", uses = {TagDTOMapper.class})
```