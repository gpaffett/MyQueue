package net.paffett.test.harness;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import net.paffett.MyQueue;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "displayList", "queue" })
@Scope("session")
public class TestHarnessController {

  @RequestMapping(value = "/queueTest", method = RequestMethod.GET)
  public String showHarness(Model model) {
    model.addAttribute("displayList", new ArrayList<String>());
    model.addAttribute("queue", new MyQueue());
    model.addAttribute("objectToAdd", new TestModelObject());

    return "queueTestHarness";
  }

  @RequestMapping(value="/addToQueue", method=RequestMethod.POST)
  public String addToQueue(@ModelAttribute("objectToAdd") TestModelObject objectToAdd, @ModelAttribute("queue") MyQueue queue, 
      @ModelAttribute("displayList") ArrayList<TestModelObject> displayList, Model model) {
      displayList.add(objectToAdd);
      queue.addBack(objectToAdd);
      model.addAttribute("objectToAdd", new TestModelObject());
      return "queueTestHarness";
  }

  @RequestMapping(value = "/removeFromQueue", method = RequestMethod.POST)
  public String removeFromQueue(@ModelAttribute("queue") MyQueue queue,
      @ModelAttribute("displayList") List<TestModelObject> displayList,
      Model model) {
    if (displayList.size() > 0) {
      displayList.remove(0);
    }
    
    try {
      model.addAttribute("popped", queue.removeFront());  
    } catch (EmptyStackException e) {
      TestModelObject emptyQueue = new TestModelObject();
      emptyQueue.setValue("Nothing to remove!");
      model.addAttribute("popped", emptyQueue);
    }
    
    model.addAttribute("objectToAdd", new TestModelObject());

    return "queueTestHarness";
  }

}