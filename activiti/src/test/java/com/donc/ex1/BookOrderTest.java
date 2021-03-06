package com.donc.ex1;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by donovan on 15/05/13.
 */
public class BookOrderTest {
    @Test
    public void startBookOrder() {
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration()
                .buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        IdentityService identityService = processEngine.getIdentityService();
        TaskService taskService = processEngine.getTaskService();
        repositoryService.createDeployment()
                .addClasspathResource("chapter1/bookorder.bpmn20.xml")
                .deploy();

        // remove tasks already present
        List<Task> availableTaskList = taskService.createTaskQuery().taskName("Work on order").list();
        for (Task task : availableTaskList) {
            taskService.complete(task.getId());
        }

        Map<String, Object> variableMap = new HashMap<String, Object>();
        variableMap.put("isbn", "123456");
        identityService.setAuthenticatedUserId("kermit");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
                "bookorder", variableMap);
        assertNotNull(processInstance.getId());
        List<Task> taskList = taskService.createTaskQuery().taskName("Work on order").list();
        assertEquals(1, taskList.size());
        System.out.println("found task " + taskList.get(0).getName());
    }
}
