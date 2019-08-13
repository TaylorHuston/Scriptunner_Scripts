//Add up how long an issue has been in a specific status, cumulatively

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.history.ChangeItemBean
import com.atlassian.jira.issue.*
import org.apache.log4j.Logger
import org.apache.log4j.Level

def log = Logger.getLogger("com.acme.CreateSubtask");
log.setLevel(Level.DEBUG);

def changeHistoryManager = ComponentAccessor.getChangeHistoryManager();
def changeItems = changeHistoryManager.getChangeItemsForField(issue, "status");
def statusName = "Selected for Development";

def total = 0;

//Uncomment this line if the status you're checking is the initial status (ie Backlog), it will add in the time before the first change event
//total += (System.currentTimeMillis() - issue.getCreated().getTime());


changeItems.each {ChangeItemBean item ->
    def timeSinceStatus = System.currentTimeMillis() - item.created.getTime(); //The difference in time from now and when the issue entered this status
    log.debug(item);
    log.debug((timeSinceStatus) as long);
    if (item.fromString == statusName) { //If issue was leaving status
        total -= timeSinceStatus;
    }
    if (item.toString == statusName) { //If issue was moving into status 
    	total += timeSinceStatus;
    }
    log.debug(total);
    log.debug(" ");
}

log.debug(total);
return total/1000 as Long;