//How to display information to the log while troubleshooting

import org.apache.log4j.Logger
import org.apache.log4j.Level
  
def log = Logger.getLogger("com.acme.CreateSubtask")
log.setLevel(Level.DEBUG)
  
log.debug "foo bar"

//How to access issue custom field and value
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

CustomField num1 = customFieldManager.getCustomFieldObjectByName("Num1");
log.debug(num1);

def num1Val = issue.getCustomFieldValue(num1).toString();
log.debug(num1Val);
