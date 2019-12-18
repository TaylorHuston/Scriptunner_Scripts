// https://scriptrunner.adaptavist.com/latest/jira/scripted-fields.html

import com.atlassian.jira.ComponentAccessor
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.ComponentManager
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.jira.issue.Issue

import org.apache.log4j.Logger
import org.apache.log4j.Level
  
def log = Logger.getLogger("com.acme.CreateSubtask")
log.setLevel(Level.DEBUG)

def componentManager = ComponentManager.getInstance();
CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager();

//Num1 and Num2 are just generic Number custom fields I created
CustomField num1 = customFieldManager.getCustomFieldObjectByName("Num1");
CustomField num2 = customFieldManager.getCustomFieldObjectByName("Num2");

log.debug(num1);

def num1Val = issue.getCustomFieldValue(num1).toString();
def num2Val = issue.getCustomFieldValue(num2).toString();
log.debug(num1Val);
log.debug(num2Val);

if (num1Val && num2Val) {
    return Double.parseDouble(num1Val)+Double.parseDouble(num2Val);
} else {
    return null;
}