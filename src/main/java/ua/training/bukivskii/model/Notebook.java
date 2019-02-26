package ua.training.bukivskii.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Notebook {
    private CopyOnWriteArrayList<Abonent> abonents;

    public Notebook(){
        abonents = new CopyOnWriteArrayList<>();
    }
    public String addAbonent(Abonent abonentToAdd) throws LoginAlreadyExistsException {
        if(getListOfAbonentLogins().toString().contains(abonentToAdd.getNickName())){
           throw new LoginAlreadyExistsException(abonentToAdd) ;
        }

        abonents.add(new Abonent(abonentToAdd));
        return abonentToAdd.getNickName();
    }

//    public Abonent getAbonentByLogin(String loginToFind) {
//        for (Abonent ab:  abonents){
//            if (ab.getNickName().equals(loginToFind)){
//                return ab;
//            }
//        }
//        return null;
//    }
    public CopyOnWriteArrayList<String> getListOfAbonentLogins(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for(Abonent ab:abonents){
            list.add(ab.getNickName());
        }
        return list;
    }
    public CopyOnWriteArrayList<Abonent> getAbonents(){
        return this.abonents; // TODO clone?
    }
}
