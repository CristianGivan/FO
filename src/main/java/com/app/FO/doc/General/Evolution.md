# 230617

```
 public Tag postTag(String tagText){
        User user=userService.getLogInUser();
        checksTag.checkIsTagWithTagText(user,tagText);
        Tag tag=new Tag(tagText,user);
        TagUser tagUser=new TagUser(tag,user);
        tag.getTagUserList().add(tagUser);
        return tagRepository.save(tag);
        }

public Tag postTag(String subject){
        User logInUser=serviceAll.getLogInUser();

        Tag tag=tagRepository.getTagFromUserIdBySubject(logInUser.getId(),subject);
        if(tag!=null){
        throw new TagAlreadyExistException("Tag with this subject already exist");
        }

        tag=tagRepository.save(new Tag(subject,logInUser));

        TagUser tagUser=new TagUser(tag,logInUser);
        tag.getTagUserList().add(tagUser);

        return tagRepository.save(tag);
        }
```