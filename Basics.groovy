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

return num1Val;


//How to get the number of attachments on an issue
import com.atlassian.jira.component.ComponentAccessor

def attachmentManager = ComponentAccessor.getAttachmentManager()
def numberAttachments = attachmentManager.getAttachments(issue).size()

// use the following instead for number of PDFs
//def numberAttachments = attachmentManager.getAttachments(issue).findAll {a ->
//    a.filename.toLowerCase().endsWith(".pdf")
//}.size()

return numberAttachments ? numberAttachments as Double : null


//Examples of how to get some information on an issue
//Full list of options at https://docs.atlassian.com/software/jira/docs/api/7.13.5/com/atlassian/jira/issue/Issue.html
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.*
import org.apache.log4j.Logger
import org.apache.log4j.Level
    
    
def log = Logger.getLogger("com.acme.CreateSubtask")
log.setLevel(Level.DEBUG)

log.debug(issue.getCreated());
log.debug(issue.getId());
log.debug(issue.getAssignee());
log.debug(issue.getAssigneeId());
log.debug(issue.getIssueType());
log.debug(issue.getIssueTypeId());
log.debug(issue.getStatus());
log.debug(issue.getSummary());



//Change history (in this example anytime the Status was changed)
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.history.ChangeItemBean
import com.atlassian.jira.issue.*
import org.apache.log4j.Logger
import org.apache.log4j.Level

def log = Logger.getLogger("com.acme.CreateSubtask")
log.setLevel(Level.DEBUG)

def changeHistoryManager = ComponentAccessor.getChangeHistoryManager();
def changeItems = changeHistoryManager.getChangeItemsForField(issue, "status");

changeItems.each() {ChangeItemBean item ->
    log.debug(item);                  
}