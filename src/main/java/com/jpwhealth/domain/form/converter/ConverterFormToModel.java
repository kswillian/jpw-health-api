package com.jpwhealth.domain.form.converter;

import com.jpwhealth.domain.Family;
import com.jpwhealth.domain.News;
import com.jpwhealth.domain.Topic;
import com.jpwhealth.domain.form.*;

import java.util.List;

public class ConverterFormToModel {

    public static Topic toTopic(TopicForm form){
        Topic topic = new Topic();
        topic.setName(form.getName());
        return topic;
    }

    public static Topic toTopic(TopicFormUpdate form){
        Topic topic = new Topic();
        topic.setId(form.getId());
        topic.setName(form.getName());
        return topic;
    }

    public static News toNews(NewsForm newsForm, List<Topic> topics){
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setSubTitle(newsForm.getSubTitle());
        news.setAuthor(newsForm.getAuthor());
        news.setImageUrl(newsForm.getImageUrl());
        news.setMessage(newsForm.getMessage());
        news.setTopics(topics);
        return news;
    }

    public static News toNews(NewsFormUpdate newsFormUpdate, List<Topic> topics){
        News news = new News();
        news.setId(newsFormUpdate.getId());
        news.setTitle(newsFormUpdate.getTitle());
        news.setSubTitle(newsFormUpdate.getSubTitle());
        news.setAuthor(newsFormUpdate.getAuthor());
        news.setImageUrl(newsFormUpdate.getImageUrl());
        news.setMessage(newsFormUpdate.getMessage());
        news.setTopics(topics);
        return news;
    }

    public static Family toFamily(FamilyForm familyForm){
        Family family = new Family();
        family.setFamilyName(familyForm.getFamilyName());
        family.setFamilyResponsible(familyForm.getFamilyResponsible());
        family.setResponsibleCPF(familyForm.getResponsibleCPF());
        family.setResponsibleRG(familyForm.getResponsibleRG());
        family.setDateBirth(familyForm.getDateBirth());
        family.setAdultsNumber(familyForm.getAdultsNumber());
        family.setChildrenNumber(familyForm.getChildrenNumber());
        family.setUnemployedNumber(familyForm.getUnemployedNumber());
        family.setFamilyFinance(familyForm.getFamilyFinance());
        family.setResponsibleSex(familyForm.getResponsibleSex());
        family.setObservation(familyForm.getObservation());
        family.setAddress(familyForm.getAddress());
        return family;
    }

    public static Family toFamily(FamilyFormUpdate familyFormUpdate){
        Family family = new Family();
        family.setId(familyFormUpdate.getId());
        family.setFamilyName(familyFormUpdate.getFamilyName());
        family.setFamilyResponsible(familyFormUpdate.getFamilyResponsible());
        family.setResponsibleCPF(familyFormUpdate.getResponsibleCPF());
        family.setResponsibleRG(familyFormUpdate.getResponsibleRG());
        family.setDateBirth(familyFormUpdate.getDateBirth());
        family.setAdultsNumber(familyFormUpdate.getAdultsNumber());
        family.setChildrenNumber(familyFormUpdate.getChildrenNumber());
        family.setUnemployedNumber(familyFormUpdate.getUnemployedNumber());
        family.setFamilyFinance(familyFormUpdate.getFamilyFinance());
        family.setResponsibleSex(familyFormUpdate.getResponsibleSex());
        family.setObservation(familyFormUpdate.getObservation());
        family.setAddress(familyFormUpdate.getAddress());
        return family;
    }

}
