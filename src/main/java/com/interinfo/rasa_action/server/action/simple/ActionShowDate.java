package com.interinfo.rasa_action.server.action.simple;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import io.github.rbajek.rasa.sdk.CollectingDispatcher;
import io.github.rbajek.rasa.sdk.action.Action;
import io.github.rbajek.rasa.sdk.dto.Domain;
import io.github.rbajek.rasa.sdk.dto.Tracker;
import io.github.rbajek.rasa.sdk.dto.event.AbstractEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * Custom action for Show Date
 *
 * @author Rafał Bajek
 */
@Component
@Slf4j
public class ActionShowDate implements Action {

    @Override
    public String name() {
        return "action_show_date";
    }

    @Override
    public List<AbstractEvent> run(CollectingDispatcher dispatcher, Tracker tracker, Domain domain) {
        // make an API call
    	log.info("show format date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // send the message back to the user
        dispatcher.utterMessage(sdf.format(new Date()));

        return Collections.emptyList();
    }

}
