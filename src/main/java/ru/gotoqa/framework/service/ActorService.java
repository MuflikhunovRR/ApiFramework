package ru.gotoqa.framework.service;

import ru.gotoqa.framework.api.actor.ActorCast;

import java.util.List;

public interface ActorService {

    List<ActorCast> getActorList(String url);
}
