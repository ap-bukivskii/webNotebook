package ua.training.bukivskii.controller;

import ua.training.bukivskii.model.Abonent;
import ua.training.bukivskii.model.Groups;

import javax.servlet.http.HttpServletRequest;

public class webController {

    public static boolean requestIsValid(final HttpServletRequest req) {

        //req.getParameterNames();
        if(!req.getParameter("firstName").matches(Regexps.firstNameRegexp)){
            return false;
        }
        if(!req.getParameter("lastName").matches(Regexps.lastNameRegexp)){
            return false;
        }
        if(!req.getParameter("middleName").matches(Regexps.middleNameRegexp)){
            return false;
        }
        if(!req.getParameter("login").matches(Regexps.loginRegexp)){
            return false;
        }
        if(!req.getParameter("comment").matches(Regexps.commentRegexp)){
            return false;
        }
        if(!req.getParameter("groups").matches(Regexps.groupsRegexp)){
            return false;
        }
        if(!req.getParameter("homePhone").matches(Regexps.homePhoneNumberRegexp)){
            return false;
        }
        if(!req.getParameter("cellPhone").matches(Regexps.cellPhoneNumberRegexp)){
            return false;
        }
        if(!req.getParameter("cellPhone2").matches(Regexps.cellPhoneNumber2Regexp)){
            return false;
        }
        if(!req.getParameter("email").matches(Regexps.emailRegexp)){
            return false;
        }
        if(!req.getParameter("skypeName").matches(Regexps.skypeNameRegexp)){
            return false;
        }
        if(!req.getParameter("index").matches(Regexps.indexRegexp)){
            return false;
        }
        if(!req.getParameter("city").matches(Regexps.cityRegexp)){
            return false;
        }
        if(!req.getParameter("street").matches(Regexps.streetRegexp)){
            return false;
        }
        if(!req.getParameter("house").matches(Regexps.houseRegexp)){
            return false;
        }
        if(!req.getParameter("appartment").matches(Regexps.appartmentRegexp)){
            return false;
        }

        return true;
    }

    public static Abonent createAbonent(final HttpServletRequest request){
        Abonent tempAbonent = new Abonent();

        tempAbonent.setFirstName(request.getParameter("firstName"));
        tempAbonent.setLastName(request.getParameter("lastName"));
        tempAbonent.setMiddleName(request.getParameter("middleName"));
        tempAbonent.setNickName(request.getParameter("login"));
        tempAbonent.generateShortName();
        tempAbonent.setComment(request.getParameter("comment"));
        addGroups(request.getParameter("groups"), tempAbonent);
        tempAbonent.setHomePhoneNumber(request.getParameter("homePhone"));
        tempAbonent.setCellPhoneNumber(request.getParameter("cellPhone"));
        tempAbonent.setCellPhoneNumber2(request.getParameter("cellPhone2"));
        tempAbonent.setEmail(request.getParameter("email"));
        tempAbonent.setSkypeName(request.getParameter("skypeName"));
        tempAbonent.setIndex(request.getParameter("index"));
        tempAbonent.setCity(request.getParameter("city"));
        tempAbonent.setStreet(request.getParameter("street"));
        tempAbonent.setHouse(request.getParameter("house"));
        tempAbonent.setAppartment(request.getParameter("appartment"));
        tempAbonent.generateAdressLong();

        return tempAbonent;
    }

    private static void addGroups(String groupsToAdd,Abonent abonent){
        for(Groups gr: Groups.values()) {

            if (groupsToAdd.contains(gr.getName()) || groupsToAdd.contains(Integer.toString(gr.getGroupID()))) {
                abonent.addGroup(gr);
            }
        }
    }
}
