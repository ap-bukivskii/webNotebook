package ua.training.bukivskii.view;

import ua.training.bukivskii.model.Abonent;
import ua.training.bukivskii.model.Groups;
import ua.training.bukivskii.model.Notebook;

import java.util.concurrent.CopyOnWriteArrayList;

public class webView {

    public static CopyOnWriteArrayList <String> notebookToWebList(Notebook nb){
        CopyOnWriteArrayList <String> notes = new CopyOnWriteArrayList<>();
        for(Abonent ab: nb.getAbonents()){
            notes.add(abonentToWebString(ab));
        }
        return notes;
    }

    private static String abonentToWebString (Abonent ab){ //TODO where to form view? here or in jsp?
        StringBuilder res = new StringBuilder("<b>"+ ab.getNickName() + "</b><br>");
        res.append("<ul><li>First name: ").append(ab.getFirstName()).append("</li>");
        res.append("<li>Last name: ").append(ab.getLastName()).append("</li>");
        res.append("<li>Middle name: ").append(ab.getMiddleName()).append("</li>");
        res.append("<li>Comment: ").append(ab.getComment()).append("</li>");
        res.append("<li>Is in groups: ");
        for(Groups g: ab.getGroups()) {
            res.append(g.name).append(" ");
        }
        res.append("</li>");
        res.append("<li>Home phone number: ").append(ab.getHomePhoneNumber()).append("</li>");
        res.append("<li>Cell phone number: ").append(ab.getCellPhoneNumber()).append("</li>");
        res.append("<li>Second cell phone: ").append(ab.getCellPhoneNumber2()).append("</li>");
        res.append("<li>E-mail: ").append(ab.getEmail()).append("</li>");
        res.append("<li>Skype name: ").append(ab.getSkypeName()).append("</li>");
        res.append("<li>Address: ").append(ab.getAdressLong()).append("</li></ul>");

        return new String(res);
    }
}
