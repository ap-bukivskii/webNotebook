package ua.training.bukivskii.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Notebook {
    private CopyOnWriteArrayList<Abonent> abonents;
    private CopyOnWriteArrayList<String> reservedLogins;

    public Notebook(){
        abonents = new CopyOnWriteArrayList<>();
        reservedLogins = new CopyOnWriteArrayList<>();
        reservedLogins.add("viktor");
        reservedLogins.add("hector");
        reservedLogins.add("tolik");
    }
    public String addAbonent(Abonent abonentToAdd) throws LoginAlreadyExistsException {
        if(getListOfAbonents().toString().contains(abonentToAdd.getNickName())){
           throw new LoginAlreadyExistsException(abonentToAdd) ;
        }
        if(reservedLogins.toString().contains(abonentToAdd.getNickName())){
            throw new LoginAlreadyExistsException(abonentToAdd) ;
        }

        abonents.add(new Abonent(abonentToAdd));
        System.out.println("added abonent " + abonentToAdd.getNickName());
        return abonentToAdd.getNickName();
    }

    public Abonent getAbonentByLogin(String loginToFind) {
        for (Abonent ab:  abonents){
            if (ab.getNickName().equals(loginToFind)){
                return ab;
            }
        }
        return null;
    }
    public CopyOnWriteArrayList<String> getListOfAbonents(){
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
