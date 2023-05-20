- cum adica relatie bidirectionala la entitati? gen one to many
  -@enbedebal sa aincepem entitati fara legatura

pt Oli particular

- am gandit bine cu DTO-ul ca sa fac fnctia normala dupa aia o functie care face return DTO si duapa aia FDTO?
  cum ar fi ami bine sa o bag direct in Controller sau sa ramana in service?
- aveam acea problema cu tag service cu salvatul

pt Oli general

- [ ] Chiar trebuie sa folosim mapper sau sa punem sa trimitem obiectul gen note

----------------------------------------------------------------------------
Rezolvat
----------------------------------------------------------------------------

- este bine cum mi-am structurat DTO-urile?
- cum facem sa dam acces doar la userul care ii logat acces la ce a facut el
    - nu prin filtre prin metode
- cum faci u JSON o singura linie?


## Best Practice

### 1. Fail Fast or all checks in one place:

a. Fail fast

```java
        User user=userRepository.getUserByUserId(userId);
        if(user==null){
            throw new UserNotFoundException("User not found");
        }

        Role role=roleService.findRoleByType(roleType);
        if(role==null){
            throw new RoleNotFoundException("Role not found");
        }
```

```
b. Create a method where there are all the checks

```java
        User user=userRepository.getUserByUserId(userId);
            Role role=roleService.findRoleByType(roleType);
        checksUser.checkIsUserAndRoleAndAreNotLinked(user,role);
```

```java
 public void checkIsUserAndRoleAndAreNotLinked(User user,Role role){
        if(user==null){
            throw new UserNotFoundException("User not found");
        }else if(role==null){
            throw new RoleNotFoundException("Role not found");
        }else if(checks.userHasRole(user,role)){
            throw new RoleAlreadyExistException("Role is already mapped to the user");
        }
        }
```
