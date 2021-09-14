package com.interinfo.rasa_action.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interinfo.rasa_action.server.controller.dto.RegisteredAction;
import com.interinfo.rasa_action.server.controller.dto.Status;

import io.github.rbajek.rasa.sdk.ActionExecutor;
import io.github.rbajek.rasa.sdk.dto.ActionRequest;
import io.github.rbajek.rasa.sdk.dto.ActionResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rafał Bajek
 */
@RestController
@RequestMapping("/")
@Slf4j
public class EndpointController {

    @Autowired
    private ActionExecutor rasaActionExecutor;

    /**
     * The main entry point
     *
     * @return info about the action server
     */
    @GetMapping("/")
    public String home() {
        return "Rasa action server is up and running";
    }

    /**
     * Ping endpoint to check if the server is running and well.
     *
     * @return status of action server
     */
    @GetMapping("/health")
    public Status health() {
        return new Status("ok");
    }

    /**
     * List all registered actions.
     *
     * @return
     */
    @GetMapping("/actions")
    public List<RegisteredAction> actions() {
        return rasaActionExecutor.getRegisteredActionNames().stream().map(actionName -> new RegisteredAction((actionName))).collect(Collectors.toList());
   }

   @PostMapping("/webhook")
   public ActionResponse webhook(@RequestBody ActionRequest actionRequest) {
   		log.info("show format date{}", actionRequest);
        return rasaActionExecutor.run(actionRequest);
   }
}
